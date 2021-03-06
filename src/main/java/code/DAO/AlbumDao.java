package code.DAO;

import code.entity.Album;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Optional;

public class AlbumDao implements Dao<Album> {
    HibernateAnnotationUtil hibernateAnnotationUtil=new HibernateAnnotationUtil();

    @Override
    public Optional<Album> get(int id) {
        hibernateAnnotationUtil.openCurrentSession();
        hibernateAnnotationUtil.getCurrentSession();
        Album album=hibernateAnnotationUtil.getCurrentSession().load(Album.class, id);
        hibernateAnnotationUtil.closeCurrentSession();
        return Optional.ofNullable(album);
    }
    @Override
    public Optional<Album> getByName(String name)  {
        hibernateAnnotationUtil.openCurrentSession();
        Album album=null;
        album = (Album) hibernateAnnotationUtil.getCurrentSession().createCriteria(Album.class)
                .add(Restrictions.eq("nameAlbum", name)).uniqueResult();
        hibernateAnnotationUtil.closeCurrentSession();
        return Optional.ofNullable(album);
    }

    @Override
    public List<Album> getAll() {
        List<Album> albums=null;
        hibernateAnnotationUtil.openCurrentSession();
        albums = hibernateAnnotationUtil.getCurrentSession().createCriteria(Album.class).list();
        hibernateAnnotationUtil.closeCurrentSession();
        return albums;
    }

    @Override
    public void save(Album album) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().save(album);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Album album) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().update(album);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void delete(Album album) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().delete(album);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void saveOrUpdate(Album album) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().saveOrUpdate(album);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }
}
