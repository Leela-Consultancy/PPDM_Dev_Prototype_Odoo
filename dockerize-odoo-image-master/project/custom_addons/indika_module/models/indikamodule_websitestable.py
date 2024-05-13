from odoo import models, fields, api
import re
from odoo.exceptions import ValidationError

class INDIKAModuleWebsitesTable(models.Model):
    _name = 'indikamodule.websitestable'
    name = fields.Char('Site Name', required=True)
    category = fields.Selection([
        ('categoryone', 'Category 1'),
        ('categorytwo', 'Category 2'),
        ('categorythree', 'Category 3')
    ], 'Category', default='categoryone')
    desc = fields.Char('Site Brief', required=True)
    url = fields.Char('Site Url', required=True)
    privacy = fields.Text('Privacy Policy', required=True)
    strictly_necessary_cookies = fields.Integer('Strictly Necessary Cookies')
    performance_cookies = fields.Integer('Performance Cookies')
    functionality_cookies = fields.Integer('Functionality Cookies')
    targeting_cookies = fields.Integer('Targeting Cookies')
    unknown_cookies = fields.Integer('Unknown Cookies')
    persistent_cookies = fields.Integer('Persistent Cookies')
    session_cookies = fields.Integer('Session Cookies')

    @api.onchange('url')
    def _onchange_url(self):
        if self.url:
            # Define your URL validation logic here, for example:
            url_pattern = re.compile(r'^(https?://)?(?:www\.)?([a-zA-Z0-9.-]+\.[a-zA-Z]{2,4})(?:/.*)?$')
            if not url_pattern.match(self.url):
                return {
                    'warning': {
                        'title': "Invalid URL",
                        'message': "Please enter a valid URL.",
                    }
                }
