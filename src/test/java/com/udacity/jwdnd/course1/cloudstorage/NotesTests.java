package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotesTests extends BaseTests{
	private String noteTitle = "Some Title";
	private String noteDesc = "Discription of the title";

	@Test
	public void testAddNote() {
		addNote();
		homePage.goToNotesTab();
		Note note = homePage.getFirstNote();
		Assertions.assertEquals(noteTitle, note.getNoteTitle());
		Assertions.assertEquals(noteDesc, note.getNoteDescription());
		homePage.deleteNote();
	}

	public void addNote() {
		Assertions.assertEquals("Home", signUpAndLogin());
		homePage.goToNotesTab();
		homePage.enterNote(noteTitle, noteDesc);
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();
	}

	@Test
	public void testEditNote() {
		String newTitle = "New Title";
		String newDesc = "New Description";
		addNote();

		//Check if new note is inserted
		homePage.goToNotesTab();
		Note note = homePage.getFirstNote();
		Assertions.assertEquals(noteTitle, note.getNoteTitle());
		Assertions.assertEquals(noteDesc, note.getNoteDescription());

		homePage.editNote(newTitle, newDesc);
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();

		homePage.goToNotesTab();
		note = homePage.getFirstNote();
		Assertions.assertEquals(newTitle, note.getNoteTitle());
		Assertions.assertEquals(newDesc, note.getNoteDescription());
		homePage.deleteNote();
	}

	@Test
	public void testDeleteNote() {
		addNote();

		//Check if new note is inserted
		homePage.goToNotesTab();
		Note note = homePage.getFirstNote();
		Assertions.assertEquals(noteTitle, note.getNoteTitle());
		Assertions.assertEquals(noteDesc, note.getNoteDescription());

		homePage.deleteNote();
		ResultPage resultPage = new ResultPage(driver);

		//Go back to home page
		resultPage.clickOk();

		homePage.goToNotesTab();
		try{
			homePage.getFirstNote();
			assertTrue(false);
		}catch (NoSuchElementException e){
			assertTrue(true);
		}
	}
}
