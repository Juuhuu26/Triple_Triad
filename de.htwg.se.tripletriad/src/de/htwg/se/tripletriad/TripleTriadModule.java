package de.htwg.se.tripletriad;

import com.google.inject.AbstractModule;

import de.htwg.se.tripletriad.controller.ITripleTriadController;

public class TripleTriadModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ITripleTriadController.class)
			.to(de.htwg.se.tripletriad.controller.impl.TripleTriadController.class);
	}
}
