from odoo import models, fields


class INDIKAModuleWebsitesTable(models.Model):
    _name = 'indikamodule.websitestable'
    name = fields.Char('Site Name', required=True)
    desc = fields.Char('Site Brief', required=True)
    url = fields.Char('Site Url', required=True)
    privacy = fields.Text('Privacy Policy', required=True)

