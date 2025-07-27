package org.zerock.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 주입방법 3가지
// 1. Setter 주입 - lombok : @Setter(onMethod_ = {@Autowired})
// 2. 생성자 주입 - lombok : @AllArgsConstructor
// 3. 필드 주입 - @Autowired
// 4. final 필드를 이용해서 자동 주입 기능 (spring 5.x version에서 사용) - 주로 많이 사용함
//	  - @RequiredArgsConstructor	
// 	  - private final Chef chef;

 
@Component
@ToString
//@AllArgsConstructor	  // 2. 생성자 주입
@RequiredArgsConstructor	// 4. final 필드 자동주입
public class Restaurant { 
	
//	@Autowired		// 3. 필스주입
	
//	@Setter(onMethod_ = {@Autowired})		// 1. Setter 주입
	
//	private  Chef chef;		// 주입 1,2,3 동일
	
	private final Chef chef;	// 4. final 필드 자동주입
}
