package jp.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * JSONのパース
 * 
 * @author kichi
 *
 */
public class SampleJSONMain {
	public static void main(String[] args) throws Exception {
		String[] targetForJackson = { "リンゴ", "オレンジ", "パイナップル" };
		String[] targetForGson = { "ブドウ", "レモン", "チェリーブロッサム" };
		useJacson(targetForJackson);
		useGson(targetForGson);
	}

	/**
	 * jacksonで配列をパースする
	 * 
	 * @param target
	 * @throws Exception
	 */
	private static void useJacson(String[] target) throws Exception {
		// Jackson
		// javaオブジェクトからJSON
		ObjectMapper om = new ObjectMapper();
		String jacksonResult = om.writeValueAsString(target);
		System.out.println(jacksonResult);
		for (String res : target) {
			System.out.println(res);
		}

		// JSONからjavaオブジェクト
		String jasonData = "[\"バナナ\", \"メロン\"]";
		System.out.println(jasonData);
		String[] parseResult = om.readValue(jasonData, String[].class);
		for (String res : parseResult) {
			System.out.println(res);
		}
	}

	/**
	 * Gsonで配列をパースする
	 * 
	 * @param target
	 */
	private static void useGson(String[] target) {
		// Gson
		// javaオブジェクトからJSON
		Gson gson = new Gson();
		String gsonResult = gson.toJson(target);
		System.out.println(gsonResult);
		for (String res : target) {
			System.out.println(res);
		}

		// JSONからjavaオブジェクト
		String jsonData = "[\"キウイ\", \"マンゴー\"]";
		System.out.println(jsonData);
		String[] parseResult = gson.fromJson(jsonData, String[].class);
		for (String res : parseResult) {
			System.out.println(res);
		}
	}
}
