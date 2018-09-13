package com.kuakao.util.filetools.all;

import java.io.File;
import java.io.IOException;

import com.kuakao.util.filetools.log.LogOut;

/***
 * 鏌ヨ鎵�鏈夋枃浠跺す涓� 鏂囦欢鐨勬暟閲� 鏄惁鏄�2
 * 
 * @author Administrator
 *
 */
public class FileFindAll {
	static LogOut logout = new LogOut("D:/find_all_2018-06-26_yes_rar.txt");
	static long count = 0;

	static String DIRECTORY = "";
	public static void main(String[] args) {
//		String filePath = "E:/宸叉牳瀵瑰巻骞寸湡棰�/鍗庡崡鐞嗗伐澶у/鍩庡競瑙勫垝璁捐锛堝仛鍥撅級2005/淇″彿涓庣郴缁�-2005/";
		String filePath = "F:/宸叉牳瀵瑰巻骞寸湡棰�/";
		File file = new File(filePath);
		if (file != null) {
			recursionDirectory(file);
		}
		System.out.println("鍏辨湁pdf鏂囦欢锛�" + count + "浠�.");
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
//				if(files.length ==0){
//					System.out.println(file_1.getAbsolutePath());
//					count++;
//				}
				for(File file :files){
					recursionDirectory(file);
				}
			}else{
				if(file_1.getName().endsWith(".rar")){
					count++;
					System.out.println(file_1.getAbsolutePath());
					logout.fileChaseFW(file_1.getAbsolutePath());
				}else{
//					count++;
//					System.out.println("=====>"+file_1.getAbsolutePath());
//					logout.fileChaseFW("=====>"+file_1.getAbsolutePath());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.exit(0);
		}
	}
	

}