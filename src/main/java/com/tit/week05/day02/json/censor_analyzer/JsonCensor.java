package com.tit.week05.day02.json.censor_analyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class JsonCensor {
    private static String censorTeam(String teamName) {
        int spaceIndex = teamName.indexOf(" ");
        return (spaceIndex != -1) ? teamName.substring(0, spaceIndex) + " ***" : teamName;
    }
    //method to censor json file
    public static void censorJsonFile(String inputFile, String outputFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(inputFile));

            for (JsonNode match : root) {
                ((ObjectNode) match).put("team1", censorTeam(match.get("team1").asText()));
                ((ObjectNode) match).put("team2", censorTeam(match.get("team2").asText()));
                ((ObjectNode) match).put("winner", censorTeam(match.get("winner").asText()));
                ((ObjectNode) match).put("player_of_match", "REDACTED");
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), root);
            out.println("Censored JSON file created");

        } catch (IOException e) {
            out.println("exception - "+ e.getMessage());
        }
    }
}
