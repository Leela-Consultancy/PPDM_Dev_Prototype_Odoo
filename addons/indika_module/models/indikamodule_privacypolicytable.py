from odoo import models, fields



class INDIKAModulePrivacypolicyTable(models.Model):
	_name = 'indikamodule.privacypolicytable'
	privacy_name = fields.Text('PrivacyPolicyData', required=True)

