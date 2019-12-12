package com.example.stringcalculator

abstract class BaseCallback<T> {
    private var methodList: MutableList<T> = mutableListOf()

    fun addMethod(viewMethod: T) {
        methodList.add(viewMethod)
    }

    fun methodWasCalled(viewMethod: T): Boolean {
        return methodList.contains(viewMethod)
    }
}
