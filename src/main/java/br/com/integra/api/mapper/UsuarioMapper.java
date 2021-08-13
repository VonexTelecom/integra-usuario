package br.com.integra.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.integra.api.dto.input.UsuarioInputDto;
import br.com.integra.api.dto.output.UsuarioOutputDto;
import br.com.integra.api.model.Usuario;

@Component
public class UsuarioMapper {
	@Autowired
	private ModelMapper mapper;
	
	public UsuarioOutputDto modelToOutputDto(Usuario model) {
		return mapper.map(model, UsuarioOutputDto.class);
	}
	
	public Usuario inputDtoToModel(UsuarioInputDto request) {
		return mapper.map(request, Usuario.class);
	}
}
