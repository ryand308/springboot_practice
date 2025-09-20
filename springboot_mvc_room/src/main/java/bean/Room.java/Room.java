package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data //可以導入所有
@AllArgsConstructor
public class Room {
	private Integer roomId;
	private String roomName;
	private Integer roomSize;
	
}
/*
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
 */