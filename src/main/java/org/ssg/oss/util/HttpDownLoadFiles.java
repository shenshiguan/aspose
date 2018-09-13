package org.ssg.oss.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpDownLoadFiles {

	public static void main(String[] args) {
		String file_ = "https://ekuakao.oss-cn-beijing.aliyuncs.com/kkoto/subjectPDF/0b876b9433fa4f8a8fdb47498b6e958e_%E4%B8%8A%E6%B5%B7%E5%AF%B9%E5%A4%96%E7%BB%8F%E8%B4%B8%E5%A4%A7%E5%AD%A6-%E9%87%91%E8%9E%8D%E7%AE%A1%E7%90%86%E5%AD%A6%E9%99%A2-%E9%87%91%E8%9E%8D%E5%AD%A6%E4%B8%93%E4%B8%9A%E8%B5%84%E6%96%99.pdf?Expires=3071614879&OSSAccessKeyId=LTAI3o1OZHRkwtpw&Signature=lnVmH2VBg6qoB9VEzJZqfITvIb0%3D&code=1494814879668";
		downLoad(file_);
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 *            下载的路径
	 * @return
	 */
	public static InputStream downLoad(String url) {
		String[] paths =  url.split("/");
		
		String fileName_ =  paths[paths.length-1];
		String fileName = fileName_.split("\\?")[0];
		
		
		InputStream in = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			HttpResponse response = client.execute(get);
			int code = response.getStatusLine().getStatusCode();
			if (code >= 200 && code < 300) {
				in = response.getEntity().getContent();
				System.out.println("==========================");
				
				saveFile("d:\\oss\\"+fileName,in);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return in;
	}

	public static void saveFile(String filePath,String fileName,InputStream in) {
		File file = new File(filePath+fileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			byte[] buff = new byte[4096];

			int len = 0;
			while ((len = in.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void saveFile(String filePathName,InputStream in) {
		File file = new File(filePathName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			byte[] buff = new byte[4096];

			int len = 0;
			while ((len = in.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}
