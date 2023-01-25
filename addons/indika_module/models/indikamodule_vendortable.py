from odoo import models, fields



class INDIKAModuleVendorTable(models.Model):
	_name = 'indikamodule.vendortable'
	vendor_name = fields.Char('VendorName', required=True)
	vendor_url = fields.Char('VendorURL', required=True)


