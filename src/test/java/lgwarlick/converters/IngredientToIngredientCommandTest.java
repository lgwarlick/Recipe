package lgwarlick.converters;

import lgwarlick.commands.IngredientCommand;
import lgwarlick.domain.Ingredient;
import lgwarlick.domain.Recipe;
import lgwarlick.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convertNullUom() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(LONG_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertNull(command.getUom());
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescription());

    }

    @Test
    public void testConvertWithUom() {
        //given
        Ingredient ingredient = new Ingredient();

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setId(LONG_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(uom);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertEquals(LONG_VALUE, command.getId());
        assertNotNull(command.getUom());
        assertEquals(UOM_ID, command.getUom().getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}