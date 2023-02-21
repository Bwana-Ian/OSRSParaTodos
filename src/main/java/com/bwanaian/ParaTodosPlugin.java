package com.bwanaian;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.Widget;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

@Slf4j
@PluginDescriptor(
	name = "OSRS Para Todos"
)
public class ParaTodosPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ParaTodosConfig config;

	private HashMap<String,String> esTranslation;

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		String eng = event.getMenuEntry().getOption();
		if (esTranslation.containsKey(eng)){
			String tran = esTranslation.get(eng);
			event.getMenuEntry().setOption(event.getOption().replace(eng,tran));
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("OSRSParaTodos started!");
		esTranslation = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/bwanaian/es.csv"));
		String line = null;
		while((line=br.readLine()) != null){
			String str[] = line.split(",");
			esTranslation.put(str[0],str[1]);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("OSRSParaTodos stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{

	}

	@Provides
	ParaTodosConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ParaTodosConfig.class);
	}
}
