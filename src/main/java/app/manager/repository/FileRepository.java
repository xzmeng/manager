package app.manager.repository;

import app.manager.model.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileRepository {

    private SessionFactory sessionFactory;

    private final static Log log = LogFactory.getLog(FileRepository.class);

    public FileRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean saveFile(File file) {
        Session session = sessionFactory.openSession();
        session.save(file);
        session.close();
        log.info("saved file: " + file);
        return true;
    }

    public List<File> getFiles() {
        Session session = sessionFactory.openSession();
        String hql = "from File";
        Query<File> query = session.createQuery(hql, File.class);
        List<File> result = query.list();
        session.close();
        return result;
    }
}
