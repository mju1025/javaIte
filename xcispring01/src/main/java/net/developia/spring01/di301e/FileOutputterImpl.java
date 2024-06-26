package net.developia.spring01.di301e;

import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Value;

public class FileOutputterImpl implements FileOutputter{
	@Value("${fileName}")
	private String fileName;

	@Override
	public void output(String msg) throws Exception {
		FileWriter fw = new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
	}
}
