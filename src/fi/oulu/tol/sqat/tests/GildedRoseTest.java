package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_0_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Aged Brie", itemBrie.getName());
		assertEquals(1, itemBrie.getSellIn());
		assertEquals(1, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("+5 Dexterity Vest", itemBrie.getName());
		assertEquals(9, itemBrie.getSellIn());
		assertEquals(19, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_TestThatQualityNotNegative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 2, 0) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("+5 Dexterity Vest", itemBrie.getName());
		assertEquals(1, itemBrie.getSellIn());
		assertEquals(0, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_TestThatQualityNotMoreThan50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 20, 50) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Aged Brie", itemBrie.getName());
		assertEquals(19, itemBrie.getSellIn());
		assertEquals(50, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_ElixiryOfTheMongoose() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7) );
		
		// Act
		store.updateEndOfDay();

		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Elixir of the Mongoose", itemBrie.getName());
		assertEquals(4, itemBrie.getSellIn());
		assertEquals(6, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Sulfuras, Hand of Ragnaros", itemBrie.getName());
		assertEquals(0, itemBrie.getSellIn());
		assertEquals(80, itemBrie.getQuality());

	}

	@Test
	public void testUpdateEndOfDay_BackstagePass_QualityIncreaseEndOfDay() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Backstage passes to a TAFKAL80ETC concert", itemBrie.getName());
		assertEquals(14, itemBrie.getSellIn());
		assertEquals(21, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_QualityIncreaseMore_IfSellIn10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Backstage passes to a TAFKAL80ETC concert", itemBrie.getName());
		assertEquals(9, itemBrie.getSellIn());
		assertEquals(22, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_QualityIncreaseEvenMore_IfSellIn5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Backstage passes to a TAFKAL80ETC concert", itemBrie.getName());
		assertEquals(4, itemBrie.getSellIn());
		assertEquals(23, itemBrie.getQuality());

	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_ConjuredManaCake() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Conjured Mana Cake", itemBrie.getName());
		assertEquals(2, itemBrie.getSellIn());
		assertEquals(4, itemBrie.getQuality());

	}
 
}
