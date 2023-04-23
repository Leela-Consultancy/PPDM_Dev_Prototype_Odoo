from odoo import models, fields



class INDIKAModuleCookiecategoryTable(models.Model):
    _name = 'indikamodule.cookiecategorytable'
    name = fields.Char('CookieCategory', required=True)
    cookie_category_description = fields.Text('Description', required=True)
    website_id = fields.Many2one('indikamodule.websitestable', 'Website Data')




