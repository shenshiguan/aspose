package test;

public class T {

	public static void main(String[] args) {

		String filePath = "C:\\青岛科技大学分析化学考研真题2007年研究生入学考试试卷.doc";
		int nian_ = filePath.indexOf("年");
		int nianFen_ = nian_ - 4;
		String file_ = filePath.substring(nianFen_, nian_ + 1);
		System.out.println(file_);
		int tmp_ = filePath.lastIndexOf("\\");
		String newPath = filePath.substring(0, tmp_+1) + file_
				+ filePath.substring(tmp_+1, filePath.length()).replace(file_, "");
		
		newPath = newPath.replace(".", "研究生入学考试试卷.");
		System.out.println(newPath);

	}

}
