package wc;

import java.io.*;;

public class wcTest {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根

		String inputFile = "";// 定义待读取文件目录
		int charNum = 0; // 字符数
		int wordNum = 0; // 单词数
		int lineNum = 0; // 行数
		System.out.println("**** -c   [文件名]  返回文件的字符数");
        System.out.println("**** -w   [文件名]  返回文件词的数目");
        System.out.println("**** -l   [文件名]  返回文件的行数");
		System.out.println("请输入指令:");
		InputStream iStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(iStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = bufferedReader.readLine();
		String[] strings = str.split("\\s");
		// 获取文件目录名
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].endsWith(".java"))
				inputFile = strings[i];
		}

		// 字符数统计
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-c")) { // -c对应字符个数统计
				BufferedReader bff = new BufferedReader(new FileReader(inputFile));
				String str1;
				String str2 = bff.readLine();
				while ((str1 = str2) != null) {
					charNum = charNum + str1.length();
					charNum++;
					if ((str2 = bff.readLine()) == null)
						charNum--;
				}
				bff.close();
				String file = inputFile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + ",字符个数:" + charNum);
			}
		}

		// 行数统计
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-l")) { // -l对应字符行数统计
				BufferedReader bff = new BufferedReader(new FileReader(inputFile));
				while (bff.readLine() != null)
					lineNum++;
				bff.close();
				String file = inputFile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + ",文件总行数:" + lineNum );
			}
		}

		// 单词数统计
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-w")) { // -w对应字符个数统计
				BufferedReader bff = new BufferedReader(new FileReader(inputFile));
				StringBuffer sBuffer = new StringBuffer();
				String str1;
				while ((str1 = bff.readLine()) != null)
					sBuffer = sBuffer.append(str1 + " ");
				str1 = sBuffer.toString();
				// 把中英文标点符号都替换为“ ”
				String str2 = str1.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ");
				String[] str3 = str2.split("\\s+");
				wordNum = str3.length;
				bff.close();
				String file = inputFile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + ",单词个数:" + wordNum);
			}
		}
	}
}
