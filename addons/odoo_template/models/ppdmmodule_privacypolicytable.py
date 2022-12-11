from odoo import models, fields



class PPDMModulePrivacyPolicyTable(models.Model):
	_name = 'ppdmmodule_privacypolicytable'
	name = fields.Char('PrivacyPolicyData', required=True)

