package com.kuakao.util.filetools.all;

import java.io.File;
import java.io.IOException;

import com.kuakao.util.filetools.log.LogOut;

/***
 * 查询所有文件夹下 文件的数量 是否是2
 * 
 * @author Administrator
 *
 */
public class FileFindAll2 {
	static LogOut logout = new LogOut("D:/find_all_2018-06-26.txt");
	static long count = 0;

	static String DIRECTORY = "";
	public static void main(String[] args) {
//		String filePath = "E:/已核对历年真题/华南理工大学/城市规划设计（做图）2005/信号与系统-2005/";
		String filePath = "E:/资料包/";
		File file = new File(filePath);
		if (file != null) {
			recursionDirectory(file);
		}
		System.out.println("共有pdf文件：" + count + "份.");
		try {
			logout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void recursionDirectory(File file_1){
		try {
			if(file_1.isDirectory()){
				File[] files = file_1.listFiles();
				if(files.length ==0){
					System.out.println(file_1.getAbsolutePath());
					count++;
				}
				for(File file :files){
					recursionDirectory(file);
				}
			}else{

				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.exit(0);
		}
	}
	

}