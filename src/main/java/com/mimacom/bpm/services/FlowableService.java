package com.mimacom.bpm.services;

import java.io.InputStream;
import java.util.List;

import org.flowable.task.api.Task;

/**
 * Implementa las llamadas al API de FlowAble
 * @author AlfayaFJ
 *
 */
public interface FlowableService {
	
	
	
	/**
	 * Despliega un proceso en el engine de flowable
	 * @param inputStream Objeto de tipo {@link InputStream} con la definición del proceso 
	 * @param resourceName Nombre del recurso que contiene la definición
	 */
	 public String deployProcess(InputStream inputStream, String resourceName);
	
	/**
	 * Intancia un proceso en el engine de Flowable
	 * @param processKey String con la clave del proceso.
	 */
	public void startProcess(String processKey);
	
	
	public List<Task> getTasks(String assignee);
	
	
	
//	/**
//	 * Lista de las definiciones de proceso del repositorio
//	 * @return Lista de objetos de tipo {@link ProcessDefinition}
//	 */
//	public List<ProcessDefinition> getProcessDefinitions();
//	
//	/**
//	 * Despliega una definición de proceso en el repositorio
//	 * @param processInputStream 
//	 * @return
//	 * @throws IOException
//	 */
//	public ProcessDefinition deployProcess(InputStream inputStream, String resourceName, String processID) throws IOException;
//	
//	/**
//	 * 
//	 * @param processName
//	 */
//	public void deleteProcess(String processName);
//	
//
//	/**
//	 * 
//	 * @param processDefinitionKey
//	 * @return
//	 */
//	public ProcessInstance createProcessInstance(String processDefinitionKey, Inversion anInverion);
//	
//	/**
//	 * Retorna la lista de las instancias de procesos del sistema
//	 * @return
//	 */
//	public List<ProcessInstance> getProcessInstances();
//	
//	/**
//	 * 
//	 * @param processInstanceId
//	 * @return
//	 */
//
//	public ProcessInstanceMeta getProcessInstanceMetaById(String processInstanceId);
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public List<Task> getMyTasks(String userName);
//
//	/**
//	 * 
//	 * @param idTask
//	 * @return
//	 */
//	public Task getTaskById(String idTask);
//	
//	/**
//	 * 
//	 * @param idTAsk
//	 * @return
//	 */
//	public InversionTask getInversionTask(String idTask, String userName);
//	
//	/**
//	 * 
//	 * @param anInversionTak
//	 * @return
//	 */
//	public InversionTask endInversionTask(InversionTask anInversionTak);
	
	
}
