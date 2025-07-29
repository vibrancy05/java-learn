package MovieManageModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static List<Movie> movies=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    public void start(){
        System.out.println("========电影信息操作系统========");
        System.out.println("1.添加电影信息");
        System.out.println("2.删除电影信息");
        System.out.println("3.修改电影信息");
        System.out.println("4.查询电影信息");
        System.out.println("5.退出系统");
        System.out.println("6.封杀某个导演");
        System.out.println("7.展示全部电影");
        System.out.println("请输入操作命令：");
        int command=scanner.nextInt();
        switch (command){
            case 1:
                addMovie();
                break;
            case 2:
                deleteMovie();
                break;
            case 3:
                updateMovie();
                break;
            case 4:
                queryMovie();
                break;
            case 5:
                System.out.println("退出成功！");
                System.exit(0);
            case 6:
                deleteDirector();
                break;
            case 7:
                queryAllMovies();
                break;
            default:
                System.out.println("输入命令有误！");
                break;
        }
        }

    private void queryAllMovies() {
        //展示全部电影
        System.out.println("展示全部电影");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void deleteDirector() {
        System.out.println("请输入导演名称：");
        String director = scanner.next();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getDirector().equals(director)) {
                movies.remove(i);
                System.out.println("删除成功！");
                i--;
            }

        }
    }

    private void updateMovie() {
        System.out.println("请输入电影名称：");
        String movieName = scanner.next();
        Movie movie = queryMovieByName(movieName);
        if (movie == null) {
            System.out.println("没有该电影！");
        } else {
            System.out.println("请输入新的电影名称：");
            String newMovieName = scanner.next();
            System.out.println("请输入新的导演名称：");
            String newDirector = scanner.next();
            System.out.println("请输入新的评分：");
            double newScore = scanner.nextDouble();
            System.out.println("请输入新的价格：");
            double newPrice = scanner.nextDouble();
        }
    }

    private void queryMovie() {
        //根据电影名称查询电影
        System.out.println("请输入电影名称：");
        String movieName = scanner.next();
        Movie movie = queryMovieByName(movieName);
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("没有找到此电影！");
        }
    }
    public Movie queryMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    private void deleteMovie() {
        System.out.println("请输入要删除的电影名称：");
        String movieName = scanner.next();
        Movie movie = queryMovieByName(movieName);
        if (movie != null) {
            movies.remove(movie);
            System.out.println("删除成功！");
        }
        else {
            System.out.println("未找到该电影！");
        }
    }

    private void addMovie() {
        Movie movie = new Movie();
        System.out.println("请输入电影名称：");
        movie.setMovieName(scanner.next());
        System.out.println("请输入电影评分：");
        movie.setScore(scanner.nextDouble());
        System.out.println("请输入导演名称：");
        movie.setDirector(scanner.next());
        System.out.println("请输入电影价格：");
        movie.setPrice(scanner.nextDouble());
        movies.add(movie);
        System.out.println("添加成功！");
    }
}

