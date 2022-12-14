from odoo import models, fields



class INDIKAModuleCookiedataTable(models.Model):
	_name = 'indikamodule.cookiedatatable'
	cookie_name = fields.Char('CookieName', required=True)


