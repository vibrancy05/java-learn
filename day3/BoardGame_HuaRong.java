package day3;

import java.util.Random;
import java.util.Scanner;

public class BoardGame_HuaRong {
    public static void main(String[] args) {
        int size=5;
        int[] emptyPos={size-1,size-1};
        //1.生成动态棋盘
        int [][] boards=initBoard(size,emptyPos);
        //2.打印棋盘
        while(true) {
            printBoards(boards);
            //3.键盘录入移动方向
            String direction = nextDirection();
            //4.移动棋子
            tryMove(boards, emptyPos, direction);
            //5.判断是否成功
            if(isSuccess(boards)){
                System.out.println("恭喜你，成功！");
                break;
            }
        }
    }

    public static int[][] initBoard(int size,int[] emptyPos) {

        int[][] boards = new int[size][size];
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                boards[i][j]=i*size+j+1;
                if(boards[i][j]==size*size){
                    boards[i][j]=0;
                }
            }
        }
        String[] strs = {"w","a","s","d"};
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int index = random.nextInt(4);
            String direction = strs[index];
            tryMove(boards, emptyPos, direction);
        }
        return boards;
    }

    public static boolean isSuccess(int[][] boards) {
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                if( boards[i][j]!=i*4+j+1 && boards[i][j]!=0 ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void tryMove(int[][] boards, int[] emptyPos, String direction) {
        //判断用户输入的方向，获取移动的偏移量offset
        int[] offset =switch(direction){
            case "w" -> new int[]{1,0};
            case "a" -> new int[]{0,1};
            case "s" -> new int[]{-1,0};
            case "d" -> new int[]{0,-1};
            default -> new int[0];
            };
        if(offset.length==0){
            System.out.println("输入错误！请重新输入");
            return;
        }
        //获取空格位置索引
        int emptyRow=emptyPos[0];
        int emptyCol=emptyPos[1];
        //获取移动后的位置索引
        int newRow=emptyRow+offset[0];
        int newCol=emptyCol+offset[1];
        if(newRow<0||newRow>=boards.length||newCol<0||newCol>=boards[0].length){
            System.out.println("越界！请重新输入");
            return;
        }
        System.out.println(boards[newRow][newCol]);
        //移动,将移动后的位置索引赋给空格位置索引
        boards[emptyRow][emptyCol]=boards[newRow][newCol];
        boards[newRow][newCol]=0;
        //更新空格位置的索引值
        emptyPos[0]=newRow;
        emptyPos[1]=newCol;
    }



    public static String nextDirection() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入移动方向（w：上，a：左，s：下，d：右）");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void printBoards(int[][] boards) {
        System.out.println("---------------------");
        for (int i = 0; i < boards.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < boards[i].length; j++) {
                String numStr=boards[i][j]<10?boards[i][j]+" ":boards[i][j]+"";
                numStr=boards[i][j]==0?"  ":numStr;
                System.out.print(numStr + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }

    }
}
