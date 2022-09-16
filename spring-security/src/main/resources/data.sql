/* client_secret column is set as the encrypted value of "secret" - the password for the clients  */
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('web-client', 'pass', 'read,write',
	'password,authorization_code,refresh_token,client_credentials', null, null, 36000, 36000, null, true);
