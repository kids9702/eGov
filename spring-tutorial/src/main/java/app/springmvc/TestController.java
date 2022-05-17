package app.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
   @RequestMapping({"/test1", "/abc"})
   public String test1() {
      return "test1";
   }
   @GetMapping("/test2")
   public String test2_get() {
      System.out.println("/test2 Get method");
      
      return "test1";
   }
   @PostMapping
   public String test2_post() {
	   System.out.println("/test2 Post method");
      
      return "test1";
   }
   @RequestMapping("/mapping/{id}")
   public String mappingV1(@PathVariable String id) {
	   System.out.println("id = " + id);
	   return "test1";
   }
}