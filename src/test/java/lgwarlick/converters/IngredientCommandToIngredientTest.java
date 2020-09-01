package lgwarlick.converters;

import lgwarlick.commands.IngredientCommand;
import lgwarlick.commands.UnitOfMeasureCommand;
import lgwarlick.domain.Ingredient;
import lgwarlick.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        //given
        IngredientCommand command = new IngredientCommand();
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(UOM_ID);

        command.setId(LONG_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        command.setUom(uomCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(LONG_VALUE, ingredient.getId());
        assertEquals(UOM_ID, ingredient.getUom().getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }

    @Test
    public void convertWithNullUoM() {
        //given
        IngredientCommand command = new IngredientCommand();
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();

        command.setId(LONG_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(LONG_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }

}