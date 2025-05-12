package com.devtest.account.service.interfaces;

import com.devtest.account.service.dto.ReporteRequestDTO;
import com.devtest.account.service.dto.ReporteResponseDTO;

public interface IReporteService {
    public ReporteResponseDTO generarReporte(ReporteRequestDTO request);
}
