package app.springmvc;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.springmvc.members.MemberForm;

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
   
   @RequestMapping("/headers")
   public String header(HttpServletRequest request,
		   @RequestHeader MultiValueMap<String, String> headerMap,
		   @RequestHeader ("host") String host,
		   @CookieValue("myCookie") String cookie,
		   Locale locale
		   ) {
	   request.getHeader("host");
	   System.out.println("headerMap : " + headerMap);
	   System.out.println("headerMap host : " + headerMap.get("host"));
	   System.out.println("host : " + host);
	   System.out.println("cookie : " + cookie);
	   System.out.println("locale : " + locale);
	   return "test1";
   }
   
   @RequestMapping("/request")
   public String requestV1(@RequestParam String id, @RequestParam String name) {
	   System.out.println("id : " + id);
	   System.out.println("name : " + name);
	   return "test1";
   }
   
//   @RequestMapping("/request2")
//   public String requestV2(@RequestParam MultiValueMap<String, String> paramMap) {
//	   System.out.println(paramMap);
//	   return "test1";
//   }
   @RequestMapping("/request2")
   public String requestV2(@RequestParam("num") List<String> nums){
	   System.out.println(nums);
	   return "test1";
   }
   
   @RequestMapping(value = "/request3", consumes = MediaType.APPLICATION_FORM_URLENCODED)
   public String requestV3(MemberForm form){
	   System.out.println(form.getId());
	   System.out.println(form.getName());
	   return "test1";
   }
   
   @RequestMapping(value = "/request3", consumes = MediaType.APPLICATION_JSON)
   public String requestV4(@RequestBody MemberForm form){
	   System.out.println("json");
	   System.out.println(form.getId());
	   System.out.println(form.getName());
	   return "test1";
   }
   @RequestMapping(value = "/request5")
   @ResponseBody
   public String requestV5(){
	   return "test1";
   }
   
   @RequestMapping(value = "/request6")
   @ResponseBody
   public MemberForm requestV6(@ModelAttribute MemberForm form){
	   return form;
   }
}