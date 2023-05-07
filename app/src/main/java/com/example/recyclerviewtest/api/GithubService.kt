package com.example.recyclerviewtest.api

import com.example.recyclerviewtest.models.RepoResult
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    suspend fun retrieveRepositories(): RepoResult

    @GET("/search/repositories?q=language:kotlin&sort=stars&order=desc&per_page=50")
    //sample search
    suspend fun searchRepositories(): RepoResult
}