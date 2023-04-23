from odoo import models, fields, api


class INDIKAModuleCookiedataTable(models.Model):
    _name = 'indikamodule.cookiedatatable'
    name = fields.Char('Cookie Data', required=True)
    cookie_description = fields.Char('Cookie Description', required=True)
    cookie_type = fields.Selection([('firstparty', 'First Party'), ('thirdparty', 'Third Party'), ], 'Cookie Type',
                                  default='firstparty')
    vendor_id = fields.Many2one('indikamodule.vendortable', string='Vendor Site')

