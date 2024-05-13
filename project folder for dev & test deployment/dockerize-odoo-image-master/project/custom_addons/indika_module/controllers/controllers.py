    # -*- coding: utf-8 -*-
from odoo import http

class PPDMWebsite(http.Controller):
    @http.route('/indika/website', auth='public', website=True)
    def index(self, search='', **kw):
        websites = http.request.env['indikamodule.websitestable'].search([('name', 'ilike', search)], limit=1)
        total_websites = len(websites)

        if websites:
            # If a website is found, load its category data
            category = websites.category  # Assuming 'category' is a field in 'indikamodule.websitestable'
            category_data = http.request.env['indikamodule.websitecategorytable'].search([('category', '=', category)])

            return http.request.render('indika_module.website', {
                'websites': websites,
                'category_data': category_data,
                'total_websites': total_websites
            })
        else:
            return http.request.render('indika_module.website', {
                'websites': False,
                'total_websites': total_websites
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


