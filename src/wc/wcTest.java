package wc;

import java.io.*;;

public class wcTest {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������

		String inputFile = "";// �������ȡ�ļ�Ŀ¼
		int charNum = 0; // �ַ���
		int wordNum = 0; // ������
		int lineNum = 0; // ����
		System.out.println("**** -c   [�ļ���]  �����ļ����ַ���");
        System.out.println("**** -w   [�ļ���]  �����ļ��ʵ���Ŀ");
        System.out.println("**** -l   [�ļ���]  �����ļ�������");
		System.out.println("������ָ��:");
		InputStream iStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(iStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = bufferedReader.readLine();
		String[] strings = str.split("\\s");
		// ��ȡ�ļ�Ŀ¼��
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].endsWith(".java"))
				inputFile = strings[i];
		}

		// �ַ���ͳ��
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-c")) { // -c��Ӧ�ַ�����ͳ��
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
				System.out.println(file + ",�ַ�����:" + charNum);
			}
		}

		// ����ͳ��
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-l")) { // -l��Ӧ�ַ�����ͳ��
				BufferedReader bff = new BufferedReader(new FileReader(inputFile));
				while (bff.readLine() != null)
					lineNum++;
				bff.close();
				String file = inputFile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + ",�ļ�������:" + lineNum );
			}
		}

		// ������ͳ��
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("-w")) { // -w��Ӧ�ַ�����ͳ��
				BufferedReader bff = new BufferedReader(new FileReader(inputFile));
				StringBuffer sBuffer = new StringBuffer();
				String str1;
				while ((str1 = bff.readLine()) != null)
					sBuffer = sBuffer.append(str1 + " ");
				str1 = sBuffer.toString();
				// ����Ӣ�ı����Ŷ��滻Ϊ�� ��
				String str2 = str1.replaceAll("[\\p{P}+~$`^=|<>�����ޣ�������������]", " ");
				String[] str3 = str2.split("\\s+");
				wordNum = str3.length;
				bff.close();
				String file = inputFile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + ",���ʸ���:" + wordNum);
			}
		}
	}
}
