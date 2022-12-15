from odoo import models, fields



class PPDMModuleVendorTable(models.Model):
	_name = 'ppdmmodule_vendortable'
	vendor_name = fields.Char('VendorName', required=True)


