/*
 * Copyright © 2004-2021 L2J Server
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
package com.l2jserver.gameserver.dao.factory.impl;

import static com.l2jserver.gameserver.config.Configuration.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.l2jserver.gameserver.dao.factory.IDAOFactory;

/**
 * DAO Factory implementation.
 * @author Zoey76
 */
public class DAOFactory {
	private DAOFactory() {
		// Hide constructor.
	}
	
	public static IDAOFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder {
		private static final Logger LOG = LoggerFactory.getLogger(DAOFactory.class);
		
		protected static IDAOFactory INSTANCE = null;
		
		static {
			switch (database().getEngine()) {
				case "MSSQL", "OracleDB", "PostgreSQL", "H2", "HSQLDB" -> throw new UnsupportedOperationException(database().getEngine() + " is not supported!");
				case "MariaDB", "MySQL" -> INSTANCE = MySQLDAOFactory.INSTANCE;
			}
			LOG.info("Using {} DAO Factory.", INSTANCE.getClass().getSimpleName().replace("DAOFactory", ""));
		}
	}
}
