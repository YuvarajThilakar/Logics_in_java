package directory;

import java.util.HashMap;

import directory.exceptions.FileException;
import directory.exceptions.FolderException;

public class Folder {

	private String name;
	private HashMap<String, Folder> folders;
	private HashMap<String, File> files;

	public Folder(String name) {
		this.name = name;
		this.folders = new HashMap<String, Folder>();
		this.files = new HashMap<String, File>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Folder specific operations
	public Folder cd(String input) {
		return this.folders.get(input);
	}

	public void ls() {
		System.out.println("FOLDERS: ");
		for (String name : folders.keySet()) {
			System.out.println(folders.get(name));
		}

		System.out.println("FILES:");
		for (String name : files.keySet()) {
			System.out.println(files.get(name));
		}
	}

	public Folder md(String folderName) throws FolderException {

		if (folders.containsKey(folderName))
			throw new FolderException("Folder duplicate error...!");

		Folder folder = new Folder(folderName);
		folders.put(folderName, folder);
		return folder;
	}

	// File specific operations
	public void cf(String fileName, String extention) throws FileException {
		if (files.containsKey(fileName)) {
			throw new FileException("File duplicate error...!");
		}
		files.put(fileName, new File(fileName, extention));

	}

	public String open(String fileName) throws FileException {
		File file = files.get(fileName);

		if (file == null)
			throw new FileException("File not found error...!");

		return file.getContent();

	}

	public void ch(String fileName, String content) throws FileException {
		File file = files.get(fileName);

		if (file == null)
			throw new FileException("File not found error...!");
		
		file.setContent(content);
	}

	@Override
	public boolean equals(Object obj) {
		Folder that = (Folder) obj;
		return this.getName().equals(that.getName());
	}

	@Override
	public String toString() {
		return name;
	}

}
