package lgwarlick.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();

    }

    @Test
    void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String description = "American";

        category.setDescription(description);

        assertEquals(description, category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}