package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class Restaurant {
	// setter을 호출하면서 주입을 해준다.
	@Setter(onMethod_ = @Autowired)
	Chef chef;
}
