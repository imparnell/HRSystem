package com.aug.actions;

import com.aug.actions.LoginAction;
import com.aug.entities.Employee;
import com.aug.services.EmployeeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class LoginActionTest {

	@Mock
    private EmployeeService mockEmployeeService;

    private LoginAction loginAction;

    @Before
	public void setUp() {
        loginAction = new LoginAction();
		loginAction.setEmployeeService(mockEmployeeService);
	}

	@Test
	public void loginSuccessShouldRedirectToWelcomePage() throws Exception {
		Employee employee = new Employee();
		employee.setEmail("test@test.com");
		loginAction.setEmployee(employee);

		when(mockEmployeeService.hasAuthentication(any(Employee.class))).thenReturn(true);
        assertThat(loginAction.execute(), is(equalTo("welcome")));

        verify(mockEmployeeService, times(1)).hasAuthentication(any(Employee.class));
	}

	@Test
	public void loginFailureShouldNotRedirectPage() throws Exception {
		when(mockEmployeeService.hasAuthentication(any(Employee.class))).thenReturn(false);
		assertThat(loginAction.execute(), is(equalTo("input")));

        verify(mockEmployeeService, times(1)).hasAuthentication(any(Employee.class));
	}

    @Test
    public void shouldRedirectToLoginPageWhenInitApp() throws Exception {
        assertThat(loginAction.init(), is(equalTo("input")));
    }
}