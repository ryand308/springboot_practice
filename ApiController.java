package com.example.demo.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 了解各種不同參數的傳遞
@Controller
@RequestMapping("/api")
public class ApiController {
	
	/**
	 *1. 歡迎頁
	 * 路徑：/api/welcome
	 * 路徑：/api/home
	 * 網址：http://localhost:8080/api/welcome
	 * 網址：http://localhost:8080/api/home
	 */
	@GetMapping(value = {"/home", "/welcome"})
	@ResponseBody
	public String welcome() {
		return "Welcome";
	}
	
	/**
	 * 2. ?帶參數
	 * 路徑： /greet?name=John&age=18
	 * 路徑： /greet?name=Mary
	 * 網址：http://localhost:8080/api/greet?name=John&age=18
	 * 網址：http://localhost:8080/api/greet?name=Mary
	 * 限制：name 參數是一定要加上的
	 * 	   age 參數不一定要有(若沒有 age 參數則會給初始值 = 0)	
	 */
	@GetMapping("/greet")
	@ResponseBody
	public String greet(@RequestParam(value = "name", required = true) String name,
						@RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
		return String.format("Hi %s %d", name, age);
	}
	/**
	 * 3. Lab 練習
	 * 路徑： /bmi?h=170.0&w=60.0
	 * 網址：http://localhost:8080/api/bmi?h=170.0&w=60.0
	 * 執行結果： bmi = 20.76
	 * 
	 */
	@GetMapping("/bmi")
	@ResponseBody
	public String bmi(@RequestParam(value = "h", required = true) Double height ,
					  @RequestParam(value = "w", required = true) Double weight) {
		
		double bmi = weight / (height * height) * 100;
		return String.format("bmi = %.2f", bmi);
	}
	/**
	 * 3. Lab 練習II
	 * 路徑： /add?x=10&y=30
	 * 網址：http://localhost:8080/api/add?x=10&y=30
	 * 執行結果： result = 40;
	 */
	@GetMapping("/add")
	@ResponseBody
	public String add(@RequestParam(value = "x") Integer x ,
					  @RequestParam(value = "y") Integer y) {		
		
		return String.format("%d + %d = %d", x, y, x+y);
	}
	
	/**
	 * 4. 同名多筆的資料
	 * 路徑： /age?age=10&age=17&age=20
	 * 網址：http://localhost:8080/api/age?age=10&age=17&age=20
	 * 計算出平均年齡
	 * produces 告知瀏覽器 格式及文字編碼
	 */
	@GetMapping(value = "/age", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getAverageAge(@RequestParam("age") List<Integer> ages) {
		double avg = ages.stream().mapToInt(Integer::intValue).average().getAsDouble();
		
		return String.format("平均年齡：%.1f", avg);
	}
	/**
	 * 5. Lab 練習: 得到多筆 score 資料
	 * 路徑: "/exam?score=80&score=100&score=50&score=70&score=30"
	 * 網址: http://localhost:8080/api/exam?score=80&score=100&score=50&score=70&score=30
	 * 請自行設計一個方法，此方法可以
	 * 印出: 最高分=?、最低分=?、平均=?、總分=?、及格分數=?、不及格=?
	 * (支援中文字印出) 
	 * 提示: IntSummaryStatistics, Collectors.partitioningBy    
	 * */
	@GetMapping(value = "/exam", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String exam(@RequestParam("score") List<Double> scores) {
		// 計算統計信息
        IntSummaryStatistics stats = scores.stream()
                .mapToInt(Double::intValue) // 將 Double 轉換為 int
                .summaryStatistics();

        double totalScore = stats.getSum();
        double average = stats.getAverage();
        double maxScore = stats.getMax();
        double minScore = stats.getMin();
     // 計算及格和不及格的數量
        Map<Boolean, List<Double>> partitionedScores = scores.stream()
                .collect(Collectors.partitioningBy(score -> score >= 60.0));

//        long passingCount = partitionedScores.get(true).size();
//        long failingCount = partitionedScores.get(false).size();
        List<Double> passingScores = partitionedScores.get(true);
        List<Double> failingScores = partitionedScores.get(false);
        
        return "最高分: " + maxScore + "\n"+
        		"最低分: " + minScore + "\n"+
        		"平均: " + average + "\n"+
        		"總分: " + totalScore + "\n"+
        		"及格數: " + passingScores.size() + "\n"+
        		"及格成績: " + passingScores + "\n" +
        		"不及格數: " + failingScores.size() + "\n" +
        		"不及格成績: " + failingScores;	
	}
	/**
	 * 6. 多筆餐書轉 Map
	 * 路徑：/product?name=Math&price=12.5&amount=10&outOf=true
	 * 路徑：/product?name=Comics&price=10.5&amount=20&outOf=false
	 * 網址: http://localhost:8080/api/product?name=Math&price=12.5&amount=10&outOf=true
	 * 網址: http://localhost:8080/api/product?name=Comics&price=10.5&amount=20&outOf=false
	 */
	@GetMapping("/product")
	@ResponseBody
	public String getProduct(@RequestParam Map<String, String> productMap) {
		
		return "product map: " + productMap;
	}
}
