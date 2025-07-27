package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// Full name
// org.zerock.mapper.TimeMapper.getTime2

@Repository
public interface TimeMapper {

	// 주의 사항
	// ; 없어야 한다
	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
}
