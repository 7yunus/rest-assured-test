package org.example.test;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.test.model.rcbJsonResponse.RcbJsonResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

@Epic("Validate JSON response")
public class RCBAPIResponseTest {

    private static final Logger logger = LogManager.getLogger(RCBAPIResponseTest.class);

    public static RcbJsonResponse rcbJsonResponse;

    static {
        try {
            rcbJsonResponse = parseJson();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static RcbJsonResponse parseJson() throws IOException, ParseException {
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (org.json.simple.JSONObject)
                parser.parse(new FileReader("src/test/resources/rcb.json"));
        return gson.fromJson(String.valueOf(jsonObject), RcbJsonResponse.class);
    }

    @Test
    @Feature("Validate if number of foreign player present in team is as per rules")
    public void validateForeignPlayers() {
        int noOfPlayers = rcbJsonResponse.getPlayer().size();
        int actualForeignPlayers = 0, expectedForeignPlayers = 4;
        for (int player = 0; player < noOfPlayers; player++) {
            String playerCountry = rcbJsonResponse.getPlayer().get(player).getCountry();
            if (!playerCountry.equalsIgnoreCase("india")) {
                actualForeignPlayers++;
            }
        }
        logger.info("No. of foreign players:"+actualForeignPlayers);
        Assert.assertTrue(actualForeignPlayers <= expectedForeignPlayers,
                "Foreign player are more than 4, not allowed!");
    }

    @Test
    @Feature("Validate there is only one wicket keeper in team")
    public void validateWicketKeeper() {
        int noOfPlayers = rcbJsonResponse.getPlayer().size();
        int noOfWicketKeeper = 0, expectedWicketKeepers = 1;
        for (int player = 0; player < noOfPlayers; player++) {
            String playerRole = rcbJsonResponse.getPlayer().get(player).getRole();
            if (playerRole.equalsIgnoreCase("Wicket-keeper")) {
                noOfWicketKeeper++;
            }
        }
        logger.info("No. of wicket keeper:"+noOfWicketKeeper);
        Assert.assertEquals(noOfWicketKeeper, expectedWicketKeepers,
                "Wicket-Keepers are more than 1 or is missing in team");
    }
}