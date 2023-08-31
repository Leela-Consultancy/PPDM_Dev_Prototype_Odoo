    # -*- coding: utf-8 -*-
from odoo import http

class PPDMWebsite(http.Controller):

    @http.route('/indika/website', auth='public', website=True)
    def index(self, search='', **kw):
        domain = []
        domain = [('name', 'like', search)]
        websites = http.request.env['indikamodule.websitestable'].search(domain, limit=1)
        total_websites = len(websites)

        return http.request.render('indika_module.website', {
            'websites': websites,
            'total_websites':total_websites

        })

    @http.route('/indika/website_details/<model("indikamodule.websitestable"):website>/', auth='public', website=True)
    def website_details(self, website):
        webiste = http.request.env['indikamodule.websitestable'].search([])
        # vendor_id = http.request.env['indikamodule.vendortable'].search([('id', '=', webistes.vendor_id)])
        # webistes = http.request.env['indikamodule.websitestable'].search([])

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
                cache_category= http.request.env['indikamodule.cookiecategorytable'].search([('cookie_category_description', 'in', webiste.mapped('name').name)])
                print(cache_category)
                exit()
         # search webistes = http.request.env['indikamodule.websitestable'].search([])
                return http.request.render('indika_module.website_details', {
              'webistes': cache_category,
                        })


