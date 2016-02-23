package cal.rash;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CalcRegul {
	private static final String REG_1 = "[\\(](((\\d*\\.?\\d+)[\\+\\-\\//\\*]{1}){1,}(\\d*\\.?\\d+)){1,}[\\)]";
	private static final String MULT_DIV = "(\\d*\\.?\\d+)[\\//\\*]{1}(\\d*\\.?\\d+)";
	private static final String PLUS_MINUS = "(\\d*\\.?\\d+)[\\+\\-]{1}(\\d*\\.?\\d+)";
	private static CalcRegul cRegCalc;
	private static String txPrimer;
	
	public static CalcRegul get(){
		if (cRegCalc == null) {
			cRegCalc = new CalcRegul();
		}
		return cRegCalc;				
	}
    //выполняем то что в скобках сначала
	public String getScob(){
		String st = "";
		String res = txPrimer;
		try {
			Pattern pattern = Pattern.compile(REG_1);
			Matcher matcher = pattern.matcher(res);
			while(matcher.find()){
				st = matcher.group().substring(1, matcher.group().length()-1);
				res = matcher.replaceFirst(getCalc(st));
				matcher = pattern.matcher(res);
			}
			res = getCalc(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;		
	}
	//на вход без скобок такого типа 2*3*5
	public String getCalc(String s){
		String tmCalc = "";
		String res = s;
		try {
			//ищем умнож или деление
			Pattern pattern = Pattern.compile(MULT_DIV);
			Matcher matcher = pattern.matcher(res);
			while (matcher.find()){
				tmCalc = matcher.group();//1 действие
				res = matcher.replaceFirst(Calc(tmCalc));
				matcher = pattern.matcher(res);
			}
			//сложение или вычитание
			Pattern pattern_pm = Pattern.compile(PLUS_MINUS);
			Matcher matcher_pm = pattern_pm.matcher(res);
			while (matcher_pm.find()){
				tmCalc = matcher_pm.group();//1 действие
				res = matcher_pm.replaceFirst(Calc(tmCalc));
				matcher_pm = pattern_pm.matcher(res);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;		
	}
	
	//входящая строка должна соответствовать формат a*b или a-b и.т.д.
	public String Calc(String s){
		int i =0;
		float res = 0;
		try {
			if ((i=s.indexOf("*"))>0) {
				float a = Float.valueOf(s.subSequence(0, i).toString());
				float b = Float.valueOf(s.subSequence(i+1, s.length()).toString());
				res = a*b;
			};
			if ((i=s.indexOf("/"))>0) {
				float a = Float.valueOf(s.subSequence(0, i).toString());
				float b = Float.valueOf(s.subSequence(i+1, s.length()).toString());
				res = a/b;
			};
			if ((i=s.indexOf("+"))>0) {
				float a = Float.valueOf(s.subSequence(0, i).toString());
				float b = Float.valueOf(s.subSequence(i+1, s.length()).toString());
				res = a+b;				
			};
			if ((i=s.indexOf("-"))>0) {
				float a = Float.valueOf(s.subSequence(0, i).toString());
				float b = Float.valueOf(s.subSequence(i+1, s.length()).toString());
				res = a-b;
			};
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String temp = Float.toString((res));
		return temp;
	}

	public static void setText(String text) {
		CalcRegul.txPrimer = text;
	}

}
