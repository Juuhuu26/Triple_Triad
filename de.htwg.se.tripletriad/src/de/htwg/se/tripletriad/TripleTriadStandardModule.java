package de.htwg.se.tripletriad;

import com.google.inject.AbstractModule;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.model.IGamefieldFactory;

public class TripleTriadStandardModule extends AbstractModule {

	@Override
	protected void configure() {
	    
		bind(ITripleTriadController.class)
			.to(de.htwg.se.tripletriad.controller.impl.TripleTriadController.class);
		
		bind(IGamefieldFactory.class)
		    .to(de.htwg.se.tripletriad.model.impl.GamefieldStandardFactory.class);
	}
}
