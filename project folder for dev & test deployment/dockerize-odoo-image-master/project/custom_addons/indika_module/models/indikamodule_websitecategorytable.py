from odoo import models, fields, api
import re
from odoo.exceptions import ValidationError

class INDIKAModuleWebsitecategoryTable(models.Model):
    _name = 'indikamodule.websitecategorytable'
    category = fields.Selection([
        ('categoryone', 'Category 1'),
        ('categorytwo', 'Category 2'),
        ('categorythree', 'Category 3')
    ], 'Category', default='categoryone')
    strictly_necessary_cookies = fields.Integer('Strictly Necessary Cookies')
    performance_cookies = fields.Integer('Performance Cookies')
    functionality_cookies = fields.Integer('Functionality Cookies')
    targeting_cookies = fields.Integer('Targeting Cookies')
    unknown_cookies = fields.Integer('Unknown Cookies')
    persistent_cookies = fields.Integer('Persistent Cookies')
    session_cookies = fields.Integer('Session Cookies')