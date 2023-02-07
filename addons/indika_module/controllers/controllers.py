    # -*- coding: utf-8 -*-
from odoo import http

class PPDMWebsite(http.Controller):

    @http.route('/indika/website', auth='public', website=True)
    def index(self, search='', **kw):
        domain = []
        domain = [('name', 'like', search)]
        # webiste = http.request.env['indikamodule.websitestable'].search(domain)

        vendor_id = self.env['indikamodule.vendortable'].search([('name', '=', search)])
        website = self.env['indikamodule.websitestable'].search([('vendor_id', '=', vendor_id.id)])

        # cache_category = http.request.env['indikamodule.cookiecategorytable'].search(
        #     [('cookie_category_description', 'in', webiste.mapped('CookieCategoryName'))])
        # exit()
        # if search:
        #     domain = [('name', 'ilike', search)]
        # webistes = http.request.env['indikamodule.websitestable'].search(domain)
        # cookiedata = http.request.env['indikamodule.cookiedatatable'].search([])
        # # search webistes = http.request.env['indikamodule.websitestable'].search([])
        return http.request.render('indika_module.website', {
            'webistes': website,
            # 'cookiedata': cookiedata,
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
                cache_category= http.request.env['indikamodule.cookiecategorytable'].search([('cookie_category_description', 'in', webiste.mapped('name').name)])
                print(cache_category)
                exit()
         # search webistes = http.request.env['indikamodule.websitestable'].search([])
                return http.request.render('indika_module.website_details', {
              'webistes': cache_category,
                        })


