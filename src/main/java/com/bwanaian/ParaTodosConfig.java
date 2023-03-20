package com.bwanaian;

import com.bwanaian.config.lang;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ParaTodos")
public interface ParaTodosConfig extends Config
{
	@ConfigItem(
		keyName = "language",
		name = "Language",
		description = "Language you would like to translate to"
	)
	default lang lang()
	{
		return lang.SPANISH;
	}
}
