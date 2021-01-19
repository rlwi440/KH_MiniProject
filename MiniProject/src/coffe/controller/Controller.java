package coffe.controller;

import java.text.DecimalFormat;

public class Controller {
	
	//자릿수
	DecimalFormat dcf = new DecimalFormat(".##");

	//커피 비율 계산하는 메소드
	public String calCoffee(double water, double bean) {

		// 이상적 비율
		// water = 1000 ml , bean = 55g
		String result = null;
		double extraction = water / bean;

		if (extraction >= 15 && extraction <= 20) {
			result = dcf.format(extraction);
		} else if (extraction < 20) {
			result = dcf.format(extraction);
		} else if (extraction > 15) {
			result = dcf.format(extraction);
		}

		return result;
	}
	
	//비율 확인 후 텍스트 출력하는 메소드
	public String printCoffee(double water, double bean) {

		String print = null;
		double extraction = water / bean;

		double result = Double.parseDouble(calCoffee(water, bean));

		if (result >= 15 && result <= 20) {
			print = "좋은 비율 입니다. \n물의 온도는 90 ~ 100℃로 해주세요. \n총 시간을 4분을 넘기지 않도록 해주세요.\n";
		} else if (result > 20) {
			String beanShortage = dcf.format((water/20) - (bean));
			print = "원두가 부족합니다. \n이상적인 비율은 15 ~ 20 입니다.\n" + "약" + beanShortage + "g의 원두를 더 넣어주세요.\n";
		} else if (result < 15) {
			String waterShortage = dcf.format((15*bean)-(result*bean));
			print = "물이 부족합니다.\n이상적인 비율은 15 ~ 20 입니다.\n" + "약" +waterShortage + "ml의 물을 더 넣어주세요.\n";
		}

		return print;
	}

}
