package de.dhbw.tinf.ddd.infrastructure.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.server.VaadinCDIServlet;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = LectureScheduleUi.class)
public class LectureScheduleVaadinServlet extends VaadinCDIServlet{

}
