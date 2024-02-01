package tech.codehunt.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

public class ProjectIO {

	private String result;
	
	@SuppressWarnings("finally")
	public String projectWrite(HttpServletRequest req, String uniqueFileName) {
		try {
			InputStream is = req.getPart("myfile").getInputStream();
			byte b[] = new byte[is.available()];
			is.read(b);
			
			@SuppressWarnings("deprecation")
//			String path = req.getRealPath("images\\myproject\\") + uniqueFileName;
			String path = "D:\\JavaProjectCodeHunt\\myportfolio\\src\\main\\webapp\\images\\myproject\\" + uniqueFileName;
		
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			
		    is.close();
		    fos.close();
		    
		    result = "success";
		
		}
		catch(Exception e) {
			result = "failed";
			e.printStackTrace();
		}
		finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public String projectDelete(HttpServletRequest req, String fileName) {
		try {
			
//			@SuppressWarnings("deprecation")
//			String path = req.getRealPath("images\\myproject\\") + fileName;
			String path = "D:\\JavaMvcProject\\myportfolio\\src\\main\\webapp\\images\\myproject\\" + fileName;
		    new File(path).delete();
		    
		    result = "success";
		
		}
		catch(Exception e) {
			result = "failed";
			e.printStackTrace();
		}
		finally {
			return result;
		}
	}
}
