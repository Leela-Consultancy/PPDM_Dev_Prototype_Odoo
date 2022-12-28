from odoo import models, fields



class INDIKAModuleCookiecategoryTable(models.Model):
	_name = 'indikamodule.cookiecategorytable'
	cookie_category_name = fields.Char('CookieCategoryName', required=True)


