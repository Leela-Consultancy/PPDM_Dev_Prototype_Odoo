from odoo import models, fields



class PPDMModuleUsersTable(models.Model):
	_name = 'ppdmmodule.userstable'
	username = fields.Char('UserName', required=True)
	email = fields.Char('UserEmail', required=True)

