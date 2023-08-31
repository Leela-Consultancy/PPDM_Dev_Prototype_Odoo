from odoo import models, fields


class INDIKAModuleWebsitesTable(models.Model):
    _name = 'indikamodule.websitestable'
    name = fields.Char('Site Name', required=True)
    desc = fields.Char('Site Brief', required=True)
    url = fields.Char('Site Url', required=True)
    privacy = fields.Text('Privacy Policy', required=True)
    # add new fields for
    strictly_necessary_cookies = fields.Integer('Strictly Necessary Cookies')
    performance_cookies = fields.Integer('Performance Cookies')
    functionality_cookies = fields.Integer('Functionality Cookies')
    targeting_cookies = fields.Integer('Targeting Cookies')
    unknown_cookies = fields.Integer('Unknown Cookies')
    persistent_cookies = fields.Integer('Persistent Cookies')
    session_cookies = fields.Integer('Session Cookies')
