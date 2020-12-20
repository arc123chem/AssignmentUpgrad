package ImageHoster.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
// Here the name of the table to be created in the database is explicitly mentioned as 'comments'.
// Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'Comment' class

@Table(name = "Comments")

public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
     //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name="createdDate")
    private Date  createdDate;

    //The 'comments' table is mapped to 'images' table with Many:One mapping
    //One image can have many comments but  comment is associated tha only one image
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "image_id")
    private Image image;

    //The 'comments' table is mapped to 'users' table with Many:One mapping
    //One user can have many comments but  comment is associated tha only one user
    //FetchType is EAGER

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "user_id")
    private User user;


   public Comment(List<Comment> comments) {
        this.comments = comments;
    }



    @ManyToMany(fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    //Constructors , getters and setters of the column attributes

    public  Comment() {}


    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Image getImage() {
        return image;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

