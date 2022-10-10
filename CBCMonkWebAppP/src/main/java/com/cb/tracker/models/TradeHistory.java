package com.cb.tracker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@NamedStoredProcedureQuery(
		  name="update_trade",
		  procedureName="update_trade",
		  resultClasses = { TradeHistory.class },
		  parameters={
		    @StoredProcedureParameter(name="analystid", type=String.class, mode=ParameterMode.IN),
		    @StoredProcedureParameter(name="ORDERID", type=String.class, mode=ParameterMode.IN),
		    @StoredProcedureParameter(name="inTRADE_ID", type=String.class, mode=ParameterMode.IN),
		  }
		)
@Entity
@Table(name="tradehistory")
public class TradeHistory {
	@Id
	@Column(name = "trade_id")
	String trade_id;
	
	@Column(name="analyst_id")
	String analyst_id;
	
	@Column(name="market_symbol")
	String market_symbol;
	
	@Column(name="asset_symbol")
	String asset_symbol;
	
	@Column(name="trade_type")
	String trade_type;
	
	@Column(name="invested_value")
	Double invested_value;
	
	@Column(name="total_volume")
	Double total_volume;
	
	@Column(name="trade_status")
	String trade_status;
	
	@Column(name="buy_volume")
	Double buy_volume;
	
	@Column(name="sell_volume")
	Double sell_volume;
	
	@Column(name="total_buy_value")
	Double total_buy_value;
	
	@Column(name="total_sell_value")
	Double total_sell_value;
	
	@Column(name="total_fees")
	Double total_fees;
	
	@Column(name="open_date")
	String open_date;
	
	@Column(name="close_date")
	String close_date;
	
	@Column(name="lasttradetime")
	String lasttradetime;
	public String getAnalyst_id() {
		return analyst_id;
	}
	public void setAnalyst_id(String analyst_id) {
		this.analyst_id = analyst_id;
	}

	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getMarket_symbol() {
		return market_symbol;
	}
	public void setMarket_symbol(String market_symbol) {
		this.market_symbol = market_symbol;
	}
	public String getAsset_symbol() {
		return asset_symbol;
	}
	public void setAsset_symbol(String asset_symbol) {
		this.asset_symbol = asset_symbol;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public Double getInvested_value() {
		return invested_value;
	}
	public void setInvested_value(Double invested_value) {
		this.invested_value = invested_value;
	}
	public Double getTotal_volume() {
		return total_volume;
	}
	public void setTotal_volume(Double total_volume) {
		this.total_volume = total_volume;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	public Double getBuy_volume() {
		return buy_volume;
	}
	public void setBuy_volume(Double buy_volume) {
		this.buy_volume = buy_volume;
	}
	public Double getSell_volume() {
		return sell_volume;
	}
	public void setSell_volume(Double sell_volume) {
		this.sell_volume = sell_volume;
	}
	public Double getTotal_buy_value() {
		return total_buy_value;
	}
	public void setTotal_buy_value(Double total_buy_value) {
		this.total_buy_value = total_buy_value;
	}
	public Double getTotal_sell_value() {
		return total_sell_value;
	}
	public void setTotal_sell_value(Double total_sell_value) {
		this.total_sell_value = total_sell_value;
	}
	public Double getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(Double total_fees) {
		this.total_fees = total_fees;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getClose_date() {
		return close_date;
	}
	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}
	public String getLasttradetime() {
		return lasttradetime;
	}
	public void setLasttradetime(String lasttradetime) {
		this.lasttradetime = lasttradetime;
	}
	
	
}
