package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository{

    @PersistenceUnit(unitName = "imageHoster")

    //The method receives the Comment object to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    private EntityManagerFactory emf;
    public Comment createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;

    }

    //This method  receives the Image object from the database
    //    Creates an instance of EntityManager
    //   Executes JPQL query to fetch the image from the database with corresponding id
    //    Get all comments associated with the particular image id
    public List<Comment> getCommentsById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
          //
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.image.id =:id", Comment.class).setParameter("id", id);
            return typedQuery.getResultList();
        } catch (NoResultException nre) {
            return null;
        }

    }

}