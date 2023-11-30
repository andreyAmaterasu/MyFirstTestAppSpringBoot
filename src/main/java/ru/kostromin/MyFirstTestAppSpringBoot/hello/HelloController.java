package ru.kostromin.MyFirstTestAppSpringBoot.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private List<String> arrayList;

  private Map<Integer, String> hashMap;

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

    return String.format("Hello %s!", name);
  }

  @GetMapping("/update-array")
  public void updateArrayList(@RequestParam(value = "value") String value) {

    if (arrayList == null) {
      arrayList = new ArrayList<>();
    }

    if (!value.isEmpty()) {
      arrayList.add(value);
    }
  }

  @GetMapping("/show-array")
  public String showArrayList() {

    return arrayList.toString();
  }

  @GetMapping("/update-map")
  public void updateHashMap(
      @RequestParam(value = "key") Integer key,
      @RequestParam(value = "value") String value) {

    if (hashMap == null) {
      hashMap = new HashMap<>();
    }

    hashMap.put(key, value);
  }

  @GetMapping("/show-map")
  public String showHashMap() {

    return hashMap.toString();
  }

  @GetMapping("/show-all-length")
  public String showAllLenght() {

    return "Length of ArrayList: " + (arrayList != null ? arrayList.size() : 0) +
        "\nLength of HashMap: " + (hashMap != null ? hashMap.size() : 0);
  }
}
