package com.kuakao.util.filetools.log;

import java.io.FileWriter;
import java.io.IOException;

public class LogOut {
//	public static String filePath = "D:/batch_files/jpg2pdf.log";
	public static String filePath = "";
	public FileWriter fw = null;
	public static void main(String[] args) throws IOException {
		
	}
	LogOut(){

	}
	public LogOut(String filePath){
		if(filePath!=null&&!"".equals(filePath))
			LogOut.filePath = filePath;
	}
	/**  
     *   
     * @param filePath  
     * @param content  
     */ 
    public void fileChaseFW( String content) {  
		try {
			if(fw==null){
				fw = new FileWriter(filePath,true);
			}
			fw.write(content+"\r\n");
			fw.flush();
		} catch (IOException e) {  
			System.out.println("日志异常�?" + e);  
		}  
    }
    
    
    public  void close() throws IOException{
		if(fw != null)
			fw.close();  
    }
}
