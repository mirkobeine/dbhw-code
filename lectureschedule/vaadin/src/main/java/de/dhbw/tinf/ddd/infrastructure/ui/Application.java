package de.dhbw.tinf.ddd.infrastructure.ui;

import java.lang.management.ManagementFactory;

import javax.naming.Reference;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.plus.jndi.Resource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.h2.server.web.WebServlet;

public class Application {

	private static String[] __dftConfigurationClasses = { "org.eclipse.jetty.webapp.WebInfConfiguration",
			"org.eclipse.jetty.plus.webapp.PlusConfiguration", "org.eclipse.jetty.webapp.WebXmlConfiguration",
			"org.eclipse.jetty.webapp.MetaInfConfiguration", "org.eclipse.jetty.webapp.FragmentConfiguration",
			"org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
			"org.eclipse.jetty.annotations.AnnotationConfiguration" };

	public static void main(String[] args) throws Exception {

		System.setProperty("java.naming.factory.url", "org.eclipse.jetty.jndi");
		System.setProperty("java.naming.factory.initial", "org.eclipse.jetty.jndi.InitialContextFactory");

		Server server = new Server(8080);

		MBeanContainer mbContainer = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
		server.addBean(mbContainer);

//		ServletHolder servletHolder = new ServletHolder(WebServlet.class);
//		servletHolder.setInitParameter("webAllowOthers", "1");
//		servletHolder.setInitParameter("trace", "1");
//		servletHolder.setInitOrder(1);
//		
//		ServletHandler servletHandler = new ServletHandler();
//		servletHandler.addServletWithMapping(servletHolder, "/dbconsole/*");
//		server.setHandler(servletHandler);
		
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");

		String wardir = "src/main/webapp";
		webapp.setResourceBase(wardir);
		webapp.setDescriptor(wardir + "/WEB-INF/web.xml");
		webapp.setParentLoaderPriority(true);

		webapp.setConfigurationClasses(__dftConfigurationClasses);

		webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*");

		server.setHandler(webapp);

		Reference ref = new Reference("javax.enterprise.inject.spi.BeanManager",
				"org.jboss.weld.resources.ManagerObjectFactory", null);

		new Resource("BeanManager", ref);

		server.start();

		server.join();
	}
}
