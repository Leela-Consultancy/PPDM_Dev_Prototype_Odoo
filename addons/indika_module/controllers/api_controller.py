from odoo import http
from odoo.http import request, Response

class ApiController(http.Controller):
    # API endpoint to fetch all websites
    @http.route('/api/websites', auth='public', methods=['GET'])
    def get_websites(self, **kwargs):
        Website = request.env['indikamodule.websitestable']
        websites = Website.search([])
        data = {
            'websites': [{
                'name': website.name,
                'desc': website.desc,
                'url': website.url
            } for website in websites]
        }
        return Response(json.dumps(data), content_type='application/json')

    # API endpoint to create a new website
    @http.route('/api/websites', auth='public', methods=['POST'])
    def create_website(self, **kwargs):
        Website = request.env['indikamodule.websitestable']
        data = request.jsonrequest
        website = Website.create({
            'name': data.get('name'),
            'desc': data.get('desc'),
            'url': data.get('url')
        })
        return Response(json.dumps({'id': website.id}), content_type='application/json')
