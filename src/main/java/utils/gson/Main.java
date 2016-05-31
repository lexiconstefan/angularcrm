package utils.gson;

import com.google.gson.Gson;

public class Main {
	public static Gson gson = new Gson();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s =
		// "{\"municipality\":\"bromölla\",\"county\":\"skåne\",\"country\":\"se\",\"adress\":\"Granstigen
		// 4\",\"zip\":\"29538\"}";
		// Adress a = new Adress();
		// a.setAdress("Granstigen 4");
		// a.setCountry("se");
		// a.setCounty("skåne");
		// a.setMunicipality("bromölla");
		// a.setZip("29538");
		//
		// List<Adress> list = new ArrayList<Adress>();
		// list.add(a);
		//
		// String jsonListStr = GsonUtils.toJsonList(list);
		//
		// System.out.println(jsonListStr);
		// String jsonStr = GsonUtils.toJsonObj(a);
		// System.out.println(jsonStr);
		// Type collectionType = new TypeToken<List<Adress>>() {
		// }.getType();
		//
		// List<Adress> personList = GsonUtils.fromJsonToList(jsonStr,
		// collectionType);
		Test t = new Test();
		t.properties();
	}

	public static void properties() {

		System.out.println();
	}

}
