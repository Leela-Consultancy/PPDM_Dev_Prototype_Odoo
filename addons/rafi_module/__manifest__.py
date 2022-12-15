{
	'name': 'PPDM Module',
    'summary' : "Privacy Policy Data Metrics",
	'description' : """Application Details""",
	'author' : "Leela Consultancy",
	'license' : "AGPL-3",
	'website' : "www.isgec.com",
	'category' : 'Uncategorized',
	'version' : '16.0.1.0.0',
	'depends' : ['base'],
	'data' : [
		     'security/groups.xml',
		     'views/ppdmmodule_websitestable.xml',
			 'views/ppdmmodule_userstable.xml',
			 'views/ppdmmodule_vendortable.xml',
	         'security/ir.model.access.csv',
	         ],	
}
