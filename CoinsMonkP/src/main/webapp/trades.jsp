<!DOCTYPE html>
<%@page import="java.io.Console"%>
<%@page import="com.cb.tracker.models.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet" />
</head>
<body>

	<div class="v477_1696">

		<div class="v477_1708">
			<div class="v477_1709"></div>
			<div class="v477_1710">
				<div class="v477_1711"></div>
				<div class="v477_1712">
					<div class="v477_1713">
						<div class="name"></div>
					</div>
					<span class="v477_1719">Stocklist</span>
				</div>
				<div class="v477_1720">
					<span class="v477_1721">HRM</span>
					<div class="v477_1722">
						<div class="name"></div>
					</div>
				</div>
				<div class="v477_1729">
					<span class="v477_1730">Trades</span>
					<div class="v477_1731">
						<div class="name"></div>
					</div>
				</div>
				<div class="v477_1735">
					<div class="v477_1736">
						<span class="v477_1737">Dashboard</span>
						<div class="v477_1738">
							<div class="v477_1739"></div>
							<div class="v477_1740"></div>
							<div class="v477_1741"></div>
							<div class="v477_1742"></div>
						</div>
					</div>
				</div>
				<div class="v477_1743">
					<div class="v477_1744">
						<div class="v477_1745">
							<div class="name"></div>
							<div class="v477_1748"></div>
						</div>
					</div>
					<div class="v477_1749">
						<div class="v477_1750">
							<span class="v477_1751">Deposits / withdrawes</span>
						</div>
					</div>
				</div>
			</div>
			<div class="v477_1752">
				<span class="v477_1753">Coinsmonk </span>
				<div class="v477_1754">
					<div class="v477_1755"></div>
					<div class="v477_1756"></div>
					<div class="v477_1757"></div>
					<div class="v477_1758"></div>
					<div class="v477_1759"></div>
				</div>
			</div>
			<div class="v477_1760">
				<div class="name"></div>
				<div class="v477_1762">
					<div class="v477_1763"></div>
					<span class="v477_1764">Log out</span>
					<div class="v477_1765">
						<div class="name"></div>
					</div>
				</div>
			</div>
		</div>
		<span class="v477_1769">Good morning  ! </span><span
			class="v477_1770">"If you can stay positive in a negative
			situation,then also you win."</span>
		<div class="v477_1771">
			<div class="v477_1772">
				<span class="v477_1773">Satoshi Nakamato </span><span
					class="v477_1774">satoshinakamoto@gmail.com</span>
			</div>
			<div class="v477_1775"></div>
		</div>
		<div class="v477_1776">
			<div class="v477_1777"></div>
			<div class="v477_1778">
				<div class="v477_1779">
					<div class="v477_1780"></div>
					<div class="v477_1781"></div>
				</div>
				<div class="v477_1782"></div>
			</div>
		</div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="name"></div>
		<div class="v477_1791">
			<div class="v477_1792">
				<div class="v477_1793"></div>
				<div class="v477_1794"></div>
			</div>
			<div class="name"></div>
		</div>

		<div class="v477_1796"></div>
		<div class="v477_1797">
			<div class="v477_1798"></div>
			<div class="v477_1799"></div>
		</div>

		<div class="v477_1801">
			<div class="v477_1802"></div>
			<div class="v477_1803"></div>
			<div class="v477_1804"></div>
		</div>




		<!-- 		<span class="v477_2053">Coin </span><span class="v477_2054">#Total Volume </span><span class="v477_2056">Locked Volume </span>	 -->
		<!-- 		<span class="v477_2057">#Open Orders</span><span class="v477_2058">#Total Trades</span><span class="v477_2059">#Profit Trades</span> -->
		<!-- 		<span class="v477_2060">TotalVolume</span><span class="v477_2055">Free Volume</span> -->
		<!-- 		<span class="v477_2061">Free Volume</span><span class="v477_2062">Locked </span> -->
		<!-- 		<span class="v477_2063">OpenOrders</span> -->
		<div>
			
			<table>
				<thead class="v477_1707" align="center">
					<tr>
						<th class="v477_2053">COIN
						<th class="v477_2054">TOTAL_VOLUME
						<th class="v477_2056">FREE_VOLUME
						<th class="v477_2057">LOCKED_VOLUME
						<th class="v477_2058">OPEN_ORDERS
						<th class="v477_2059">TOTAL_TRADES
						<th class="v477_2060">PROFIT_TRADES
					</tr>
				</thead>
<% try{List<AccountSnapshot> snapList=(List<AccountSnapshot>)request.getAttribute("snaps");
		if(snapList.size()>=1)
			out.print("Availab;e");	

			for(AccountSnapshot snap:snapList ){
		
		%>
				<tbody class="v477_1707" align="center">
					<tr>
						<td><%=snap.getAsset() %>
						<td><%=snap.getTotalVolume().toString() %>
						<td><%=snap.getFreeVolume().toString() %>
						<td><%=snap.getLockedVolume().toString() %>
						<td><%=snap.getTotalOpenOrders() %>
						<td><%=snap.getTotalTrades() %>
						<td><%=snap.getTotalProfitTrades() %>
					</tr>
				</tbody>


			<%} }
catch(Exception e){
	e.printStackTrace();
	}

	finally{} %>
				</table>
<!-- 			<div class="v477_1817"> -->
<!-- 				<span class="v477_1818">BTC</span><span class="v477_1819">Bitcoin -->
<!-- 				</span> -->
<!-- 			</div> -->
<!-- 			<div class="v477_1832"></div> -->


<!-- 			<div class="v477_1934"> -->
<!-- 				<span class="v477_1935">1</span> -->
<!-- 				<div class="v477_1936"> -->
<!-- 					<div class="v477_1937"></div> -->
<!-- 					<span class="v477_1938">2</span> -->
<!-- 				</div> -->
<!-- 				<span class="v477_1939">3</span><span class="v477_1940">4</span><span -->
<!-- 					class="v477_1941">5</span><span class="v477_1942">6</span><span -->
<!-- 					class="v477_1943">... </span><span class="v477_1944">12</span> -->
<!-- 			</div> -->
<!-- 			<div class="name"></div> -->
<!-- 			<div class="v479_2096"> -->
<!-- 				<span class="v479_2097">Profit</span> -->
<!-- 				<div class="v479_2098"> -->
<!-- 					<span class="v479_2099">Percent</span> -->

<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<span class="v479_2103">0.25</span><span class="v479_2105">0.25</span><span -->
<!-- 				class="v479_2107">0.25</span><span class="v479_2109">0.25</span><span -->
<!-- 				class="v479_2111">0.25</span><span class="v479_2113">0.25</span><span -->
<!-- 				class="v479_2104">0.26</span><span class="v479_2106">0.26</span><span -->
<!-- 				class="v479_2108">0.26</span><span class="v479_2110">0.26</span><span -->
<!-- 				class="v479_2112">0.26</span><span class="v479_2114">0.26</span> -->

<!-- 		</div> -->
</body>
</html>
<br />
<br />
<style>
* {
	box-sizing: border-box;
}

body {
	font-size: 14px;
}

.v477_1696 {
	width: 100%;
	height: 900px;
	background: rgba(244, 241, 236, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	border-top-left-radius: 16px;
	border-top-right-radius: 16px;
	border-bottom-left-radius: 16px;
	border-bottom-right-radius: 16px;
	overflow: hidden;
}

.table {
	width: 100%;
	height: 39px;
	background: rgba(203, 145, 117, 0.05999999865889549);
	opacity: 1;
	position: absolute;
	top: 287px;
	left: 264px;
	overflow: hidden;
}

.v477_1707 {
font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	width: 100%;
	height: 39px;
	background: rgba(203, 145, 117, 0.05999999865889549);
	opacity: 1;
	position: relative;
	top: 287px;
	left: 264px;
	overflow: hidden;
}

.v477_1708 {
	width: 224px;
	height: 900px;
	background: url("../images/v477_1708.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v477_1709 {
	width: 224px;
	height: 900px;
	background: rgba(203, 146, 117, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v477_1710 {
	width: 176px;
	height: 236px;
	background: url("../images/v477_1710.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 163px;
	left: 23px;
	overflow: hidden;
}

.v477_1711 {
	width: 176px;
	height: 48px;
	background: linear-gradient(rgba(255, 255, 255, 0.800000011920929),
		rgba(255, 255, 255, 0.20000000298023224));
	padding: 12px 24px;
	margin: 16px;
	opacity: 1;
	position: absolute;
	top: 95px;
	left: 0px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v477_1712 {
	width: 85px;
	height: 16px;
	background: url("../images/v477_1712.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 55px;
	left: 33px;
	overflow: hidden;
}

.v477_1713 {
	width: 15px;
	height: 15px;
	background: url("../images/v477_1713.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 1px;
	left: 0px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1719 {
	width: 55px;
	color: rgba(244, 241, 236, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 30px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1720 {
	width: 63px;
	height: 16px;
	background: url("../images/v477_1720.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 165px;
	left: 32px;
	overflow: hidden;
}

.v477_1721 {
	width: 32px;
	color: rgba(244, 241, 236, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 31px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1722 {
	width: 16px;
	height: 16px;
	background: url("../images/v477_1722.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1729 {
	width: 73px;
	height: 16px;
	background: url("../images/v477_1729.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 110px;
	left: 33px;
	overflow: hidden;
}

.v477_1730 {
	width: 43px;
	color: rgba(244, 241, 236, 1);
	position: absolute;
	top: 0px;
	left: 30px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1731 {
	width: 15px;
	height: 15px;
	background: url("../images/v477_1731.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 1px;
	left: 0px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1735 {
	width: 97px;
	height: 16px;
	background: url("../images/v477_1735.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 34px;
	overflow: hidden;
}

.v477_1736 {
	width: 97px;
	height: 16px;
	background: url("../images/v477_1736.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v477_1737 {
	width: 68px;
	color: rgba(244, 241, 236, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 29px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1738 {
	width: 13px;
	height: 13px;
	background: url("../images/v477_1738.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 2px;
	left: 0px;
	overflow: hidden;
}

.v477_1739 {
	width: 4px;
	height: 5px;
	background: rgba(244, 241, 236, 0.699999988079071);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	border: 1px solid rgba(244, 241, 236, 0.699999988079071);
	border-top-left-radius: 1px;
	border-top-right-radius: 1px;
	border-bottom-left-radius: 1px;
	border-bottom-right-radius: 1px;
	overflow: hidden;
}

.v477_1740 {
	width: 4px;
	height: 4px;
	background: rgba(244, 241, 236, 0.699999988079071);
	opacity: 1;
	position: absolute;
	top: 8px;
	left: 0px;
	border: 1px solid rgba(244, 241, 236, 0.699999988079071);
	border-top-left-radius: 1px;
	border-top-right-radius: 1px;
	border-bottom-left-radius: 1px;
	border-bottom-right-radius: 1px;
	overflow: hidden;
}

.v477_1741 {
	width: 4px;
	height: 4px;
	background: rgba(244, 241, 236, 0.699999988079071);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 8px;
	border: 1px solid rgba(244, 241, 236, 0.699999988079071);
	border-top-left-radius: 1px;
	border-top-right-radius: 1px;
	border-bottom-left-radius: 1px;
	border-bottom-right-radius: 1px;
	overflow: hidden;
}

.v477_1742 {
	width: 4px;
	height: 5px;
	background: rgba(244, 241, 236, 0.699999988079071);
	opacity: 1;
	position: absolute;
	top: 7px;
	left: 8px;
	border: 1px solid rgba(244, 241, 236, 0.699999988079071);
	border-top-left-radius: 1px;
	border-top-right-radius: 1px;
	border-bottom-left-radius: 1px;
	border-bottom-right-radius: 1px;
	overflow: hidden;
}

.v477_1743 {
	width: 102px;
	height: 16px;
	background: url("../images/v477_1743.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 220px;
	left: 33px;
	overflow: hidden;
}

.v477_1744 {
	width: 15px;
	height: 15px;
	background: url("../images/v477_1744.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 1px;
	left: 0px;
	overflow: hidden;
}

.v477_1745 {
	width: 15px;
	height: 15px;
	background: url("../images/v477_1745.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1748 {
	width: 5px;
	height: 7px;
	background: url("../images/v477_1748.png");
	opacity: 1;
	position: absolute;
	top: 4px;
	left: 10px;
	border: 2px solid rgba(203, 146, 117, 1);
}

.v477_1749 {
	width: 72px;
	height: 16px;
	background: url("../images/v477_1749.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 30px;
	overflow: hidden;
}

.v477_1750 {
	width: 72px;
	height: 16px;
	background: url("../images/v477_1750.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v477_1751 {
	width: 72px;
	color: rgba(244, 241, 236, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1752 {
	width: 172px;
	height: 89px;
	background: url("../images/v477_1752.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 40px;
	left: 25px;
	overflow: hidden;
}

.v477_1753 {
	width: 172px;
	color: rgba(244, 241, 236, 1);
	position: absolute;
	top: 43px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 20px;
	opacity: 1;
	text-align: center;
}

.v477_1754 {
	width: 41px;
	height: 41px;
	background: url("../images/v477_1754.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 65px;
	overflow: hidden;
}

.v477_1755 {
	width: 41px;
	height: 41px;
	background: rgba(244, 241, 236, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
}

.v477_1756 {
	width: 11px;
	height: 14px;
	background: url("../images/v477_1756.png");
	opacity: 1;
	position: absolute;
	top: 5px;
	left: 15px;
	border: 2.299999952316284px solid rgba(244, 241, 236, 1);
}

.v477_1757 {
	width: 16px;
	height: 15px;
	background: url("../images/v477_1757.png");
	opacity: 1;
	position: absolute;
	top: 20px;
	left: 8px;
	border: 2.299999952316284px solid rgba(244, 241, 236, 1);
}

.v477_1758 {
	width: 17px;
	height: 17px;
	background: rgba(244, 241, 236, 1);
	opacity: 1;
	position: absolute;
	top: 22px;
	left: 10px;
	border: 2.299999952316284px solid rgba(244, 241, 236, 1);
}

.v477_1759 {
	width: 8px;
	height: 15px;
	background: url("../images/v477_1759.png");
	opacity: 1;
	position: absolute;
	top: 23px;
	left: 24px;
	border: 2.299999952316284px solid rgba(244, 241, 236, 1);
}

.v477_1760 {
	width: 176px;
	height: 235px;
	background: url("../images/v477_1760.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 625px;
	left: 23px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1762 {
	width: 134px;
	height: 33px;
	background: url("../images/v477_1762.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 189px;
	left: 21px;
	overflow: hidden;
}

.v477_1763 {
	width: 134px;
	height: 33px;
	background: rgba(203, 146, 117, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v477_1764 {
	width: 48px;
	color: rgba(244, 241, 236, 1);
	position: absolute;
	top: 9px;
	left: 57px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1765 {
	width: 11px;
	height: 16px;
	background: url("../images/v477_1765.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 9px;
	left: 27px;
	overflow: hidden;
}

.name {
	color: #fff;
}

.v477_1769 {
	width: 148px;
	color: rgba(39, 59, 74, 1);
	position: absolute;
	top: 40px;
	left: 264px;
	font-family: Roboto;
	font-weight: ExtraBold;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1770 {
	width: 375px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 62px;
	left: 264px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: left;
}

.v477_1771 {
	width: 213px;
	height: 37px;
	background: url("../images/v477_1771.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 40px;
	left: 1135px;
	overflow: hidden;
}

.v477_1772 {
	width: 161px;
	height: 34px;
	background: url("../images/v477_1772.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 0px;
	overflow: hidden;
}

.v477_1773 {
	width: 116px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 45px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 14px;
	opacity: 1;
	text-align: right;
}

.v477_1774 {
	width: 161px;
	color: rgba(39, 59, 74, 0.5);
	position: absolute;
	top: 20px;
	left: 0px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: right;
}

.v477_1775 {
	width: 37px;
	height: 37px;
	background: url("../images/v477_1775.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 176px;
	border: 1px solid rgba(203, 146, 117, 1);
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v477_1776 {
	width: 37px;
	height: 37px;
	background: url("../images/v477_1776.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 40px;
	left: 1363px;
	overflow: hidden;
}

.v477_1777 {
	width: 37px;
	height: 37px;
	background: url("../images/v477_1777.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	border: 1px solid rgba(203, 146, 117, 1);
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	overflow: hidden;
}

.v477_1778 {
	width: 17px;
	height: 16px;
	background: url("../images/v477_1778.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 10px;
	left: 9px;
	overflow: hidden;
}

.v477_1779 {
	width: 17px;
	height: 16px;
	background: url("../images/v477_1779.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	overflow: hidden;
}

.v477_1780 {
	width: 17px;
	height: 13px;
	background: rgba(203, 146, 117, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
}

.v477_1781 {
	width: 3px;
	height: 0px;
	background: url("../images/v477_1781.png");
	opacity: 1;
	position: absolute;
	top: 16px;
	left: 10px;
	border-radius: 50%;
}

.v477_1782 {
	width: 6px;
	height: 6px;
	background: rgba(255, 0, 0, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 10px;
	border-radius: 50%;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.name {
	color: #fff;
}

.v477_1791 {
	width: 560px;
	height: 23px;
	background: url("../images/v477_1791.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 231px;
	left: 264px;
	overflow: hidden;
}

.v477_1792 {
	width: 23px;
	height: 23px;
	background: url("../images/v477_1792.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 537px;
	overflow: hidden;
}

.v477_1793 {
	width: 23px;
	height: 23px;
	background: url("../images/v477_1793.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
}

.v477_1794 {
	width: 19px;
	height: 5px;
	background: rgba(39, 59, 74, 1);
	opacity: 1;
	position: absolute;
	top: 8px;
	left: 1px;
}

.name {
	color: #fff;
}

.v477_1796 {
	width: 332px;
	height: 29px;
	background: rgba(203, 146, 117, 1);
	opacity: 1;
	position: absolute;
	top: 228px;
	left: 1068px;
	border: 1px solid rgba(38, 59, 74, 0.699999988079071);
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 4px;
	overflow: hidden;
}

.v477_1797 {
	width: 19px;
	height: 19px;
	background: url("../images/v477_1797.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 233px;
	left: 1374px;
	overflow: hidden;
}

.v477_1798 {
	width: 19px;
	height: 19px;
	background: url("../images/v477_1798.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
}

.v477_1799 {
	width: 13px;
	height: 13px;
	background: url("../images/v477_1799.png");
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 2px;
	border: 1px solid rgba(38, 59, 74, 0.699999988079071);
}

.v477_1800 {
	width: 103px;
	color: rgba(39, 59, 74, 0.6000000238418579);
	position: absolute;
	top: 236px;
	left: 1104px;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1801 {
	width: 18px;
	height: 18px;
	background: url("../images/v477_1801.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 234px;
	left: 1075px;
	overflow: hidden;
}

.v477_1802 {
	width: 18px;
	height: 18px;
	background: url("../images/v477_1802.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
}

.v477_1803 {
	width: 12px;
	height: 12px;
	background: url("../images/v477_1803.png");
	opacity: 1;
	position: absolute;
	top: 2px;
	left: 2px;
	border: 1px solid rgba(38, 59, 74, 0.699999988079071);
}

.v477_1804 {
	width: 3px;
	height: 3px;
	background: url("../images/v477_1804.png");
	opacity: 1;
	position: absolute;
	top: 12px;
	left: 12px;
	border: 1px solid rgba(38, 59, 74, 0.699999988079071);
}

.v477_2053 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	top: 300px;
	left: 264px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2054 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 300px;
	left: 427px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2060 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 364px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2066 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 443px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2072 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 522px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2078 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 601px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2084 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 680px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2090 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 759px;
	left: 427px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2055 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 300px;
	left: 590px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2061 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 364px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2067 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 443px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2073 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 522px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2079 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 601px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2085 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 680px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2091 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 759px;
	left: 590px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2056 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 300px;
	left: 753px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2062 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 356px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2068 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 435px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2074 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 514px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2080 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 593px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2086 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 672px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2092 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 751px;
	left: 753px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2057 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 300px;
	left: 916px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2063 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 356px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2069 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 435px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2075 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 514px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2081 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 593px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2087 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 672px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2093 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 751px;
	left: 916px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2058 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 300px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2064 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 364px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2070 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 443px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2076 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 522px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2082 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 601px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2088 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 680px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2094 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 759px;
	left: 1079px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_2059 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	/* 	position: absolute; */
	top: 300px;
	left: 1242px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.tablebody {
	width: 107px;
	height: 31px;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: relative;
	top: 355px;
	left: 309px;
	overflow: hidden;
}

.v477_1817 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1817.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: relative;
	top: 355px;
	left: 309px;
	overflow: hidden;
}

.v477_1818 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1819 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1832 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 357px;
	left: 275px;
	border-radius: 50%;
}

.v477_1837 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1837.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 434px;
	left: 309px;
	overflow: hidden;
}

.v477_1838 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1839 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1852 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 436px;
	left: 275px;
	border-radius: 50%;
}

.v477_1857 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1857.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 513px;
	left: 309px;
	overflow: hidden;
}

.v477_1858 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1859 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1872 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 515px;
	left: 275px;
	border-radius: 50%;
}

.v477_1877 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1877.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 592px;
	left: 309px;
	overflow: hidden;
}

.v477_1878 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1879 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1892 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 594px;
	left: 275px;
	border-radius: 50%;
}

.v477_1897 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1897.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 671px;
	left: 309px;
	overflow: hidden;
}

.v477_1898 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1899 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1912 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 673px;
	left: 275px;
	border-radius: 50%;
}

.v477_1917 {
	width: 107px;
	height: 31px;
	background: url("../images/v477_1917.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 750px;
	left: 309px;
	overflow: hidden;
}

.v477_1918 {
	width: 25px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Bold;
	font-size: 12px;
	opacity: 1;
	text-align: left;
}

.v477_1919 {
	width: 107px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 19px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v477_1932 {
	width: 27px;
	height: 27px;
	background: rgba(217, 217, 217, 1);
	opacity: 1;
	position: absolute;
	top: 752px;
	left: 275px;
	border-radius: 50%;
}

.v477_1934 {
	width: 176px;
	height: 23px;
	background: url("../images/v477_1934.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 825px;
	left: 1224px;
	overflow: hidden;
}

.v477_1935 {
	width: 15px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 5px;
	left: 0px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1936 {
	width: 29px;
	height: 23px;
	background: url("../images/v477_1936.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 29px;
	overflow: hidden;
}

.v477_1937 {
	width: 29px;
	height: 23px;
	background: rgba(203, 146, 117, 1);
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 0px;
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 4px;
	overflow: hidden;
}

.v477_1938 {
	width: 19px;
	color: rgba(244, 241, 236, 1);
	position: absolute;
	top: 5px;
	left: 5px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1939 {
	width: 19px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 5px;
	left: 72px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1940 {
	width: 17px;
	color: rgba(39, 59, 74, 0.5);
	position: absolute;
	top: 5px;
	left: 91px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1941 {
	width: 17px;
	color: rgba(39, 59, 74, 0.5);
	position: absolute;
	top: 5px;
	left: 108px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1942 {
	width: 17px;
	color: rgba(39, 59, 74, 0.5);
	position: absolute;
	top: 5px;
	left: 125px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1943 {
	width: 17px;
	color: rgba(39, 59, 74, 0.5);
	position: absolute;
	top: 5px;
	left: 142px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v477_1944 {
	width: 17px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 5px;
	left: 159px;
	font-family: Roboto;
	font-weight: Medium;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.name {
	color: #fff;
}

.v479_2096 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2096.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 356px;
	left: 1242px;
	overflow: hidden;
}

.v479_2097 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2098 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2098.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2099 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2100 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2100.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2101 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2101.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2102 {
	width: 13px;
	height: 7px;
	background: rgba(18, 179, 63, 1);
	opacity: 1;
	position: absolute;
	top: 17px;
	left: 0px;
}

.v479_2122 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2122.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 435px;
	left: 1242px;
	overflow: hidden;
}

.v479_2123 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2124 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2124.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2125 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2126 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2126.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2127 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2127.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2128 {
	width: 13px;
	height: 7px;
	background: rgba(18, 179, 63, 1);
	opacity: 1;
	position: absolute;
	top: 17px;
	left: 0px;
}

.v479_2129 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2129.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 514px;
	left: 1242px;
	overflow: hidden;
}

.v479_2130 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2131 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2131.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2132 {
	width: 40px;
	color: rgba(255, 45, 45, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2133 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2133.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2134 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2134.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2135 {
	width: 13px;
	height: 7px;
	background: rgba(255, 45, 45, 1);
	opacity: 1;
	position: absolute;
	top: 24px;
	left: 13px;
	transform: rotate(-179deg);
}

.v479_2136 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2136.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 593px;
	left: 1242px;
	overflow: hidden;
}

.v479_2137 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2138 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2138.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2139 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2140 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2140.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2141 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2141.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2142 {
	width: 13px;
	height: 7px;
	background: rgba(18, 179, 63, 1);
	opacity: 1;
	position: absolute;
	top: 17px;
	left: 0px;
}

.v479_2143 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2143.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 672px;
	left: 1242px;
	overflow: hidden;
}

.v479_2144 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2145 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2145.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2146 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2147 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2147.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2148 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2148.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2149 {
	width: 13px;
	height: 7px;
	background: rgba(18, 179, 63, 1);
	opacity: 1;
	position: absolute;
	top: 17px;
	left: 0px;
}

.v479_2150 {
	width: 158px;
	height: 30px;
	background: url("../images/v479_2150.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 751px;
	left: 1242px;
	overflow: hidden;
}

.v479_2151 {
	width: 158px;
	color: rgba(39, 59, 74, 0.699999988079071);
	position: absolute;
	top: 0px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 12px;
	opacity: 1;
	text-align: center;
}

.v479_2152 {
	width: 84px;
	height: 27px;
	background: url("../images/v479_2152.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 3px;
	left: 54px;
	overflow: hidden;
}

.v479_2153 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 15px;
	left: 0px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: left;
}

.v479_2154 {
	width: 42px;
	height: 25px;
	background: url("../images/v479_2154.png");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 42px;
	overflow: hidden;
}

.v479_2155 {
	width: 25px;
	height: 25px;
	background: url("../images/v479_2155.png");
	opacity: 1;
	position: absolute;
	top: 0px;
	left: 17px;
}

.v479_2156 {
	width: 13px;
	height: 7px;
	background: rgba(18, 179, 63, 1);
	opacity: 1;
	position: absolute;
	top: 17px;
	left: 0px;
}

.v479_2103 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 374px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2105 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 453px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2107 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 532px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2109 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 611px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2111 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 690px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2113 {
	width: 40px;
	color: rgba(60, 150, 185, 1);
	position: absolute;
	top: 769px;
	left: 812px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2104 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 374px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2106 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 453px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2108 {
	width: 40px;
	color: rgba(255, 45, 45, 1);
	position: absolute;
	top: 532px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2110 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 611px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2112 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 690px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}

.v479_2114 {
	width: 40px;
	color: rgba(18, 179, 63, 1);
	position: absolute;
	top: 769px;
	left: 975px;
	font-family: Roboto;
	font-weight: Regular;
	font-size: 10px;
	opacity: 1;
	text-align: center;
}
</style>