package cn.fuyoushuo.fengshui.utils;

import java.math.BigDecimal;

public class MathUtil {
	
	/**
	 * 对double数据进行四舍五入,并且保留两位小数. 
	 * @param originDouble double数据.
	 * @return 四舍五入后的数据.
	 */
	public static double round(double originDouble) {
	    return round(originDouble, 2);
	}
	
	/**
	 * 对double数据进行四舍五入,并且保留n位小数. 
	 * @param originDouble double数据.
	 * @return 四舍五入后的数据.
	 */
	public static double round(double originDouble, int n) {
		BigDecimal bd = new BigDecimal(originDouble);
		bd = bd.setScale(n, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * double 相加, 四舍五入保留两位小数
	 */
	public static double sum(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return round(bd1.add(bd2).doubleValue());
	}

	/**
	 * double 相减, 四舍五入保留两位小数
	 */
	public static double sub(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return round(bd1.subtract(bd2).doubleValue());
	}

	/**
	 * double 乘法, 四舍五入保留两位小数
	 */
	public static double mul(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return round(bd1.multiply(bd2).doubleValue());
	}
	
	/**
	 * 对double取相反数, 四舍五入保留两位小数
	 */
	public static double negative(double originDouble){
		BigDecimal bd = new BigDecimal(Double.toString(originDouble));
		return round(bd.negate().doubleValue());
	}

	/**
	 * double 除法, 四舍五入保留两位小数
	 */
	public static double div(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 根据积分求等级,等级与积分计算公式y=100x^2+400x
	 */
	public static int getLevelByPoint(long point) {
		return (int) ((Math.sqrt(4 + 0.01 * point) - 2));
	}
	
	/**
	 * 根据魅力值求魅力等级,等级与积分计算公式2y=100x^2+400x
	 */
	public static int getLevelByCharmPoint(long point) {
		return (int) ((Math.sqrt(4 + 0.005 * point) - 2));
	}
}
