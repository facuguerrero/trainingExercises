from flask_restful import Resource
from flask import request

from githubapi.github_api import GithubWrapper
from githubapi.response_builder import ResponseBuilder


class GithubResource(Resource):
    @staticmethod
    def get():
        repo_name = request.args.get('repoName')
        if repo_name and repo_name != "":
            git = GithubWrapper()
            collaborators = git.listRepositoryCollaborators(repo_name)
            if collaborators: return ResponseBuilder.build(collaborators, 200)
            else: return ResponseBuilder.build_exception("Repo Not Found", 404)
        return ResponseBuilder.build_exception("Bad Request. repoName queryparam must be sent.", 400)
