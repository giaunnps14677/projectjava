package project1;

import java.util.Random;
import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        play();
    }
    public static void play(){

        Scanner sc = new Scanner(System.in);

        Random rd = new Random();
        //Tạo số ngẫu nhiên từ 0 -> 100
        int rdNumber = 0 + rd.nextInt((100 - 0) + 1);
        System.out.println(rdNumber);
        String answer = "";
        int  totalGames = 0;
        int  totalGuess = 0;
        int choSo = 0;
        do{
            System.out.println("Tôi đang nghĩ một số trong khoảng 0 đến 100...");
            System.out.print("Bạn đoán? ");
            //Nhập số dự đoán
            choSo = Integer.parseInt(sc.nextLine());
            totalGuess++;

            if(choSo > rdNumber){
                //Nếu số dự đoán lớn hơn số may mắn thì in ra câu
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            } else if(choSo < rdNumber) {
                //Nếu số dự đoán nhỏ hơn số may mắn thì in ra câu
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
            }else{
                //Nếu số dự đoán bằng số may mắn thì in ra câu sau đó thực hiện hỏi có tiếp tục chơi không, nếu co/c/y/yes thì quay lại nhập số dự đoán, ngược lại thoát khỏi vòn lặp
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau "+totalGuess+" lần dự đoán. ");
                System.out.println("Bạn có muốn tiếp tục chơi không? ");
                answer = sc.nextLine();
                totalGames++;
            }

        }while(choSo != rdNumber || answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("co") || answer.equalsIgnoreCase("c"));

        //In dữ liệu của trò chơi ra console
        report(totalGames, totalGuess);
    }
    public static void report(int totalGames, int totalGuess){
        System.out.println("Kết quả tổng quát của trò chơi: ");
        System.out.println("Tổng số lần chơi = "+totalGames);
        System.out.println("Tổng số lần dự đoán = "+ totalGuess);
        double guessAvg = totalGuess/totalGames;
        int bestGame = totalGuess/totalGames;
        System.out.println("Số dự đoán trung bình mỗi lượt = "+ guessAvg);
        System.out.println("Số lần dự đoán ít nhất = "+ bestGame);
    }
}
