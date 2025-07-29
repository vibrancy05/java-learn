package MovieManageModule;

public class Test {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        while (true) {
            movieService.start();
        }
    }
}
