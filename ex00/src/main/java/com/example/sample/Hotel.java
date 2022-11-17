package com.example.sample;

import lombok.*;
import org.springframework.stereotype.Component;

// 내부에 선언되어 있는 변수들을 전부 매개변수로 넘겨받는 생성자가 생성된다. 
// 즉, 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성한다.
//@AllArgsConstructor

// 필요한 것만 사용하겠다는 어노테이션
// 즉, 특정 변수에 대해서만 생성자를 작성할 때 사용한다.
// @NonNull 이나 final이 붙은 인스턴스 변수에 대한 생성자를 만들어 낸다.
@RequiredArgsConstructor
@Component
@Setter
@Getter
@ToString
public class Hotel {
	@NonNull
	Chef chef;
	int data;
}
