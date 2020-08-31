package lgwarlick.services;

import lgwarlick.commands.RecipeCommand;
import lgwarlick.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
