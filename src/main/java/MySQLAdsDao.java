import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {

    private List<Ad> ads = new ArrayList<>();
    private Connection connection;

    @Override
    public Long insert(Ad ad) {

        Long newAdID = -1L;

        String query = String.format("INSERT INTO ads(user_id, title, description) VALUES ('%s', '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription());

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New ID: " + rs.getLong(1));
                newAdID = rs.getLong(1);

            }

        } catch(SQLException e){
            System.out.println("Problem connecting to database for adding ad");
            System.out.println(e);
        }


        return newAdID;
    }

    public MySQLAdsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public List<Ad> all() {

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");

            while(rs.next()){
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }

        }catch(SQLException e){

            e.printStackTrace();

        }
        return ads;
    }

}
