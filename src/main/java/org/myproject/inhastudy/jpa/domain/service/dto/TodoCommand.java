package org.myproject.inhastudy.jpa.domain.service.dto;

public record TodoCommand(
        String title,
        String description
) {}
