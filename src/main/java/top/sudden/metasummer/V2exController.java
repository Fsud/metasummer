package top.sudden.metasummer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import top.sudden.metasummer.feign.FeignTest;

import java.util.HashMap;

@Controller
@RequestMapping("/metaSummer")
public class V2exController {

    @Autowired
    FeignTest feignTest;


    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://www.v2ex.com/api/topics/latest.json", String.class, new HashMap<>());
        JSONArray jsonObject = JSON.parseArray(forEntity.getBody());
        modelMap.addAttribute("v",jsonObject);
        return "/hello";
    }

    @RequestMapping("/hy")
    public void hy(ModelMap modelMap){
        feignTest.a();
    }
}
