package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotesTests extends BaseTests{
	@Test
	public void addNotes() {
		Assertions.assertEquals("Home", signUpAndLogin());
		homePage.goToNotesTab();
		homePage.enterNote("hello", "world");

		ResultPage resultPage = new ResultPage(driver);
		resultPage.clickOk();
		homePage.goToNotesTab();

		Note note = homePage.getFirstNote();
		Assertions.assertEquals("hello", note.getNoteTitle());
		Assertions.assertEquals("world", note.getNoteDescription());
	}
}
