package com.bwanaian;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ParaTodos")
public interface ParaTodosConfig extends Config
{
	@ConfigItem(
		keyName = "greeting",
		name = "Coming soon...",
		description = "This option is still being worked on"
	)
	default String greeting()
	{
		return "";
	}
}
