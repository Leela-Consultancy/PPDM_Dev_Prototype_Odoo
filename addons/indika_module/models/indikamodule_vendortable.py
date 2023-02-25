from odoo import models, fields



class INDIKAModuleVendorTable(models.Model):
	_name = 'indikamodule.vendortable'
	name = fields.Char('VendorName', required=True)
	vendor_url = fields.Char('VendorURL', required=True)
	cookie_type_id = fields.Many2one('indikamodule.cookietypetable', 'CookieTypeId')
	website_id = fields.Many2one('indikamodule.websitestable', 'WebsiteID')


