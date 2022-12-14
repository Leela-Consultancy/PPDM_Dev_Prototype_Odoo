from odoo import models, fields



class INDIKAModuleUsersTable(models.Model):
	_name = 'indikamodule.userstable'
	username = fields.Char('UserName', required=True)
	email = fields.Char('UserEmail', required=True)

