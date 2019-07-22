package com.kok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("index")
public class IndexService {

	@Autowired
	UserService userService;


}
