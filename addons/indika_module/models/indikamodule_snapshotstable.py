from odoo import models, fields, api


class INDIKAModuleSnapshotsTable(models.Model):
    _name = 'indikamodule.snapshotstable'
    _description = 'Snapshots Table'

    name = fields.Char('Snapshot Name')
    cookie_category = fields.Char('Cookie Category')
    cookie_category_description = fields.Text('Cookie Category Description')
    website_id = fields.Many2one('indikamodule.websitestable', string='Website')
    main_table_id = fields.Many2one('indikamodule.maintable', string='Main Table')
    cookie_data_id = fields.Many2one('indikamodule.cookiedatatable', string='Cookie Data')
    cookie_description = fields.Char('Cookie Description')
    cookie_type = fields.Selection([
        ('firstparty', 'First Party'),
        ('thirdparty', 'Third Party')
    ], 'Cookie Type', default='firstparty')
    vendor_id = fields.Many2one('indikamodule.vendortable', string='Vendor Site')
    mapping_table_id = fields.Many2one('indikamodule.mappingtable', string='Mapping Table')
    privacy_id = fields.Text('PrivacyID')
    privacy_policy_data = fields.Text('Privacy Policy Data')
    vendor_site_brief = fields.Char('Vendor Site Brief')
    vendor_url = fields.Char('Vendor Site Url')
