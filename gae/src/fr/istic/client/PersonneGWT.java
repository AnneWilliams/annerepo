package fr.istic.client;


import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PersonneGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync service = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		
		VerticalPanel v1 = new VerticalPanel();
		HorizontalPanel p1 = new HorizontalPanel();
		HorizontalPanel p2 = new HorizontalPanel();
		VerticalPanel v2 = new VerticalPanel();
		VerticalPanel v3 = new VerticalPanel();
		
		Label l1 = new Label("Name");
		final TextBox t1 = new TextBox();
		p1.add(l1);
		p1.add(t1);
//		p1.add(b);
		v1.add(p1);
		
		Label l2 = new Label("FirstName");
		final TextBox t2 = new TextBox();
		Button b = new Button("create");
		p2.add(l2);
		p2.add(t2);
		p2.add(b);
		v2.add(p2);

		
	
		
		
		
		Button bs = new Button("listAllPerson");
		v3.add(bs);
		
		RootPanel.get().add(v1);
		RootPanel.get().add(v2);
		RootPanel.get().add(v3);
		
		b.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				service.createPerson(t2.getText(), t1.getText(), new AsyncCallback<Person>() {
					
					@Override
					public void onSuccess(Person result) {
						Window.alert("Ok " + result.getName() + " cree");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		});
		
		bs.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				service.listAllPerson(new AsyncCallback<List<Person>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(List<Person> result) {
						StringBuffer buf = new StringBuffer();
						for (Person p : result){
							buf.append("person " + p.getId() + " "+ p.getFirstName() + " " + p.getName());
						}
						Window.alert(buf.toString());
					}
				});
			}
		});
		
		
		
		VerticalPanel v4 = new VerticalPanel();
		HorizontalPanel p3 = new HorizontalPanel();
		HorizontalPanel p4 = new HorizontalPanel();
		HorizontalPanel p5 = new HorizontalPanel();
		HorizontalPanel p6 = new HorizontalPanel();
		HorizontalPanel p7 = new HorizontalPanel();
		VerticalPanel v5 = new VerticalPanel();
		VerticalPanel v6 = new VerticalPanel();
		VerticalPanel v7 = new VerticalPanel();
		VerticalPanel v8 = new VerticalPanel();
		VerticalPanel v9 = new VerticalPanel();
		Button b2 = new Button("create home");
		Label l3 = new Label("Adresse");
		final TextBox t3 = new TextBox();
		p3.add(l3);
		p3.add(t3);
//		p1.add(b);
		v4.add(p3);
		
		Label l4 = new Label("Superficie");
		final TextBox t4 = new TextBox();
		p4.add(l4);
		p4.add(t4);
		//p2.add(b);
		v5.add(p4);
		
		Label l5 = new Label("Adresse IP");
		final TextBox t5 = new TextBox();
		p5.add(l5);
		p5.add(t5);
		p5.add(b2);
		//p2.add(b);
		v6.add(p5);

		
//		Label l7 = new Label("Superficie");
//		final TextBox t7 = new TextBox();
//		p7.add(l7);
//		p7.add(t7);
//		//p2.add(b);
//		v8.add(p7);
		
		
		
		
		
		Button b2s = new Button("listAllHome");
		v7.add(b2s);
		
		RootPanel.get().add(v4);
		RootPanel.get().add(v5);
		RootPanel.get().add(v6);
		RootPanel.get().add(v7);
		
		
		
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				service.createHome(t3.getText(), Integer.parseInt(t4.getText()),t5.getText(), new AsyncCallback<Home>() {
					
					@Override
					public void onSuccess(Home result) {
						Window.alert("Ok " + result.getAdresse() + " cree");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		});
		
		b2s.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				service.listAllHome(new AsyncCallback<List<Home>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(List<Home> result) {
						StringBuffer buf = new StringBuffer();
						for (Home h : result){
							buf.append("home " + h.getAdresse() + " "+ h.getSuperficie() + " " + h.getAdresse_ip());
						}
						Window.alert(buf.toString());
					}
				});
			}
		});
		
		
	}
}
