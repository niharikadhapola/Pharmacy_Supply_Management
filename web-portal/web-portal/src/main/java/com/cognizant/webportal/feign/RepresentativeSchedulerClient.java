package com.cognizant.webportal.feign;

import java.text.ParseException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;


import com.cognizant.webportal.model.RepSchedule;





@FeignClient(name="RepresentativeScheduler", url="http://localhost:8082")
public interface RepresentativeSchedulerClient {

	@GetMapping("/RepSchedule/{startdate}")
	public List<RepSchedule> showSchedule(@RequestHeader("Authorization") String token,@PathVariable String startdate) throws ParseException;

}
