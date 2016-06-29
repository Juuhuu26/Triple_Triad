package de.htwg.se.tripletriad;

import com.google.inject.AbstractModule;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.model.IPlayerFactory;
import de.htwg.se.tripletriad.model.IGamefieldFactory;

public class TripleTriadModule extends AbstractModule {

	@Override
	protected void configure() {
	    
	    bind(IPlayerFactory.class)
	        .to(de.htwg.se.tripletriad.model.impl.PlayerFactory.class);
	    bind(IGamefieldFactory.class)
	        .to(de.htwg.se.tripletriad.model.impl.GamefieldFactory.class);
		bind(ITripleTriadController.class)
			.to(de.htwg.se.tripletriad.controller.impl.TripleTriadController.class);
	}
}
