package code.DAO;


import code.entity.Artist;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class ArtistDao implements Dao<Artist> {
    HibernateAnnotationUtil hibernateAnnotationUtil=new HibernateAnnotationUtil();
    @Override
    public Artist get(int id) {
        hibernateAnnotationUtil.openCurrentSession();
        hibernateAnnotationUtil.getCurrentSession();
        Artist artist=hibernateAnnotationUtil.getCurrentSession().load(Artist.class, id);
        hibernateAnnotationUtil.closeCurrentSession();
        return artist;
    }

    @Override
    public Artist getByName(String name)  {
        hibernateAnnotationUtil.openCurrentSession();
        Artist artist=null;
        artist = (Artist) hibernateAnnotationUtil.getCurrentSession().createCriteria(Artist.class)
                .add(Restrictions.eq("nameArtist", name)).uniqueResult();
      //  hibernateAnnotationUtil.getCurrentSession();
       // Artist artist=hibernateAnnotationUtil.getCurrentSession().load(Artist.class, name);
        hibernateAnnotationUtil.closeCurrentSession();
        return artist;
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> artists=null;
        hibernateAnnotationUtil.openCurrentSession();
        artists = hibernateAnnotationUtil.getCurrentSession().createCriteria(Artist.class).list();
        hibernateAnnotationUtil.closeCurrentSession();
        return artists;
    }

    @Override
    public void save(Artist artist) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().save(artist);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Artist artist, String[] params) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().update(artist);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void delete(Artist artist) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().delete(artist);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }
}
