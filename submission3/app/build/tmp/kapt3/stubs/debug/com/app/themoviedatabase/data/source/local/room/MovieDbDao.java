package com.app.themoviedatabase.data.source.local.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u0004H\'J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\r\u001a\u00020\u0004H\'J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\'J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\'J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\'J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007H\'\u00a8\u0006\u0017"}, d2 = {"Lcom/app/themoviedatabase/data/source/local/room/MovieDbDao;", "", "getFavouritedMovie", "Landroidx/paging/DataSource$Factory;", "", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "getFavouritedTvShows", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "getMovieById", "Landroidx/lifecycle/LiveData;", "movieId", "getMovies", "getTvShowById", "tvShowId", "getTvShows", "insertMovies", "", "movies", "", "insertTvShow", "tvShows", "updateMovies", "updateTvShows", "app_debug"})
public abstract interface MovieDbDao {
    
    /**
     * Query for movie
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movieentities")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovies();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movieentities WHERE favourited = 1")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.MovieEntity> getFavouritedMovie();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movieentities WHERE movieId = :movieId")
    public abstract androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovieById(int movieId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.app.themoviedatabase.data.source.local.entity.MovieEntity> movies);
    
    @androidx.room.Update()
    public abstract void updateMovies(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.MovieEntity movies);
    
    /**
     * Query for tv show
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tvshowentities")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShows();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tvshowentities WHERE favourited = 1")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getFavouritedTvShows();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    public abstract androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShowById(int tvShowId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertTvShow(@org.jetbrains.annotations.NotNull()
    java.util.List<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> tvShows);
    
    @androidx.room.Update()
    public abstract void updateTvShows(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShows);
}