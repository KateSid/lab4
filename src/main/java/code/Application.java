package code;

import code.DAO.AlbumDao;
import code.DAO.ArtistDao;
import code.DAO.CompositionDao;
import code.entity.Album;
import code.entity.Artist;
import code.entity.Composition;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static void init(String nameComposition,int duration,  String nameAlbum, String genre, String nameArtist){
        Album album=new Album();
        Artist artist=new Artist();
        Composition composition=new Composition();
        composition.setDuration(duration);
        composition.setNameComposition(nameComposition);
        composition.setAlbum(album);
        Set<Composition> compositions=new HashSet<Composition>();
        compositions.add(composition);
        album.setGenre(genre);
        album.setNameAlbum(nameAlbum);
        album.setCompositions(compositions);
        Set<Album> albums=new HashSet<Album>();
        albums.add(album);
        artist.setNameArtist(nameArtist);
        ArtistDao artistDao=new ArtistDao();
        artist.setAlbums(albums);
        album.setArtist(artist);
        artistDao.save(artist);
    }

    public static void main(String[] args){
        init("Shape Of My Heart", 5, "Aerosmith", "Rock", "Aerosmith" );
        init("Dream On", 5, "Ten Summoner’s Tales", "Rock", "Sting" );
        init("Now or Never", 4, "The Drug In Me Is Reimagined", "PostHardcore", "Falling In Reverse" );
        init("The Drug In Me Is You", 6, "Radioactivity", "Pop", "Age of Days" );
        init("The Sound of Madness", 4, "The Sound of Madness", "Hard-rock", "Shinedown" );
        CompositionDao compositionDao=new CompositionDao();
        AlbumDao albumDao=new AlbumDao();
        List<Composition> compositions=compositionDao.getAll();
        for (Composition composition:compositions) {
            System.out.println("Duration: "+composition.getDuration()+" Name: "+composition.getNameComposition());
        }
        compositionDao.save(new Composition(albumDao.getByName("Aerosmith"), "Crazy", 8));
      /*  Composition composition=new Composition();
        composition.setDuration(8);
        composition.setNameComposition("Crazy");

        Album album=
        composition.setAlbum(album);
        albumDao.update(album);*/
//        compositionDao.save(composition);
        compositionDao.delete(compositionDao.getByName("Shape Of My Heart"));
    }
}
