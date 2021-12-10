package br.com.projects.hotelreservationservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    /**
	 * Mount the message in JSON format.
	 * @return a Json with booking number.
	 */
	public static JsonNode convertMsgToJson(String field, String msg) {
		String json_str = "{\"" + field + "\":\"" + msg + "\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(json_str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
       	return node;
	}
}
