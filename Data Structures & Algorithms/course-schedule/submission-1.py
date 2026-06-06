class Solution:

    def canFinish(self, numCourses, prerequisites):

        prereq = {i: [] for i in range(numCourses)}

        for course, pre in prerequisites:
            prereq[course].append(pre)

        visitSet = set()

        def dfs(course):

            if course in visitSet:
                return False

            if prereq[course] == []:
                return True

            visitSet.add(course)

            for pre in prereq[course]:

                if not dfs(pre):
                    return False

            visitSet.remove(course)

            prereq[course] = []

            return True

        for course in range(numCourses):

            if not dfs(course):
                return False

        return True