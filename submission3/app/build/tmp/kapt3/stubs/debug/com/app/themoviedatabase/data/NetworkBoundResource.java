package com.app.themoviedatabase.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u000bH$J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH$J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u0001H$\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H$\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/app/themoviedatabase/data/NetworkBoundResource;", "ResultType", "RequestType", "", "mExecutors", "Lcom/app/themoviedatabase/utils/AppExecutors;", "(Lcom/app/themoviedatabase/utils/AppExecutors;)V", "result", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/dicoding/academies/vo/Resource;", "asLiveData", "Landroidx/lifecycle/LiveData;", "createCall", "Lcom/app/themoviedatabase/data/source/remote/ApiResponse;", "fetchFromNetwork", "", "dbSource", "loadFromDB", "onFetchFailed", "saveCallResult", "data", "(Ljava/lang/Object;)V", "shouldFetch", "", "(Ljava/lang/Object;)Z", "app_debug"})
public abstract class NetworkBoundResource<ResultType extends java.lang.Object, RequestType extends java.lang.Object> {
    private final com.app.themoviedatabase.utils.AppExecutors mExecutors = null;
    private final androidx.lifecycle.MediatorLiveData<com.dicoding.academies.vo.Resource<ResultType>> result = null;
    
    public NetworkBoundResource(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.utils.AppExecutors mExecutors) {
        super();
    }
    
    protected void onFetchFailed() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.lifecycle.LiveData<ResultType> loadFromDB();
    
    protected abstract boolean shouldFetch(@org.jetbrains.annotations.Nullable()
    ResultType data);
    
    @org.jetbrains.annotations.NotNull()
    protected abstract androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.remote.ApiResponse<RequestType>> createCall();
    
    protected abstract void saveCallResult(RequestType data);
    
    private final void fetchFromNetwork(androidx.lifecycle.LiveData<ResultType> dbSource) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<ResultType>> asLiveData() {
        return null;
    }
}