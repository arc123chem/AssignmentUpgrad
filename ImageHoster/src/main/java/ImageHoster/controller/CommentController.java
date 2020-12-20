package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ImageHoster.service.ImageService;
import ImageHoster.service.CommentService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
@Controller
public class CommentController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentService commentService;
    //This controller method is called when the request pattern is of type '/image/{imageId}/{imageTitle}/comments'
    //This method fetches the image with the corresponding id from the database.
    //The method then returns 'images/{imageId}/{imageTitle' file wherein you fill all the updated details of the comments for that image

    //The comment from the user is set to upload comment



    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String uploadComment(@PathVariable("imageTitle") String imageTitle, @PathVariable("imageId") Integer imageId, @RequestParam(name = "comment") String  comment, Model model, Comment uploadComment, HttpSession session) throws IOException {

        User user = (User) session.getAttribute("loggeduser");
        uploadComment.setUser(user);

        Image image = imageService.getImage(imageId);

        uploadComment.setImage(image);
        uploadComment.setText(comment);
        uploadComment.setCreatedDate(new Date());
        Comment imageComments =commentService.createComment(uploadComment);

        return "redirect:/images/{imageId}/{imageTitle}";
    }

}
