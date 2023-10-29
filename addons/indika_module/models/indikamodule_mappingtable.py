from odoo import models, fields, api


class INDIKAModulePPDMappingTable(models.Model):
    _name = 'indikamodule.mappingtable'
    _description = 'PPDM Mapping Table'
    name = fields.Many2one('indikamodule.vendortable', ondelete='set null', string='Vendor Site')
    cookie_data_id = fields.Many2one('indikamodule.cookiedatatable',  ondelete='set null', string='Cookie Data')
    indika_id = fields.Many2one('indikamodule.maintable', string='Website')

