from odoo import models, fields


class INDIKAModuleWebsitesTable(models.Model):
    _name = 'indikamodule.websitestable'
    name = fields.Char('Title', required=True)
    desc = fields.Char('Description', required=True)
    url = fields.Char('Url', required=True)
    cookie_category_ids = fields.One2many(
        'indikamodule.cookiecategorytable', 'website_id',
        string='Cookie Categories')
