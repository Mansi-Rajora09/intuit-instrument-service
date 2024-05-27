package com.springboot.intuit.utils;

import org.junit.jupiter.api.Test;
import com.springboot.intuit.entity.Category;
import com.springboot.intuit.entity.Instrument;
import com.springboot.intuit.payload.CategoryDto;
import com.springboot.intuit.payload.InstrumentDto;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtilityTest {


    @Test
    public void testUpdateInstrumentInfo() {
        // Mock data
        InstrumentDto instrumentDto = new InstrumentDto();
        instrumentDto.setName("Guitar");
        instrumentDto.setDescription("Acoustic guitar");
        instrumentDto.setId(123L);
        instrumentDto.setIsAvailable(true);
        instrumentDto.setLimitValue(5);
        instrumentDto.setInstrumentCondition("Good");
        instrumentDto.setRatings(4.5);
        instrumentDto.setContent("Guitar content");
        instrumentDto.setBrand("Fender");
        instrumentDto.setTags("Music, Instruments");

        Long instrumentId = 123L;

        Instrument instrument = new Instrument();

        // Mock the Utility class
        Utility utility = new Utility();

        // Call the method to be tested
        utility.updateInstrumentInfo(instrumentDto, instrumentId, instrument);

        // Verify that the fields are updated correctly
        assertEquals("Guitar", instrument.getName());
        assertEquals("Acoustic guitar", instrument.getDescription());
        assertEquals(123L, instrument.getId());
        assertEquals(true, instrument.getIsAvailable());
        assertEquals(5, instrument.getLimitValue());
        assertEquals("Good", instrument.getInstrumentCondition());
        assertEquals(4.5, instrument.getRatings());
        assertEquals("Guitar content", instrument.getContent());
        assertEquals("Fender", instrument.getBrand());
        assertEquals("Music, Instruments", instrument.getTags());
    }

    @Test
    public void testUpdateCategory_NameAndDescriptionProvided() {
        // Mock CategoryDto and Category objects
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("New Name");
        categoryDto.setDescription("New Description");

        Category category = new Category();
        category.setName("Old Name");
        category.setDescription("Old Description");

        // Create an instance of Utility
        Utility utility = new Utility();

        // Call the updateCategory method
        utility.updateCategory(categoryDto, category);

        // Assert that the category's name and description are updated
        assertEquals("New Name", category.getName());
        assertEquals("New Description", category.getDescription());
    }

    @Test
    public void testUpdateCategory_NameProvided() {
        // Mock CategoryDto and Category objects
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("New Name");

        Category category = new Category();
        category.setName("Old Name");
        category.setDescription("Old Description");

        // Create an instance of Utility
        Utility utility = new Utility();

        // Call the updateCategory method
        utility.updateCategory(categoryDto, category);

        // Assert that only the category's name is updated
        assertEquals("New Name", category.getName());
        assertEquals("Old Description", category.getDescription()); // Description remains unchanged
    }

    @Test
    public void testUpdateCategory_DescriptionProvided() {
        // Mock CategoryDto and Category objects
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setDescription("New Description");

        Category category = new Category();
        category.setName("Old Name");
        category.setDescription("Old Description");

        // Create an instance of Utility
        Utility utility = new Utility();

        // Call the updateCategory method
        utility.updateCategory(categoryDto, category);

        // Assert that only the category's description is updated
        assertEquals("Old Name", category.getName()); // Name remains unchanged
        assertEquals("New Description", category.getDescription());
    }

    @Test
    public void testUpdateCategory_NoChange() {
        // Mock CategoryDto and Category objects
        CategoryDto categoryDto = new CategoryDto(); // Both name and description are null

        Category category = new Category();
        category.setName("Old Name");
        category.setDescription("Old Description");

        // Create an instance of Utility
        Utility utility = new Utility();

        // Call the updateCategory method
        utility.updateCategory(categoryDto, category);

        // Assert that category remains unchanged
        assertEquals("Old Name", category.getName());
        assertEquals("Old Description", category.getDescription());
    }

}
