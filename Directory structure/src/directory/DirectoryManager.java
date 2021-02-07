package directory;

import java.util.Scanner;
import java.util.Stack;

import directory.exceptions.FileException;
import directory.exceptions.FolderException;

public class DirectoryManager {

	private Folder root;
	private Stack<Folder> folderStack;

	public DirectoryManager() {
		this.root = new Folder("~");
		folderStack = new Stack<Folder>();
		folderStack.push(root);
	}

	// Folder specific operations
	public void md(String folderName) throws FolderException {
		folderStack.peek().md(folderName);
	}

	public void cd(String[] path) throws FolderException {
		for (String value : path) {
			if (value.equals("~"))
				goToRoot();
			else if (value.equals(".."))
				getBack();
			else if (value.equals("."));
			else cd(value);
		}

	}

	public void ls() {
		folderStack.peek().ls();
	}

	public void printCurrentDirectoryPath() {

		for (Folder path : folderStack) {
			System.out.print(path + "/");
		}
		System.out.print(">");
		System.out.println();

	}

	// Helper class
	private void getBack() {
		if (!folderStack.peek().equals(root)) {
			folderStack.pop();
		}
	}

	// Helper class
	private void goToRoot() {
		folderStack = new Stack<Folder>();
		folderStack.push(root);
	}

	// Helper class
	private void cd(String folderName) throws FolderException {
		Folder folder = folderStack.peek().cd(folderName);

		if (folder == null) {
			throw new FolderException("Folder not found error...!");
		}

		folderStack.push(folder);
	}

	// File specific operations
	public void cf(String fileName, String extention) throws FileException {
		Folder folder = folderStack.peek();
		folder.cf(fileName, extention);
	}

	public void open(String fileName) throws FileException {
		Folder folder = folderStack.peek();
		System.out.println(folder.open(fileName));
	}

	public void ch(String fileName, String content) throws FileException {
		Folder folder = folderStack.peek();
		folder.ch(fileName, content);
	}

	public static void main(String[] args) {

		DirectoryManager directory = new DirectoryManager();
		Scanner scanner = new Scanner(System.in);
		String inputCommands;
		System.out.println("********** Advanced command line programming ***********");
		directory.printCurrentDirectoryPath();

		while (true) {

			inputCommands = scanner.nextLine();
			String[] commands = inputCommands.split(" ");
			try {
				if (commands[0].equals("md"))
					directory.md(commands[1]);
				else if (commands[0].equals("cd"))
					directory.cd(commands[1].split("/"));
				else if (commands[0].equals("ls"))
					directory.ls();
				else if (commands[0].equals("pwd"))
					;
				else if (commands[0].equals("cf"))
					directory.cf(commands[1], commands[2]);
				else if (commands[0].equals("open"))
					directory.open(commands[1]);
				else if (commands[0].equals("ch"))
					directory.ch(commands[1], commands[2]);
				else if (commands[0].equals("exit"))
					break;
				else
					System.out.println("Give valid Command..!");
			} catch (FolderException | FileException exception) {
				System.out.println(exception.getMessage());
			} finally {
				System.out.println();
				directory.printCurrentDirectoryPath();
			}
		}
		scanner.close();
	}
}
