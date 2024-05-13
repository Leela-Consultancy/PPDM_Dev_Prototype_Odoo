from odoo import models, fields


class INDIKAModuleCookiecategoryTable(models.Model):
    _name = 'indikamodule.cookiecategorytable'
    _description = 'Cookie Category Table'

    name = fields.Char('Cookie Category', required=True)
    cookie_category_description = fields.Text('Description', required=True)
    website_id = fields.Many2one('indikamodule.websitestable', ondelete='set null', string='Website')
    main_table_id = fields.Many2one('indikamodule.maintable', ondelete='set null', string='Main Table')
