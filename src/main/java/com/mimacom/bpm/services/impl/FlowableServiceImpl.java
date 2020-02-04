package com.mimacom.bpm.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mimacom.bpm.services.FlowableService;


@Service
public class FlowableServiceImpl implements FlowableService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	

	
	@Override
    public String deployProcess(InputStream inputStream, String resourceName)  {
		return repositoryService.createDeployment().addInputStream(resourceName, inputStream).deploy().getId();
    }
	
	
	@Transactional
	@Override
	public void startProcess(String processKey) {
		runtimeService.startProcessInstanceByKey(processKey);
	}

	@Transactional
	@Override
	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

}
