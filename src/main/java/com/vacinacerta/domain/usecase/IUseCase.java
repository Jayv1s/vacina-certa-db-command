package com.vacinacerta.domain.usecase;

public interface IUseCase <Input, Output> {
    Output execute(Input input);
}
