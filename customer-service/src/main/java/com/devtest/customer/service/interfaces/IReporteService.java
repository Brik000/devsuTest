package com.devtest.customer.service.interfaces;

import com.devtest.customer.service.dto.ReporteRequestDTO;
import com.devtest.customer.service.dto.ReporteResponseDTO;

public interface IReporteService {
    public ReporteResponseDTO enviarYEsperarRespuesta(ReporteRequestDTO request);
}
