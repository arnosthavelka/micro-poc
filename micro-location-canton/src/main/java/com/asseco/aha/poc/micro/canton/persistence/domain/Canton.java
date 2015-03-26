package com.asseco.aha.poc.micro.canton.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Definition of cantons in Czech Republic.
 */
@Entity
public class Canton implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

	@Column(nullable = false, length = 6)
	private String csuCode;

	@Column(nullable = true, length = 5)
	private String districtCode;

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

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	@Override
	public String toString() {
		return String.format("", getName(), getCsuCode(), getDistrictCode());
	}

}
