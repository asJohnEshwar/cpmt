package com.cb.tracker.models;


import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "openorderhistory")
public class Orders {
	@Id
	@Column(name = "order_id")
	String order_id;
	
	@Column(name = "trade_id")
	String tradeId;
	@Column(name = "analyst_id")
	String analyst_id;
	
	@Column(name = "asset_symbol")
	String asset_symbol;
	
	@Column(name = "market_symbol")
	String market_symbol;
	
	@Column(name = "commission_symbol")
	String commission_symbol;
	
	@Column(name = "last_order_fill")
	Double last_order_fill;
	
	@Column(name = "total_order_fill")
	Double total_order_fill;
	
	@Column(name = "order_status")
	String order_status;
	
	@Column(name = "order_type")
	String order_type;
	
	@Column(name = "quantity")
	Double quantity;
	
	@Column(name = "price")
	Double price;
	
	@Column(name = "order_time")
	String order_time;
	
	@Column(name = "lastupdatetimestamp")
	String lastupdatetime;
	
	@Column(name = "fees")
	//@ColumnDefault("'0.00000000'")
	Double feesAmount=0.000;
	
	@Column(name = "last_executed_price")
	Double last_executed_price;
	

	public Double getLast_executed_price() {
		return last_executed_price;
	}
	public void setLast_executed_price(Double last_executed_price) {
		this.last_executed_price = last_executed_price;
	}
	
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public Double getFeesAmount() {
		return feesAmount;
	}
	public void setFeesAmount(Double feesAmount) {
		this.feesAmount = feesAmount;
	}
	public String getOrder_id() {
		return order_id;
	}
	public String getAsset_symbol() {
		return asset_symbol;
	}
	public void setAsset_symbol(String asset_symbol) {
		this.asset_symbol = asset_symbol;
	}
	public String getMarket_symbol() {
		return market_symbol;
	}
	public void setMarket_symbol(String market_symbol) {
		this.market_symbol = market_symbol;
	}
	public String getCommission_symbol() {
		return commission_symbol;
	}
	public void setCommission_symbol(String commission_symbol) {
		this.commission_symbol = commission_symbol;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getAnalyst_id() {
		return analyst_id;
	}
	public void setAnalyst_id(String analyst_id) {
		this.analyst_id = analyst_id;
	}
	public Double getLast_order_fill() {
		return last_order_fill;
	}
	public void setLast_order_fill(Double last_order_fill) {
		this.last_order_fill = last_order_fill;
	}
	public Double getTotal_order_fill() {
		return total_order_fill;
	}
	public void setTotal_order_fill(Double total_order_fill) {
		this.total_order_fill = total_order_fill;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double string) {
		this.quantity = string;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	
	
}
