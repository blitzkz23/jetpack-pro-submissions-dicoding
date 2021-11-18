package com.app.themoviedatabase.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b0\nH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\nH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/app/themoviedatabase/data/MovieDbRepository;", "Lcom/app/themoviedatabase/data/MovieDbDataSource;", "remoteDataSource", "Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource;", "localDataSource", "Lcom/app/themoviedatabase/data/source/local/LocalDataSource;", "appExecutors", "Lcom/app/themoviedatabase/utils/AppExecutors;", "(Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource;Lcom/app/themoviedatabase/data/source/local/LocalDataSource;Lcom/app/themoviedatabase/utils/AppExecutors;)V", "getAllPopularMovies", "Landroidx/lifecycle/LiveData;", "Lcom/dicoding/academies/vo/Resource;", "Landroidx/paging/PagedList;", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "getAllPopularTvShows", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "getFavouritedMovies", "getFavouritedTvShows", "getMovieById", "movieId", "", "getTvShowById", "tvShowId", "setFavoriteMovie", "", "movie", "state", "", "setFavoriteTvSHow", "tvShow", "Companion", "app_debug"})
public final class MovieDbRepository implements com.app.themoviedatabase.data.MovieDbDataSource {
    private final com.app.themoviedatabase.data.source.remote.RemoteDataSource remoteDataSource = null;
    private final com.app.themoviedatabase.data.source.local.LocalDataSource localDataSource = null;
    private final com.app.themoviedatabase.utils.AppExecutors appExecutors = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.app.themoviedatabase.data.MovieDbRepository.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.app.themoviedatabase.data.MovieDbRepository instance;
    
    private MovieDbRepository(com.app.themoviedatabase.data.source.remote.RemoteDataSource remoteDataSource, com.app.themoviedatabase.data.source.local.LocalDataSource localDataSource, com.app.themoviedatabase.utils.AppExecutors appExecutors) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.MovieEntity>>> getAllPopularMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.MovieEntity>> getFavouritedMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovieById(int movieId) {
        return null;
    }
    
    @java.lang.Override()
    public void setFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.MovieEntity movie, boolean state) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.TvShowEntity>>> getAllPopularTvShows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.TvShowEntity>> getFavouritedTvShows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShowById(int tvShowId) {
        return null;
    }
    
    @java.lang.Override()
    public void setFavoriteTvSHow(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShow, boolean state) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/app/themoviedatabase/data/MovieDbRepository$Companion;", "", "()V", "instance", "Lcom/app/themoviedatabase/data/MovieDbRepository;", "getInstance", "remoteData", "Lcom/app/themoviedatabase/data/source/remote/RemoteDataSource;", "locaData", "Lcom/app/themoviedatabase/data/source/local/LocalDataSource;", "appExecutors", "Lcom/app/themoviedatabase/utils/AppExecutors;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.themoviedatabase.data.MovieDbRepository getInstance(@org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.data.source.remote.RemoteDataSource remoteData, @org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.data.source.local.LocalDataSource locaData, @org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.utils.AppExecutors appExecutors) {
            return null;
        }
    }
}