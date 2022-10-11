package com.cb.tracker.binance.tools;

public class BinanceInit {

	public BinanceInit() {
		// TODO Auto-generated constructor stub

		try {
			new LoadListenKeys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Loading all listen keys failed");
			e.printStackTrace();
		}
	}

}
