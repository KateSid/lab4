package code.DAO;

import code.entity.Album;
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
    public void update(Album album, String[] params) {
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
}
