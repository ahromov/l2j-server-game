/*
 * Copyright © 2004-2020 L2J Server
 *
 * This file is part of L2J Server.
 *
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.config;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Reloadable;

/**
 * Custom Buffer Configuration.
 * @author Andrii Hromov
 * @version 1.0.0.2
 */
@Sources({
	"file:./config/pvpCommunityBoard.properties",
	"classpath:config/pvpCommunityBoard.properties"
})
@HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface CustomBufferConfiguration extends Config, Reloadable {
	
	@Key("CommunityBuffer")
	boolean getCommunityBuffer();
	
	@Key("BuffFreeLevel")
	int getBuffFreeLevel();
	
	@Key("BuffItemId")
	int getBuffItemId();
		
	@Key("BuffPrice")
	int getBuffPrice();
	
	@Key("BuffTime")
	int getBuffTime();
		
}