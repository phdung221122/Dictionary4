import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    protected Dictionary myDictionary = new Dictionary();

    //nhập từ thủ công từ CommandLine
    void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng:");
        int repeat = input.nextInt();//số lượng từ nhập vào bán phím
        String fake = input.nextLine();//để bỏ qua dòng trống

        //nhận vào vào từ tiếng anh và giải nghĩa tiếng việt
        for (int i = 0; i < repeat; i++) {
            String english = input.nextLine();
            String vietnamese = input.nextLine();
            Word temp = new Word(english, vietnamese);
            this.myDictionary.words.add(temp);
            //System.out.println(temp.getWord_target() + " " + temp.getWord_explain());
        }
        input.close();
    }

    //nhập từ sử dụng file
    public void insertFromFile() throws IOException {
        File fileDir = new File("C:\\Users\\ADMIN\\Documents\\Java shit\\Dictionary\\dictionaries.txt");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileDir), "UTF8"));

        String str;

        while ((str = in.readLine()) != null) {
            System.out.println(str);
            String[] parts = str.split("-");
            Word temp = new Word(parts[0], parts[1]);
            this.myDictionary.addWord(temp);
        }

        in.close();
    }

    //hàm tra cứu từ điển từ tiếng anh trả về từ tiếng việt bằng dòng lệnh
    public void dictionaryLookup() {
        Scanner inputWord = new Scanner(System.in);
        System.out.println("Nhập vào từ bạn muốn tra");
        String findWord = inputWord.nextLine();
        findWord = findWord.trim();
        Word temp = new Word(findWord, "0");
        int i = myDictionary.words.indexOf(temp);
        if (i < 0) {
            System.out.println("Không có từ bạn nhập trong từ điển của tôi");
            return;
        } else {
            System.out.println("Dịch: " + myDictionary.words.get(i).getWord_explain());
        }
    }

    //thêm từ
    public void addWord(Word x) {
        myDictionary.words.add(x);
    }

    //xóa từ
    public void removeWord(Word x) {
        myDictionary.words.remove(x);
    }

}
