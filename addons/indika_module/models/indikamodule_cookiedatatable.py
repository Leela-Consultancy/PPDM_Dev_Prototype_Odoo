from odoo import models, fields



class INDIKAModuleCookiedataTable(models.Model):
	_name = 'indikamodule.cookiedatatable'
	cookie_name = fields.Char('CookieName', required=True)
	cookie_category_id = fields.Many2one('indikamodule.cookiecategorytable','CookieCategoryId')



