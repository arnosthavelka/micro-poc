package com.github.aha.poc.micro.district.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Definition of districts in Czech Republic.
 */
@Entity
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false, length=5)
	private String csuCode;

    @Column(nullable = false, length=1)
	private String plateCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCsuCode() {
		return csuCode;
	}

	public void setCsuCode(String csuCode) {
		this.csuCode = csuCode;
	}

	public String getPlateCode() {
		return plateCode;
	}

	public void setPlateCode(String plateCode) {
		this.plateCode = plateCode;
	}

	@Override
	public String toString() {
		return String.format("", getName(), getCsuCode(), getPlateCode());
	}

}
