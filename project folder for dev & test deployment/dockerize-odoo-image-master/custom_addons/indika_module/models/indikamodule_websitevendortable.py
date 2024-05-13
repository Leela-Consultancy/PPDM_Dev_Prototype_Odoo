from odoo import models, fields

class INDIKAModuleWebsitevendorTable(models.Model):
    _name = 'indikamodule.websitevendortable'
    _description = 'Website-Vendor Table'

    website_id = fields.Many2one('website.table', string="Website")
    vendor_id = fields.Many2one('vendor.table', string="Vendor")
    cookie_category_ids = fields.Many2many(
        'indikamodule.cookiecategorytable',
        'indikamodule_websites_vendors_categories_rel',
        'websitevendor_id', 'cookie_category_id',
        string="Cookie Categories"
    )

