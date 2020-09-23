import java.io.File;

public class File_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f=new File("c:/hsbc_file");
		
		if(f.mkdir()) {
			System.out.println("directory created");
		}
		else {
			System.out.println("could not create Directory");
		}
	}

}
