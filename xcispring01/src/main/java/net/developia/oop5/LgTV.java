package net.developia.oop5;

public class LgTV implements TV{
	private Speaker speaker = new HarmanSpeaker();

	
	public void powerOn() {
		System.out.println("LGTV: TV를 켭니다.");
	}
	public void powerOff() {
		System.out.println("LGTV: TV를 끕니다.");
	}
	public void channelUp() {
		System.out.println("LGTV: 채널을 올립니다.");
	}
	public void channelDown() {
		System.out.println("LGTV: 채널을 내립니다.");
	}
	public void soundUp() {
		System.out.println("LGTV: 소리를 키웁니다.");
	}
	public void soundDown() {
		System.out.println("LGTV: 소리를 줄입니다.");
	}
}
