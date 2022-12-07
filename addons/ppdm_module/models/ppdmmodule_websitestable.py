from odoo import models, fields



class PPDMModuleWebsitesTable(models.Model):
	_name = 'ppdmmodule.websitestable'	
	name = fields.Char('Title', required=True)	
	desc = fields.Char('Description', required=True)	
    
	