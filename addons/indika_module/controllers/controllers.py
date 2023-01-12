    # -*- coding: utf-8 -*-
from odoo import http

class PPDMWebsite(http.Controller):

    @http.route('/indika/website/', auth='public', website=True)
    def index(self, **kw):

        webistes = http.request.env['indikamodule.websitestable'].search([])
        cookiedata = http.request.env['indikamodule.cookiedatatable'].search([])
       # search webistes = http.request.env['indikamodule.websitestable'].search([])
        return http.request.render('indika_module.website', {
               'webistes' : webistes,
               'cookiedata' : cookiedata,
           })

