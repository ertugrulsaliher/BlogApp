package org.ertugrul.saliherspringblog.Init;

import lombok.RequiredArgsConstructor;
import org.ertugrul.saliherspringblog.controller.CategoryController;
import org.ertugrul.saliherspringblog.controller.CommentController;
import org.ertugrul.saliherspringblog.controller.PostController;
import org.ertugrul.saliherspringblog.controller.UserController;
import org.ertugrul.saliherspringblog.dto.requestDto.CategorySaveDTO;
import org.ertugrul.saliherspringblog.dto.requestDto.CommentSaveDTO;
import org.ertugrul.saliherspringblog.dto.requestDto.PostSaveDTO;
import org.ertugrul.saliherspringblog.dto.requestDto.UserSaveDTO;
import org.ertugrul.saliherspringblog.entity.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {
    private final UserController userController;
    private final PostController postController;
    private final CommentController commentController;
    private final CategoryController categoryController;

    public void saveUsers(){
        UserSaveDTO userDTO1 = new UserSaveDTO("John", "Doe", "john.doe@example.com", "password1", "password1");
        UserSaveDTO userDTO2 = new UserSaveDTO("Alice", "Smith", "alice.smith@example.com", "password2", "password2");
        UserSaveDTO userDTO3 = new UserSaveDTO("Bob", "Johnson", "bob.johnson@example.com", "password3", "password3");
        UserSaveDTO userDTO4 = new UserSaveDTO("Emily", "Davis", "emily.davis@example.com", "password4", "password4");
        userController.save(userDTO1);
        userController.save(userDTO2);
        userController.save(userDTO3);
        userController.save(userDTO4);
    }
    public void savePosts(){
        PostSaveDTO postDTO = new PostSaveDTO(
                1L, // Kullanıcı ID
                "Nasıl Java öğrenirim?", // Başlık
                "Java öğrenmek için nereden başlamalıyım? Birçok kaynak var, ama hangisi en iyisi?",
                List.of(1L) // Kategori ID'leri
        );
        postController.save(postDTO);
    }

    public void saveComments(){
        CommentSaveDTO commentDTO1 = new CommentSaveDTO("BilgeAdamın kurslarına yazılabilirisin",2L,1L);
        CommentSaveDTO commentDTO2 = new CommentSaveDTO("OCP Study Guide kitabını edinebilirisn",3L,1L);
        CommentSaveDTO commentDTO3 = new CommentSaveDTO("O kitaba nereden ulaşabilirim",4L,1L);
        CommentSaveDTO commentDTO4 = new CommentSaveDTO("İnternetten alabilirsin",3L,1L);
        commentController.save(commentDTO1);
        commentController.save(commentDTO2);
        commentController.save(commentDTO3);
        commentController.save(commentDTO4);
    }
    public void saveCategories(){
        CategorySaveDTO categoryDTO1 = new CategorySaveDTO("Technology", "Articles related to technology and innovation.");
        CategorySaveDTO categoryDTO2 = new CategorySaveDTO("Travel", "Articles about traveling destinations and tips.");
        CategorySaveDTO categoryDTO3 = new CategorySaveDTO("Food", "Articles about cooking recipes and culinary experiences.");
        CategorySaveDTO categoryDTO4 = new CategorySaveDTO("Fitness", "Articles about fitness routines and health tips.");
        categoryController.save(categoryDTO1);
        categoryController.save(categoryDTO2);
        categoryController.save(categoryDTO3);
        categoryController.save(categoryDTO4);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveUsers();
        saveCategories();
        savePosts();
        saveComments();
    }
}
