package com.ratatouille.Ratatouille23.user;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        Role role
) {}
