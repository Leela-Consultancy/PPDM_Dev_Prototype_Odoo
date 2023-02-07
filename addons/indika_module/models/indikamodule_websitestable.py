from odoo import models, fields


class INDIKAModuleWebsitesTable(models.Model):
	_name = 'indikamodule.websitestable'
	name = fields.Char('Title', required=True)
	desc = fields.Char('Description', required=True)
	url = fields.Char('Url', required=True)
	cookie_type_id = fields.Many2one('indikamodule.cookietypetable', 'CookieTypeId')
	vendor_id = fields.Many2one('indikamodule.vendortable', 'VendorId')

