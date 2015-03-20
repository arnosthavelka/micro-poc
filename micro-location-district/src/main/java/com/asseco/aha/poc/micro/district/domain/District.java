package com.asseco.aha.poc.micro.district.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Definition of districts in Czech Republic.
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "District.findByName", query = "select c from District c where c.name = ?1"),
		@NamedQuery(name = "District.findByNameAndCsuCode", query = "select c from District c where c.name like ?1 and c.csuCode = ?2") })
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
