package com.lstfight.portal.service.impl;

import com.lstfight.dao.service.BaseServerImpl;
import com.lstfight.portal.entity.SysDepartmentEntity;
import com.lstfight.portal.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class DepartmentServiceImpl extends BaseServerImpl<SysDepartmentEntity,Serializable> implements DepartmentService {

}
