package com.example.demo.Jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class MController {  
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private MyUserDetailsService userDetailsService; 
	@Autowired 
	Pservice ps;
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	@PostMapping("/addproduct")
	public Employee23 saveProduct1(@RequestBody Employee23 e)
	{
		return ps.saveProduct(e);
	} 
	@PostMapping("/addmultiple")
	public List<Employee23> saveAll1(@RequestBody List<Employee23> e)
	{
		return ps.saveAll23(e);
	}
    @PostMapping("/getbyid")
    public Employee23 getbyid(@RequestBody Employee23 e)
    {
    	return ps.getproductbyId(e);
    } 
    @GetMapping("/") 
    public List<Employee23> getAllProducts()
    {
    	return ps.getProducts();
    } 
    @PostMapping("/findbyname")
    public Employee23 findbyNmae(@RequestBody Employee23 s)
    {
    	return ps.getProductByName(s.getName());
    } 
    @PostMapping("/deleteproduct")
    public String deleteproduct(@RequestBody Employee23 e)
    {
    	return ps.deleteProductById(e.getId());
    } 
    @PostMapping("/updateproduct") 
    public Employee23 updateproduct(@RequestBody Employee23 e)
    {
    	return ps.updateProduct(e);
    }
}
