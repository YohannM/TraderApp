package dao;
import java.io.IOException;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataSource extends MysqlDataSource implements ServletContextListener
{	
    private static String url;
    private static String user;
    private static String pwd;
    private static String name;
    private static int port;

    public static void main(String[] args) throws IOException, SQLException
    {
        MysqlDataSource msqlds = DataSource.getMysqlDataSource();
        System.out.println(url);
        System.out.println(user);
        System.out.println(pwd);
        System.out.println(name);
        System.out.println(port);
        System.out.println(msqlds.getConnection());
    }
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();

        url = ctx.getInitParameter("DBURL");
        user = ctx.getInitParameter("DBUSER");
        pwd = ctx.getInitParameter("DBPWD");
        name = ctx.getInitParameter("DBNAME");
        String portStr = ctx.getInitParameter("DBPORT");
        port = Integer.parseInt(portStr);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // pas besoin de fermer la connexion avec DataSource
    }

    public static MysqlDataSource getMysqlDataSource() throws IOException 
    {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setServerName(url); 
        dataSource.setPortNumber(port);
        dataSource.setDatabaseName(name);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);

        return dataSource;
    }

    
}


