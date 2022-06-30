package gradestudent;

import java.util.Scanner;

public class GradeStudent {
    public static int weightMid = 0;
    public static int weightFinal = 0;
    public static int weightHome = 0;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        begin();

        double wm = midTerm();
        double wf = finalTern();
        double wh = homework();
        report(wm, wf, wh);
    }
    public static void begin(){
        //Tieu de cua bai cua bang tinh diem
        System.out.println("This program reads exam/homework scores \n and reports your overall course grade");
    }
    public static double midTerm(){
        System.out.println("Midterm: ");
        //Nhap trong diem nam trong khoang 0 -100
        do{
            System.out.print("Weight (0-100)? ");
            weightMid = sc.nextInt();
        }while((weightMid < 0) || (weightMid >100));

        //Nhap diem co duoc nam trong khoang 0-100
        System.out.print("Scores earned? ");
        int scoresEearnd = 0;
        do{
            System.out.print("Scores (0-100)? ");
            scoresEearnd = sc.nextInt();
        }while((scoresEearnd < 0) || (scoresEearnd >100));

        int scoreAdd = 0;
        int totalPoint = 0;

        //Nhap diem them, neu chon 1 la muon them diem, nhap 2 la khong muon them
        //Neu them diem thi diem cong diem hien tai
        //Neu khong them thi diem them se la 0
        //Sau do thuc hien tinh toan
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int chon = sc.nextInt();
        if(chon == 1){
            System.out.print("Score want to add ");
            scoreAdd = sc.nextInt();
        }else{
            scoreAdd = 0;
        }
        //Neu diem tong >100 thi cap nhat lai diem la 100
        totalPoint = scoreAdd + scoresEearnd;
        if(totalPoint > 100){
            totalPoint = 100;
        }

        double weightMidtermScore = Math.round(totalPoint * 100.0)/ 100.0;
        double weightScore = Math.round((weightMidtermScore/ 100 * weightMid) * 100.0)/100.0;
        System.out.println("Total points = "+totalPoint +"/ 100");
        System.out.println("Weight score = "+ weightScore + "/ "+weightMid);

        return weightScore;
    }
    public static double finalTern(){
        System.out.println("Final: ");
        //Nhap trong diem nam trong 0-100
        do{
            System.out.print("Weight (0-100)? ");
            weightFinal = sc.nextInt();
        }while(((weightMid + weightFinal) < 0) || ((weightFinal + weightMid) >100));

        //Nhap diem hien tai trong khoan 0-100
        System.out.print("Scores earned? ");
        int scoresEearnd = 0;
        do{
            System.out.print("Scores (0-100)? ");
            scoresEearnd = sc.nextInt();
        }while((scoresEearnd < 0) || (scoresEearnd > 100));

        int scoreAdd = 0;
        int totalPoint = 0;

        //Nhap lua chon
        //Neu la 1 la cong them diem, 2 la khong muon them
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int chon = sc.nextInt();
        if(chon == 1){
            System.out.print("Score want to add ");
            scoreAdd = sc.nextInt();
        }else{
            scoreAdd = 0;
        }
        totalPoint = scoreAdd + scoresEearnd;
        //Sau khi tinh tong diem, tong diem >100 thi cap nhap lai la 100
        if(totalPoint > 100){
            totalPoint = 100;
        }

        //Thuc hien tinh toan
        double weightFinaltermScore = Math.round(totalPoint * 100.0)/ 100.0;
        double weightScore = Math.round((weightFinaltermScore/100 * weightFinal) * 100.0) / 100.0;
        System.out.println("Total points = "+weightFinaltermScore + "/ 100");
        System.out.println("Weight score = "+ weightScore + "/ "+ weightFinal);
        return weightScore;
    }
    public static double homework(){
        System.out.println("Homework: ");
        //Nhap trong diem nam trong khoan 0-100
        System.out.print("Weight (0-100)? ");
        do{
            weightHome = sc.nextInt();
        }while((weightMid + weightHome + weightFinal) < 0 || (weightMid + weightHome + weightFinal) > 100);

        //Nhap so luong asm
        System.out.print("Number of assignments? ");
        int numberASM = sc.nextInt();
        int score = 0;
        int max = 0;
        int total = 0;
        int countScore = 0;
        int totalMax = 0;
        int countMax = 0;
        int i = 1;
        do{
            System.out.print("Assignment "+i+" score and max? ");
            //Neu diem max nho hon diem hien tai thi cho nhap lai
            do{
                System.out.print("\n Enter score less than max  : ");
                score = sc.nextInt();
                max = sc.nextInt();

            }while(max < score);

            //tong diem max > 150 thi cap nhat lai 150
            if(countMax > 150){
                countMax = 150;
            }
            countScore += score;
            countMax += max;
            i++;
        }while(i <= numberASM);

        //Nhap so buoi chuyen can
        System.out.print("How many sections did you attend? ");
        int sections = sc.nextInt();
        int sectionPoints = sections * 5;
        //Neu diem chuyen can >30 thi cap nhat lai 30
        if(sectionPoints >30){
            sectionPoints = 30;
        }
        //Tinh tong diem hien tai va tong diem max
        total = countScore + sectionPoints;
        totalMax = countMax + 30;
        //thuc hien thu gon so va tinh toan
        double weightScore = Math.round((double) total/totalMax * weightHome * 10.0)/10.0;
        System.out.print("Section points = "+sectionPoints + "/ 30\n");
        System.out.print("Total points = "+total +"/ "+totalMax + "\n");
        System.out.print("Weight score = " + weightScore + "/ "+weightHome +"\n");
        return weightScore;
    }
    public static void report(double weightMid, double weightFinal, double weightHw){
        double overall = weightMid + weightFinal + weightHw;
        double gpa = 0;
        String messages = "";
        //Neu diem tong >= 85% thi gpa =3, diem tong >=75 thi gpa= 2, diem tong >= 60 thi gpa = 1, diem tong < 60 thi gpa =0
        if(overall >= 85){
            gpa = 3;
            messages = "Let's continue to promote you";
        }else if(overall >= 75){
            gpa = 2;
            messages = "Pretty good, keep it up";
        }else if(overall >= 60){
            gpa = 1;
            messages = "Keep it up";
        }else if(overall < 60){
            gpa = 0;
            messages = "You need to try harder, I believe you can definitely do it";
        }

        //In ra diem tong, gpa va tin nhan tuong ung
        System.out.println("Overall percentage = "+ overall);
        System.out.println("Your grade will be at least: "+gpa);
        System.out.println(messages);

    }
}
