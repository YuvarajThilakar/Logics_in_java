package directory;
public class File {

	private String name;
	private String extention;
	private String content;
	
	public File(String name, String extention) {
		this.name = name;
		this.extention = extention;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		File that = (File)obj;
		return (this.getName()+this.getContent()).compareTo((that.getName()+that.getContent())) == 0;
	}

	@Override
	public String toString() {
		return name + "." + extention ;
	}
	
	
	
}
