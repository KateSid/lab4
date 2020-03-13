package code;

import code.DAO.ArtistDao;
import code.entity.Artist;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {

    public static void main(String[] args){
        Artist artist=new Artist();
        artist.setNameArtist("hhh");
        ArtistDao artistDao=new ArtistDao();
        artistDao.save(artist);
    }
}
