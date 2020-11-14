package atj;

public class CalculationsVO {
	public String firstValue;
	public String secondValue;
	public boolean firstValueActive;
	public String sign;
	public boolean isFirstValueAResult;
	
	public String getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	public boolean isFirstValueActive() {
		return firstValueActive;
	}
	public void setFirstValueActive(boolean firstValueActive) {
		this.firstValueActive = firstValueActive;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public boolean isFirstValueAResult() {
		return isFirstValueAResult;
	}
	public void setFirstValueAResult(boolean isFirstValueAResult) {
		this.isFirstValueAResult = isFirstValueAResult;
	}
}
