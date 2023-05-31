import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class Task3 {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Tests tests = objectMapper.readValue(new File(args[0]), Tests.class);
        List<Value> values = objectMapper.readValue(new File(args[1]), Values.class).values;

        for (Test test : tests.tests) {
            fillValue(test, values);
        }

        objectMapper.writeValue(new File("report.json"), tests);
    }

    private static void fillValue(Test test,
                                  List<Value> values) {
        findMatchValue(test, values);
        if (test.values != null) {
            for (Test subTest : test.values) {
                fillValue(subTest, values);
            }
        }
    }

    private static void findMatchValue(Test test,
                                       List<Value> values) {
        for (Value value : values) {
            if (value.id.equals(test.id)) {
                test.value = value.value;
                break;
            }
        }
    }

    private static class Tests {
        public List<Test> tests;
    }

    private static class Values {
        public List<Value> values;
    }

    @JsonInclude(Include.NON_NULL)
    private static class Test {
        public Integer id;
        public String title;
        public String value;
        public List<Test> values;
    }

    private static class Value {
        public Integer id;
        public String value;
    }

}