package com.lojagames.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lojagames.lojagames.model.Produtos;
import com.lojagames.lojagames.repository.CategoriasRepository;
import com.lojagames.lojagames.repository.ProdutosRepository;

	@RestController
	@RequestMapping("/produtos")
	@CrossOrigin("*")
public class ProdutosController {
		
		@Autowired
		private ProdutosRepository repository;
		
		private CategoriasRepository categoriaRepository;
		
		@GetMapping
		public ResponseEntity<List<Produtos>> GetAll() {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("{id}")
		public ResponseEntity <Produtos> getById (@PathVariable Long id) {
			return repository.findById(id).map (resposta -> ResponseEntity.ok (resposta))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
		}
		
		@PostMapping
		public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos descricao){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
		
		}
		
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			java.util.Optional<Produtos> produtos = repository.findById(id);
			
			if(produtos.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				
			repository.deleteById(id);
		}

	}


