from odoo import models, fields


class INDIKAModuleVendorTable(models.Model):
    _name = 'indikamodule.vendortable'
    name = fields.Char('Vendor Name', required=True)
    vendor_url = fields.Char('Vendor Site Url', required=True)
    vendor_site_brief = fields.Char('Vendor Site Brief', required=True)
    cookie_ids = fields.One2many('indikamodule.cookiedatatable', 'vendor_id', string='Cookie Data')



