# -*- coding: utf-8 -*-
from odoo import http

class PPDMWebsite(http.Controller):
    @http.route('/indika/website', auth='public', website=True)
    def index(self, **kw):
        webistes = http.request.env['indikamodule.websitestable'].search([])
        cookiedata = http.request.env['indikamodule.cookiedatatable'].search([])
        # search webistes = http.request.env['indikamodule.websitestable'].search([])
        return http.request.render('indika_module.website', {
            'webistes': webistes,
            'cookiedata': cookiedata,
        })

    @http.route('/indika/website_details/<model("indikamodule.websitestable"):website>/', auth='public', website=True)
    def website_details(self, website):
        webistes = http.request.env['indikamodule.websitestable'].search([])
        # search webistes = http.request.env['indikamodule.websitestable'].search([])
        return http.request.render('indika_module.website_details', {
            'webistes': website,
        })


    @http.route('/website/search', auth='public', website=True)
    def website_search(self, search=''):
        domain = []
        if search:
            domain = [('name', 'like', search)]
        webiste = http.request.env['indikamodule.websitestable'].search(domain)
        # search webistes = http.request.env['indikamodule.websitestable'].search([])
        return http.request.render('indika_module.website_details', {
            'webistes': webiste,
        })
