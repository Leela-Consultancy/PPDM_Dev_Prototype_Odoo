from odoo import models, fields



class OdooModuleOdooTable(models.Model):
	_name = 'odoomodule.odootable'	
	name = fields.Char('Title', required=True)	
	