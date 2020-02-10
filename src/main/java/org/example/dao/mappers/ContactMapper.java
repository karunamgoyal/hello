package org.example.dao.mappers;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.example.api.Contact;
import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.RowMapperFactory;
import org.jdbi.v3.core.statement.StatementContext;

public class ContactMapper implements ColumnMapper<Contact> {

    public Contact map( ResultSet r,int index, StatementContext ctx) throws SQLException {
        return new Contact(r.getInt("id"),r.getString("firstName"),r.getString("lastName"),r.getString("phone"));
    }
}
