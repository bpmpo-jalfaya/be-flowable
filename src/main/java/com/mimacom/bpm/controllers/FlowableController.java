package com.mimacom.bpm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mimacom.bpm.model.TaskPojo;
import com.mimacom.bpm.services.FlowableService;

@RestController
@RequestMapping("/flowable-api")
public class FlowableController {
	
	
	
	@Autowired
	private FlowableService flowableService;
	
	
	/**
	 * Despliega un proceso en el repositorio de Flowable
	 * @param file Fichero con la definición del proceso
	 * @return String con el identificador del proceso
	 * @throws IOException Excepción de tipo {@link IOException}
	 */
	@PostMapping(value = "/deploy-process")
	public ResponseEntity<String> deployProcess(@RequestParam("file") MultipartFile file) throws IOException {
		flowableService.deployProcess(file.getInputStream(), file.getName());
		return ResponseEntity.ok(flowableService.deployProcess(file.getInputStream(), file.getName()));
	}
	
	
	
	

	/**
	 * Obtiene las tareas asignadas
	 * @param assignee Nombre del usuario
	 * @return Lista de objetos de tipo {@link TaskPojo}
	 */
	@GetMapping(value = "/get-mytasks/{assignee}")
	public ResponseEntity<List<TaskPojo>> getTasks(@PathVariable("assignee") String assignee) {
		List<Task> tasks = flowableService.getTasks(assignee);
		List<TaskPojo> dtos = new ArrayList<TaskPojo>();
		for (Task task : tasks) {
			dtos.add(new TaskPojo(task.getId(), task.getName()));
		}
		return ResponseEntity.ok(dtos);
	}

}
