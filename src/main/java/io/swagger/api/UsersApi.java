/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-04T07:44:48.337Z[GMT]")
@Validated
public interface UsersApi {

    @Operation(summary = "creating a user", description = "creating a user | User access; Employee", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Created a user"),
        
        @ApiResponse(responseCode = "400", description = "Invalid request, user not created") })
    @RequestMapping(value = "/users",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body);


    @Operation(summary = "delete a user", description = "deleting a user using the userid | User access; Employee", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "employees" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "user has been deleted successfully") })
    @RequestMapping(value = "/users/{userid}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "The userid for the user to delete", required=true, schema=@Schema()) @PathVariable("userid") Integer userid);


    @Operation(summary = "get a user using user ID", description = "get a specific user using an ID | User access; Customer (can only get their user details) & Employee", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "employees", "customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A json account object", content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class)))) })
    @RequestMapping(value = "/users/{userid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> getUser(@Parameter(in = ParameterIn.PATH, description = "The userid of the user", required=true, schema=@Schema()) @PathVariable("userid") Integer userid);


    @Operation(summary = "get users", description = "getting a list of users | User access; Customer (can only get their own user details) & Employee", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "employees", "customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A JSON array of users", content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class)))) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> getUsers(@Parameter(in = ParameterIn.QUERY, description = "The number of items to skip before starting to collect the result set" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset, @Parameter(in = ParameterIn.QUERY, description = "The numbers of items to return" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit);


    @Operation(summary = "update a user", description = "updating a user using a userid | User access; Customer(can only update their own user details) & Employee", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "employees", "customers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "user has been updated successfully") })
    @RequestMapping(value = "/users/{userid}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "The userid for the user to update", required=true, schema=@Schema()) @PathVariable("userid") Integer userid, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody User body);

}

