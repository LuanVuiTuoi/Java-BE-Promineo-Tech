package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();

	/**
	 * This method simply calls the DAO class to insert a project row.
	 * 
	 * @param project The {@link Project} object.
	 * @return The Project object with the newly generated primary key value.
	 */
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}

	public Project fetchProjectbyId(int projectId) {
		return projectDao.fetchProjectbyId(projectId).orElseThrow(() -> new NoSuchElementException("Project with project ID =" + projectId + " does not exist."));
	}

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID=" + project.getProjectId() + " does not exist.");	
		}	
	}

	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID=" + projectId + " does not exist.");
		}
	}

}
