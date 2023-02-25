from odoo import models, fields



class INDIKAModulePrivacypolicyTable(models.Model):
	_name = 'indikamodule.privacypolicytable'
	privacy_id = fields.Text('PrivacyID', required=True)
	name = fields.Text('PrivacyPolicyData', required=True)

