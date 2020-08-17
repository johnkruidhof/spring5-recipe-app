package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class RecipeServiceImplTest {

    @Mock
    private RecipeRepository recipeRepository;

    private RecipeServiceImpl recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipeSet = Set.of(new Recipe());
        when(recipeRepository.findAll()).thenReturn(recipeSet);
        Set<Recipe> result = recipeService.getRecipes();
        assertEquals(1, result.size());
        verify(recipeRepository, times(1)).findAll();
    }
}