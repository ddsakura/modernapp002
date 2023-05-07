package com.example.recyclerviewtest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewtest.api.RepositoryRetriever
import com.example.recyclerviewtest.models.Employee
import com.example.recyclerviewtest.models.RepoResult
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _employeeList = MutableLiveData<ArrayList<Employee>>().apply {
        val employeeList = ArrayList<Employee>()
        // add some dummy data
        employeeList.add(Employee("John ABC", "test@abc.com"))
        employeeList.add(Employee("John DEF", "john@abc.com"))
        employeeList.add(Employee("Chinmaya Mohapatra", "chinmaya@abc.com"))
        employeeList.add(Employee("Ram prakash", "ramp@abc.com"))
        employeeList.add(Employee("OMM Meheta", "mehetaom@abc.com"))
        employeeList.add(Employee("Hari Mohapatra", "harim@abc.com"))
        employeeList.add(Employee("Abhisek Mishra", "mishraabhi@abc.com"))
        employeeList.add(Employee("Sindhu Malhotra", "sindhu@abc.com"))
        employeeList.add(Employee("Anil sidhu", "sidhuanil@abc.com"))
        employeeList.add(Employee("Sachin sinha", "sinhas@abc.com"))
        employeeList.add(Employee("Amit sahoo", "sahooamit@abc.com"))
        employeeList.add(Employee("Raj kumar", "kumarraj@abc.com"))
        value = employeeList
    }
    val employeeList: LiveData<ArrayList<Employee>> = _employeeList

    private val _githubRepoList = MutableLiveData<RepoResult>().apply {
        val job = Job()
        val errorHandler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val ioScope = CoroutineScope(job + Dispatchers.Main)
        ioScope.launch(errorHandler) {
            // val result = GitRequest().run()
            val result = RepositoryRetriever().getRepositories()
            println(result)
            value = result
        }
    }

    val githubRepoList: LiveData<RepoResult> = _githubRepoList

}