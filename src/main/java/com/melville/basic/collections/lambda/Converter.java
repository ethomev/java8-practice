package com.melville.basic.collections.lambda;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

