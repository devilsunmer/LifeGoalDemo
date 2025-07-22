package model;

import java.text.SimpleDateFormat;
import java.util.List;

import com.RealTimeUI;

public class MonthCount {
	public static String generateReport() {
		
		Integer start = RealTime.getIncome();
		Integer goal = RealTime.getHopeSave();
		List<MonthRecord> records = RealTime.MonthRecords();
	    StringBuilder monthCountPrint = new StringBuilder();

	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append(" 每日進出紀錄\n");
	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append("日期        | 支出   | 存入\n");
	    monthCountPrint.append("------------|--------|-------\n");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
	    for (DayRecord dayCode : RealTime.getDayRecords()) {
	        monthCountPrint.append(String.format("%-12s| %6d元 | %5d元 | %s \n", dayCode.getDate(), dayCode.getSpend(), dayCode.getSaving(),dayCode.getItem()));
	    }

	    monthCountPrint.append("\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append(" 支出分類紀錄\n");
	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append("日期        | 類別   | 金額\n");
	    monthCountPrint.append("------------|--------|-------\n");
	    for (MonthRecord monthCode : RealTime.MonthRecords() ) {
	        monthCountPrint.append(String.format("%-12s| %6d元 | %5d元 | %s \n", monthCode.getDate(), monthCode.getPay(),monthCode.getSave(), monthCode.getItemSet()));
	    }

	    monthCountPrint.append("\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append(" 最終結果\n");
	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");

	    monthCountPrint.append(String.format("總支出：    %6d 元\n", RealTime.getTotalSpend().toString()));
	    monthCountPrint.append(String.format("總存入：    %6d 元\n", RealTime.getTotalSaving().toString()));

	    monthCountPrint.append("\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append(" 儲蓄目標總覽\n");
	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    monthCountPrint.append(String.format(" 儲蓄目標：    %5d  \n", RealTime.getGoal()));
	    monthCountPrint.append(String.format(" 這個月起始金額：   %5d 元\n", RealTime.getHopeSave().toString()));
	    monthCountPrint.append(String.format(" 預期存入金額：   %5d 元\n", RealTime.getIncome().toString()));
	    monthCountPrint.append(String.format(" 固定支出金額：   %5d 元\n", RealTimeUI.fixedSpendStart.toString()));

	    monthCountPrint.append("＝＝＝＝＝＝＝＝＝＝＝＝＝＝\n");
	    return monthCountPrint.toString();
	    
	}
}
