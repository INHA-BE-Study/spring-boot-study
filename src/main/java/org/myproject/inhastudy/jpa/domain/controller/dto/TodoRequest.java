package org.myproject.inhastudy.jpa.domain.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoRequest(
        @NotBlank String title,
        String description
) {}
