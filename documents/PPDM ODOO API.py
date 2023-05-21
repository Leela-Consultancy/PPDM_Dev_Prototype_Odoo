import xmlrpc.client as xmlrpc

url = 'http://localhost:8069'  # The URL of your Odoo instance
db = 'PPDM'  # The name of the database you're connecting to
username = 'hariharan@leelaconsultancy.co.uk'  # Your username
password = 'Leela@#123'  # Your password

# Get the common service proxy
common = xmlrpc.ServerProxy('{}/xmlrpc/2/common'.format(url))

# Call the authenticate method to verify your credentials and get the user id
uid = common.authenticate(db, username, password, {})

# If the uid is False, then the credentials were incorrect
if not uid:
    print("Failed to authenticate!")
    exit()

# Get the object proxy
models = xmlrpc.ServerProxy('{}/xmlrpc/2/object'.format(url))

# Prepare the values for the new record
website_data = {
    'name': 'Web Site',
    'url': 'www.odoo.com',
    'desc': 'Record inserted using API',
}

# Call the create method to create a new record
website_id = models.execute_kw(
    db, uid, password,
    'indikamodule.websitestable', 'create',
    [website_data]
)

print("Created new Website with ID:", website_id)
