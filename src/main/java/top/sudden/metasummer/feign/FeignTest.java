package top.sudden.metasummer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "feign",url="localhost:8080")
public interface FeignTest {

    @GetMapping("/aaa/1")
    void a();
}
