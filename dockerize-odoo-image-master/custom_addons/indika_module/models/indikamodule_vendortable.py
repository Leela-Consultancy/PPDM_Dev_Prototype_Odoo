from odoo import models, fields


class INDIKAModuleVendorTable(models.Model):
    _name = 'indikamodule.vendortable'
    website_id = fields.Many2one('indikamodule.websitestable', string='Vendor Site(Website)', required=True)
    vendor_site_brief = fields.Char('Vendor Site Brief', related='website_id.desc', readonly=True)
    vendor_url = fields.Char('Vendor Site Url', related='website_id.url', readonly=True)
    cookie_ids = fields.One2many('indikamodule.cookiedatatable', 'vendor_id', string='Cookie Data')
