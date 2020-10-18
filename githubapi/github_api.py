from github import Github
# By using the GitHub REST API or the GitHub GraphQL API, build an application that
# allows a user to list the contributors of a given repository. No other requirement: show us your skills!


class GithubWrapper:
    def __init__(self):
        self.github = Github("PERSONAL ACCESS TOKEN HERE")

    def getRepositoryByName(self, repositoryName):
        repo = self.github.get_repo(repositoryName)
        return repo

    def listUserRepositories(self):
        for repo in self.github.get_user().get_repos():
            print(repo)

    def listRepositoryCollaborators(self, repositoryName):
        try:
            repo = self.getRepositoryByName(repositoryName)
            collaborators = repo.get_collaborators()
            collaborators_list = []
            for collaborator in collaborators:
                print(collaborator)
                collaborators_list.append(collaborator.name)
            return collaborators_list
        except Exception:
            print("Repo not found")

