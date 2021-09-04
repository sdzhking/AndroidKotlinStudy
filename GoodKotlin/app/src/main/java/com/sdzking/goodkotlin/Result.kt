package com.sdzking.goodkotlin

import java.lang.Exception

interface Result
class Success(val msg: String) : Result
class Failure(val error: Exception) : Result