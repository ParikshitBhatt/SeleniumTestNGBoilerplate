package utilities;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import config.setup;
public class testdata_loader extends setup {
	//Test data source path(e.g. test_data.json)
	private static String projectPath = System.getProperty("user.dir");
	private static final String FILE_PATH = projectPath + "/src/test/resources/test_data.json";
	
	//This method will load data from JSON and return data
	public static Object[][] getTestData() {
        List<Object[]> testDataList = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            Iterator<?> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject userData = (JSONObject) iterator.next();
                String username = (String) userData.get("username");
                String password = (String) userData.get("password");
                String email = (String) userData.get("email");
                testDataList.add(new Object[]{username, password, email});
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Object[][] testData = new Object[testDataList.size()][];
        for (int i = 0; i < testDataList.size(); i++) {
            testData[i] = testDataList.get(i);
        }

        return testData;
    }
}
