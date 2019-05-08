package test.Utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	private JsonUtil() {}

	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException("Json serialization error.", e);
		}
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		if (json == null || json.isEmpty()) {
			return null;
		}
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonMappingException e) {
			throw new RuntimeException("Json deserialization error.", e);
		} catch (IOException e) {
			throw new RuntimeException("Json io error.", e);
		}
	}

	public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
		if (json == null || json.isEmpty()) {
			return null;
		}
		try {
			return mapper.readValue(json, mapper.getTypeFactory()
					.constructCollectionType(List.class, clazz));
		} catch (JsonMappingException e) {
			throw new RuntimeException("Json deserialization error.", e);
		} catch (IOException e) {
			throw new RuntimeException("Json io error.", e);
		}
	}

	public static <T> List<T> fromJsonCustomListToList(String json, String listName, Class<T> clazz) {
		if (json == null || json.isEmpty()) {
			return null;
		}
		JSONArray array = null;
		try {
			array = new JSONArray(json);
			JSONObject object = array.getJSONObject(0);
			return fromJsonToList(object.getString(listName),clazz);
		} catch (JSONException e) {
			throw new RuntimeException("Json deserialization error.", e);
		}

	}

	public static Map<String, String> jsonStringToMap(String json) {
		try {
			return mapper.readValue(json, new TypeReference<Map<String, String>>(){ });
		} catch (IOException e) {
			throw new RuntimeException("Json io error.", e);
		}
	}
	
	public static Map<String, String> jsonStringToObjectMap(String json) {
		try {
			return mapper.readValue(json, new TypeReference<Map<String, Object>>(){ });
		} catch (IOException e) {
			throw new RuntimeException("Json io error.", e);
		}
	}

	public static <T> T jsonStringToSelectedMap(String jsonStr, Class<T> clazz, String mapKey) {
		try {
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JSONObject object = new JSONObject(jsonStr);
			return fromJson(object.getString(mapKey),clazz);
		} catch (Exception e) {
		}
		return null;
	}
	
	public static String map2Json(Map<String, Object> map) {
		return toJson(map);
	}
}
