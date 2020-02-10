package org.example.dao;

import java.util.List;
import org.example.api.Contact;
import org.example.dao.mappers.ContactMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterColumnMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapperFactory;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindMethods;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface ContactDAO {

    @SqlQuery("select * from contact where id = ?")
    @RegisterColumnMapper(ContactMapper.class)
    Contact findById(@Bind("id") int id);

    @SqlUpdate("insert into contact (id, firstName, lastName, phone) values (null,:getFirstName, :getLastName,:getPhone)")
    void insert(@BindMethods Contact contact);

    @SqlUpdate("update contact set firstName = :getFirstName, lastName = :getLastName, phone = :getPhone where id = :id")
    void update(@Bind("id") int id,@BindMethods Contact contact);

    @SqlUpdate("delete from contact where id = :id")
    void delete(@Bind("id") int id);

}
