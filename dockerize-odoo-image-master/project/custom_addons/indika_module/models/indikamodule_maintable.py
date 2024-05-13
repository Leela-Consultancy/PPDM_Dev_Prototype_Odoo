from odoo import models, fields

class INDIKAModuleMainTable(models.Model):
    _name = 'indikamodule.maintable'
    _description = 'Main Table'

    name = fields.Many2one('indikamodule.websitestable', ondelete='set null', string="Website Reference")
    policy = fields.Text('Privacy Policy', related='name.privacy', store=True)
    cookie_category = fields.Char('Cookie Category', required=True)
    description = fields.Text('Cookie Category Description', required=True)
    website_to_indika = fields.One2many('indikamodule.mappingtable', 'indika_id', string="Module Mapping")
