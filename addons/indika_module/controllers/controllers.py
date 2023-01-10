# -*- coding: utf-8 -*-
from odoo import http

class INDIKAModule(http.Controller):

    @http.route('/indika/', auth='public')
    def index(self, **kw):
        return "Hello, world"