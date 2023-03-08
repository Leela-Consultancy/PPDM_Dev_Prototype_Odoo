from odoo import models, fields



class INDIKAModuleCookiecategoryTable(models.Model):
    _name = 'indikamodule.cookiecategorytable'
    name = fields.Char('CookieCategoryName', required=True)
    cookie_category_description = fields.Text('CookieCategoryDescription', required=True)
    website_id = fields.Many2one('indikamodule.websitestable', 'Website Data')