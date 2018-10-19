package com.kevin.cherry.model;


import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class KevinUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3158497779147289608L;

	protected Long id;

    private String name;
	
}
