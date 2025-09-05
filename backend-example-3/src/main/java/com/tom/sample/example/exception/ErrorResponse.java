package com.tom.sample.example.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {}

