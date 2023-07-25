package api.endpoints;

/* url : https://petstore.swagger.io/
 * 
 * Create uSer(Post): https://petstore.swagger.io/v2/user
 * Get uSer(Get): https://petstore.swagger.io/v2/user/{username}
 * Update uSer(Update): https://petstore.swagger.io/v2/user/{username}
 * Delete uSer(Delete): https://petstore.swagger.io/v2/user/{username}
 */


public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	// user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user{username}";
	public static String update_url=base_url+"/user{username}";
	public static String delete_url=base_url+"/user{username}";
	
	//Store Module
		// here you will create Store module url's
	
	//Pet Module
			// here you will create Pet module url's
	
}
