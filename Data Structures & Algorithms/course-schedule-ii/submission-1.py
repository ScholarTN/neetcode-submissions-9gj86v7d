class Solution:

    def findOrder(self, numCourses, prerequisites):

        graph = {i: [] for i in range(numCourses)}

        for course, pre in prerequisites:
            graph[course].append(pre)

        visit = {}
        order = []

        def dfs(course):

            if course in visit:
                return visit[course]

            visit[course] = True

            for pre in graph[course]:

                if dfs(pre):
                    return True

            visit[course] = False

            graph[course] = []

            order.append(course)

            return False

        for course in range(numCourses):

            if dfs(course):
                return []

        return order