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

    @http.route('/indika/paginate', auth='public', type='json', website=True)
    def paginate(self, search='', page=1, page_size=10, **kw):
        offset = (page - 1) * page_size
        # Website = http.request.env['indikamodule.websitestable']
        #
        # websites = Website.search(
        #     [('name', 'ilike', search)], limit=page_size, offset=offset
        # )
        # total_websites = Website.search_count(
        #     [('name', 'ilike', search)]
        # )
        #
        # if websites:
        #     return {
        #         'draw': kw.get('draw', 1),
        #         'recordsTotal': total_websites,
        #         'recordsFiltered': total_websites,
        #         'data': websites.read(['id', 'name', 'url'])
        #     }
        # else:
        #     return {
        #         'draw': kw.get('draw', 1),
        #         'recordsTotal': 0,
        #         'recordsFiltered': 0,
        #         'data': []
        #     }

    @http.route('/indika/paginate', type='json', auth='public', methods=['POST'], website=True)
    def paginate(self, **kw):
        search_value = kw.get('search[value]', '')
        start = int(kw.get('start', 0))
        length = int(kw.get('length', 10))

        Website = http.request.env['indikamodule.websitestable']

        domain = [('name', 'ilike', f'%{search_value}%')]
        total_websites = Website.search_count(domain)
        websites = Website.search(domain, limit=length, offset=start)

        data = websites.read(['name', 'url'])

        return {
            'draw': int(kw.get('draw', 1)),
            'recordsTotal': total_websites,
            'recordsFiltered': total_websites,
            'data': data
        }

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


