package com.sdzking.goodkotlin

import java.lang.Exception

sealed class ResultS
class SuccessS(val msg: String) : ResultS()
class FailureS(val error: Exception) : ResultS()