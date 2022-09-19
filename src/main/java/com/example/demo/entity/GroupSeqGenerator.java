package com.example.demo.entity;

import com.example.demo.config.Dashboard;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Properties;


public class GroupSeqGenerator extends SequenceGenerator {
    @Autowired
    private Dashboard dashboard;
    private String PREFIX_PARAM = "";
    private Integer SEQ_DEFAULT_VALUE = 100;

    private Long prefixValueLong;
    private Integer prefixValueInt;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        prefixValueLong = prefixValueLong != null ? prefixValueLong : SEQ_DEFAULT_VALUE;
        Number current = generateHolder(session).makeValue();
        if (current instanceof Long) {
            return ((prefixValueLong * 10) + current.longValue());
        }
        return prefixValueInt + current.longValue();
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(type, params, serviceRegistry);
        try {
            prefixValueLong = ConfigurationHelper.getLong(PREFIX_PARAM, params, SEQ_DEFAULT_VALUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            prefixValueInt = ConfigurationHelper.getInt(PREFIX_PARAM, params, SEQ_DEFAULT_VALUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
