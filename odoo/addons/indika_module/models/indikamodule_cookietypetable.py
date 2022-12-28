from odoo import models, fields



class INDIKAModuleCookietypeTable(models.Model):
	_name = 'indikamodule.cookietypetable'
	cookie_type = fields.Char('CookieType', required=True)


