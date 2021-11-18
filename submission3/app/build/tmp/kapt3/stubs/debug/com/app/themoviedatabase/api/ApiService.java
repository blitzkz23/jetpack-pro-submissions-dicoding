package com.app.themoviedatabase.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/app/themoviedatabase/api/ApiService;", "", "getPopular", "Lretrofit2/Call;", "Lcom/app/themoviedatabase/data/source/remote/response/PopularMovieResponse;", "urlType", "", "apiKey", "page", "", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "{urlType}/popular")
    public abstract retrofit2.Call<com.app.themoviedatabase.data.source.remote.response.PopularMovieResponse> getPopular(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "urlType")
    java.lang.String urlType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String apiKey, @retrofit2.http.Query(value = "page")
    int page);
}