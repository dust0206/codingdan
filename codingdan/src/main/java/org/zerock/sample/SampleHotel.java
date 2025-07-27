package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 필드주입
// Setter 주입
// 생성자 주입
@Component
@ToString
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	
	private final Chef chef;
//	private Chef chef;		// @AllArgsConstructor

	// @AllArgsConstructor
//	public SampleHotel(Chef chef) {
//		super();
//		this.chef = chef;
//	}
	
	
}
