package net.developia.oop5;

import java.io.FileInputStream;
import java.util.Properties;

public class TVTest {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("product.properties"));
		String speakerName = props.getProperty("speaker");
		Class speakerClass = Class.forName(speakerName);
		
		String tvName = props.getProperty("tv");
		Class tvClass = Class.forName(tvName);
		// AppleTV에서 MarshallSpeaker
		Speaker speaker = (Speaker) speakerClass.getConstructor().newInstance();
		TV tv = (TV) tvClass.getConstructor().newInstance();
		tv.setSpeaker(speaker);
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.powerOff();
	}
}