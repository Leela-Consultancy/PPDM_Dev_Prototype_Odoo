# -*- coding: utf-8 -*-
from odoo import http


class PPDMWebsite(http.Controller):

    @http.route('/indika/website/', auth='public')
    def index(self, **kw):
        return http.request.render('indika_module.website', {
            'teachers': ["Diana Padilla", "Hariharan", "Lester Vaughn"],
        })

#     @http.route('/academy/academy/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('academy.listing', {
#             'root': '/academy/academy',
#             'objects': http.request.env['academy.academy'].search([]),
#         })

#     @http.route('/academy/academy/objects/<model("academy.academy"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('academy.object', {
#             'object': obj
#         })
