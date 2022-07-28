package com.example.employeemanagement.employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.employeemanagement.config.JwtFilter;
import com.example.employeemanagement.controller.EmployeeController;
import com.example.employeemanagement.dto.AddressDTO;
import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.services.EmployeeServices;
import com.example.employeemanagement.services.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

//@ContextConfiguration(classes = SecurityConfiguration.class)

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
//@ContextConfiguration(classes = {WebApplicationContext.class})
public class EmployeeControllerTests {
	@MockBean
	EmployeeServices employeeService;
	
	@MockBean
	JwtTokenService jwtTokenService;
	
	@MockBean
	UserDetailsService userDetailsService;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	JwtFilter jwtFilter;
	
//	@Autowired
//	private WebApplicationContext context;
	
//	@BeforeEach
//	public void setup() {
//
//		mockMvc = MockMvcBuilders
//				.webAppContextSetup(context)
//				.apply(springSecurity()) 
//				.build();
//	}
	
	@Test
//	@WithUserDetails()
	public void testGetAll() throws Exception {

		
		RequestBuilder request = MockMvcRequestBuilders
                .get("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
         
        MvcResult response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();	
	}
	
	@Test
	public void testInsert() throws Exception {
		
		EmployeeDTO employee = new EmployeeDTO();
		AddressDTO address=new AddressDTO();
		DepartmentDTO department = new DepartmentDTO();
		department.setDepartmentName("AWS");
		department.setCity("mumbai");
		address.setBuildingName("Raj Apt");
		address.setCity("mumbai");
		address.setStreet("SV");
		address.setZipcode(400064);
		employee.setFirstName("Keyur");
		employee.setLastName("Modh");
		employee.setAddress(address);
		employee.setDepartment(department);
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(employee);
		RequestBuilder request = MockMvcRequestBuilders
                .post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON);
         
        MvcResult response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();	
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		EmployeeDTO employee = new EmployeeDTO();
		AddressDTO address=new AddressDTO();
		DepartmentDTO department = new DepartmentDTO();
		department.setDepartmentName("AWS");
		department.setCity("mumbai");
		address.setBuildingName("Raj Apt");
		address.setCity("mumbai");
		address.setStreet("SV");
		address.setZipcode(400064);
		employee.setFirstName("Keyur");
		employee.setLastName("Modh");
		employee.setAddress(address);
		employee.setDepartment(department);
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(employee);
		RequestBuilder request = MockMvcRequestBuilders
                .put("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON);
         
        MvcResult response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();	
		
	}
	
	@Test
	public void testDelete() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
                .delete("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
         
        MvcResult response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();	
		
	}
	
	@Test
	public void testSearch() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
                .get("/employees/search?firstName=keyur&lastName=modh")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
         
        MvcResult response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();	
		
	}
	
	
	
	
	
}
		
