package code.DAO;

import code.entity.Composition;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Optional;


public class CompositionDao implements Dao<Composition> {
    HibernateAnnotationUtil hibernateAnnotationUtil=new HibernateAnnotationUtil();
    @Override
    public Optional<Composition> get(int id) {
        hibernateAnnotationUtil.openCurrentSession();
        hibernateAnnotationUtil.getCurrentSession();
        Composition composition=hibernateAnnotationUtil.getCurrentSession().load(Composition.class, id);
        hibernateAnnotationUtil.closeCurrentSession();
        return Optional.ofNullable(composition);
    }
    @Override
    public Optional<Composition> getByName(String name)  {
        hibernateAnnotationUtil.openCurrentSession();
        Composition composition=null;
        composition = (Composition) hibernateAnnotationUtil.getCurrentSession().createCriteria(Composition.class)
                .add(Restrictions.eq("nameComposition", name)).uniqueResult();
        hibernateAnnotationUtil.closeCurrentSession();
        return Optional.ofNullable(composition);
    }

    @Override
    public List<Composition> getAll() {
        List<Composition> compositions=null;
        hibernateAnnotationUtil.openCurrentSession();
        compositions = hibernateAnnotationUtil.getCurrentSession().createCriteria(Composition.class).list();
        hibernateAnnotationUtil.closeCurrentSession();
        return compositions;
    }

    @Override
    public void save(Composition composition) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().save(composition);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Composition composition) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().update(composition);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void delete(Composition composition) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().delete(composition);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }

    @Override
    public void saveOrUpdate(Composition composition) {
        hibernateAnnotationUtil.openCurrentSessionwithTransaction();
        hibernateAnnotationUtil.getCurrentSession().saveOrUpdate(composition);
        hibernateAnnotationUtil.closeCurrentSessionwithTransaction();
    }
}
