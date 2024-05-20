package net.developia.spring01.di302e;

public class OutputterImpl implements Outputter{
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;
	
	public OutputterImpl(FileOutputter fileOutputter, String name, String greeting) {
		this.fileOutputter = fileOutputter;
		this.name = name;
		this.greeting = greeting;
	}

	@Override
	public void greeting() {
		System.out.println(name + "님, " + greeting);
		
		try {
			if(fileOutputter != null)
				fileOutputter.output(name + "님, "+ greeting);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
