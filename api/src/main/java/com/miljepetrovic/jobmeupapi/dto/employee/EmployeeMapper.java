package com.miljepetrovic.jobmeupapi.dto.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.miljepetrovic.jobmeupapi.dto.category.CategoryMapper;
import com.miljepetrovic.jobmeupapi.model.Employee;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public abstract class EmployeeMapper {

    @Named("employeeDto")
    @Mappings({@Mapping(target = "category", qualifiedByName = "categoryDto")})
    public abstract  EmployeeDto entityToDto(Employee employee);

    @Mappings({
        @Mapping(target = "skills", ignore = true),
        @Mapping(target = "benefits", ignore = true),
        @Mapping(target = "projects", ignore = true),
        @Mapping(target = "educations", ignore = true)
    })
    public abstract Employee dtoToEntity(EmployeeDto employeeDto);
}