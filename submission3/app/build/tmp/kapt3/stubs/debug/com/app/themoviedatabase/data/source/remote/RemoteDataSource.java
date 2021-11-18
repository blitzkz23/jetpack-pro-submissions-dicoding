package com.app.themoviedatabase.data.source.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004J\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004\u00a8\u0006\n"}, d2 = {"Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource;", "", "()V", "getPopularMovie", "Landroidx/lifecycle/LiveData;", "Lcom/app/themoviedatabase/data/source/remote/ApiResponse;", "", "Lcom/app/themoviedatabase/data/source/remote/response/ResultsItem;", "getPopularTvShow", "Companion", "app_debug"})
public final class RemoteDataSource {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.themoviedatabase.data.source.remote.RemoteDataSource.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.app.themoviedatabase.data.source.remote.RemoteDataSource instance;
    
    public RemoteDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.remote.ApiResponse<java.util.List<com.app.themoviedatabase.data.source.remote.response.ResultsItem>>> getPopularMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.remote.ApiResponse<java.util.List<com.app.themoviedatabase.data.source.remote.response.ResultsItem>>> getPopularTvShow() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource$Companion;", "", "()V", "instance", "Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.themoviedatabase.data.source.remote.RemoteDataSource getInstance() {
            return null;
        }
    }
}