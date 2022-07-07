package com.andersonjunior.todolistspring.controllers;

import com.andersonjunior.todolistspring.models.Task;
import com.andersonjunior.todolistspring.services.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

	TaskService taskService;

	@ApiOperation(value = "Criando uma nova tarefa")
	@ApiResponses(value ={
		@ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
			@ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informações")
	})

	@PostMapping("/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public Task save(@RequestBody Task task){
		log.info("Criando uma nova tarefa com as informações [{}]", task);
		return taskService.save(task);
	}



	@ApiOperation(value = "Listando todas as tarefa")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
			@ApiResponse(code = 500, message = "Houve um erro ao lsitar as tarefas")
	})

	@GetMapping("/tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> findAll(){
		log.info("Listando todas as tarefa cadastradas");
		return taskService.findAll();
	}



	@ApiOperation(value = "Buscando tarefa pelo id")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
			@ApiResponse(code = 404, message = "Não foi encontrada nenhuma tarefa com esse id")
	})

	@GetMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> findById(@PathVariable(value = "id") Long id){
		log.info("Buscando tarefa pelo id [{}]", id);
		return taskService.findById(id);
	}



	@ApiOperation(value = "Atualizando tarefa")
	@ApiResponses(value ={
			@ApiResponse(code = 200, message = "Tarefas atualizada com sucesso"),
			@ApiResponse(code = 404, message = "Não foi possivel atualizar a tarefa")
	})

	@PutMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> UpdateById(@PathVariable(value = "id")Long id, @RequestBody Task task){
		log.info("Atualizando a tarefa com o id [{}] as  novas informações são: [{}]",id, task);
		return taskService.updateById(task,id);
	}



	@ApiOperation(value = "Excluindo tarefa")
	@ApiResponses(value ={
			@ApiResponse(code = 204, message = "Tarefas excluida com sucesso"),
			@ApiResponse(code = 404, message = "NNão foi possivel excluir a tarefa")
	})

	@DeleteMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id")Long id){
		log.info("Excluindo tarefa pelo id [{}]", id);
		return taskService.deleteById(id);
	}
}