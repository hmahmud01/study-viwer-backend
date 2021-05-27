package com.example.StudyViewer;

import com.example.StudyViewer.patientpackage.Patient;
import com.example.StudyViewer.studypackage.Study;
import com.example.StudyViewer.studypackage.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudyViewerApplicationTests {

	@Mock
	private StudyService studyService;

	@Test
	public void getStudyTest() {
		Patient patient = new Patient(
				"PC04",
				"PersonFirst",
				"PersonLast",
				LocalDate.now()
		);

		Patient patient1 = new Patient(
				"PC05",
				"AnonymousFirst",
				"AnonymousLast",
				LocalDate.now()
		);

		Study case1 = new Study(
				"DX",
				"Bilateral Hip J.",
				LocalDateTime.now(),
				patient);

		Study case2 = new Study(
				"MR",
				"CEREBRAL",
				LocalDateTime.now(),
				patient1);

		when(studyService.getStudy()).thenReturn(List.of(case1, case2));
		assertEquals(2, studyService.getStudy().size());
	}

	@Test
	public void addStudyTest(){
		Patient patient = new Patient(
				"PC01",
				"PersonFirst",
				"PersonLast",
				LocalDate.now()
		);

		Study case1 = new Study(
				"DX",
				"Bilateral Hip J.",
				LocalDateTime.now(),
				patient);

		studyService.addStudy(case1);
		verify(studyService, times(1)).addStudy(case1);
	}

	@Test
	public void deleteStudyTest(){
		studyService.deleteStudy(1L);
		verify(studyService, times(1)).deleteStudy(1L);
	}
}
