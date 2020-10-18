from flask import Flask
from flask_restful import Api

from githubapi.github_resource import GithubResource

app = Flask(__name__)
api = Api(app)

# These are utility endpoints
api.add_resource(GithubResource, '/collaborators/list')

if __name__ == '__main__':
    app.run(port=8000, threaded=True)
