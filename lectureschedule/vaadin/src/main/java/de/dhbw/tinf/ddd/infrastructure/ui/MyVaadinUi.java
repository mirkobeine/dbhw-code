package de.dhbw.tinf.ddd.infrastructure.ui;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import de.dhbw.tinf.ddd.application.CalendarApplicationService;
import de.dhbw.tinf.ddd.application.LectureApplicationService;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassId;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@CDIUI("")
@SuppressWarnings("serial")
public class MyVaadinUi extends UI {
	
	@Inject LectureApplicationService lectureAppService;
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				lectureAppService.createLecture("hugo", new StudentClassId("TINF13B4"));
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);
	}
}
