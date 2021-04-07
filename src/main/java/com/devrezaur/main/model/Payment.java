package com.devrezaur.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "payments")
@Component
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pay_id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "trx_code")
	private String trxCode;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "status")
	private String status = "Pending";

	public Payment() {
		super();
	}

	public Payment(int id, int userId, int courseId, String trxCode, Double amount, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
		this.trxCode = trxCode;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
