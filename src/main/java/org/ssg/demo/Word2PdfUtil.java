package org.ssg.demo;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

public class Word2PdfUtil {

	
	public static void main(String[] args) {

		try {
//			Document doc;
//			doc = new Document("C:/bbb/d5496c1ca4f2446fa417b8bcc739ac07_英语2013.doc");
//			doc.save("C:/bbb/d5496c1ca4f2446fa417b8bcc739ac07_英语2013.pdf", SaveFormat.PDF);
			doc2pdf("C:/ddd/d5496c1ca4f2446fa417b8bcc739ac07_英语2013.doc","C:/ddd/d5496c1ca4f2446fa417b8bcc739ac07_英语2013.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Word2PdfUtil.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    public static void doc2pdf(String inPath, String outPath) {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath); // 新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
                                         // EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
