databaseChangeLog = {

	changeSet(author: "zhoudi (generated)", id: "1387101485451-1") {
		createTable(tableName: "persistent_logins") {
			column(name: "series", type: "varchar(64)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_loPK")
			}

			column(name: "last_used", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(64)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-2") {
		createTable(tableName: "registration_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_PK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-3") {
		createTable(tableName: "requestmap") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "requestmapPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "config_attribute", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "http_method", type: "varchar(255)")

			column(name: "url", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-4") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-5") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "user_type", type: "char(1)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-6") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-7") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-10") {
		createIndex(indexName: "unique_url", tableName: "requestmap", unique: "true") {
			column(name: "http_method")

			column(name: "url")
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-11") {
		createIndex(indexName: "authority_uniq_1387101485200", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-12") {
		createIndex(indexName: "username_uniq_1387101485206", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-13") {
		createIndex(indexName: "FK143BF46A402D6B5A", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-14") {
		createIndex(indexName: "FK143BF46A9B02A77A", tableName: "user_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-8") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A9B02A77A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "zhoudi (generated)", id: "1387101485451-9") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A402D6B5A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
