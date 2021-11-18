package com.app.themoviedatabase.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00040\u0003H&J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0003H&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u000f\u001a\u00020\rH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0017"}, d2 = {"Lcom/app/themoviedatabase/data/MovieDbDataSource;", "", "getAllPopularMovies", "Landroidx/lifecycle/LiveData;", "Lcom/dicoding/academies/vo/Resource;", "Landroidx/paging/PagedList;", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "getAllPopularTvShows", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "getFavouritedMovies", "getFavouritedTvShows", "getMovieById", "movieId", "", "getTvShowById", "tvShowId", "setFavoriteMovie", "", "movie", "state", "", "setFavoriteTvSHow", "tvShow", "app_debug"})
public abstract interface MovieDbDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.MovieEntity>>> getAllPopularMovies();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.MovieEntity>> getFavouritedMovies();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovieById(int movieId);
    
    public abstract void setFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.MovieEntity movie, boolean state);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.TvShowEntity>>> getAllPopularTvShows();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.TvShowEntity>> getFavouritedTvShows();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShowById(int tvShowId);
    
    public abstract void setFavoriteTvSHow(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShow, boolean state);
}