package com.umlanche.infra.adapters.repositories.mappers;

import com.umlanche.domain.dtos.ImagemDto;
import com.umlanche.domain.entities.Imagem;
import com.umlanche.infra.adapters.entities.ImagemEntity;

public class ImagemMapper {
  public static final ImagemEntity toDatabase(Imagem imagem) {
    return new ImagemEntity(imagem.getIdImagem(), imagem.getDsUrl(), imagem.getDsResumo(), imagem.getNrImagem(), imagem.getEhPrincipal());
  }  

  public static final Imagem toDomain(ImagemEntity raw) {
    return new Imagem(raw.getIdImagem(), raw.getDsUrl(), raw.getDsResumo(), raw.getNrImagem(), raw.getEhPrincipal());
  }

  public static final Imagem toDomain(ImagemDto dto) {
    return new Imagem(dto.idImagem, dto.dsUrl, dto.dsResumo, dto.nrImagem, dto.ehPrincipal);
  }
}
