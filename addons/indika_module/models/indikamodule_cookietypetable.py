from odoo import models, fields



class INDIKAModuleCookietypeTable(models.Model):
	_name = 'indikamodule.cookietypetable'
	name = fields.Char('CookieName', required=True)


