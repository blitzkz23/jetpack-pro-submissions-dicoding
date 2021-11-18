package com.app.themoviedatabase.data.source.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015J\u0014\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0015J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/app/themoviedatabase/data/source/local/LocalDataSource;", "", "mMovieDbDao", "Lcom/app/themoviedatabase/data/source/local/room/MovieDbDao;", "(Lcom/app/themoviedatabase/data/source/local/room/MovieDbDao;)V", "getFavouritedMovies", "Landroidx/paging/DataSource$Factory;", "", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "getFavouritedTvShows", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "getMovieById", "Landroidx/lifecycle/LiveData;", "movieId", "getMovies", "getTvShowById", "tvShowId", "getTvShows", "insertMovies", "", "movies", "", "insertTvShows", "tvShows", "setFavoriteMovie", "movie", "newState", "", "setFavoriteTvShow", "tvShow", "Companion", "app_debug"})
public final class LocalDataSource {
    private final com.app.themoviedatabase.data.source.local.room.MovieDbDao mMovieDbDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.app.themoviedatabase.data.source.local.LocalDataSource.Companion Companion = null;
    private static com.app.themoviedatabase.data.source.local.LocalDataSource INSTANCE;
    
    private LocalDataSource(com.app.themoviedatabase.data.source.local.room.MovieDbDao mMovieDbDao) {
        super();
    }
    
    /**
     * Movie
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.MovieEntity> getFavouritedMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovieById(int movieId) {
        return null;
    }
    
    public final void insertMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.app.themoviedatabase.data.source.local.entity.MovieEntity> movies) {
    }
    
    public final void setFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.MovieEntity movie, boolean newState) {
    }
    
    /**
     * TvShows
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.paging.DataSource.Factory<java.lang.Integer, com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getFavouritedTvShows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> getTvShowById(int tvShowId) {
        return null;
    }
    
    public final void insertTvShows(@org.jetbrains.annotations.NotNull()
    java.util.List<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> tvShows) {
    }
    
    public final void setFavoriteTvShow(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShow, boolean newState) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/app/themoviedatabase/data/source/local/LocalDataSource$Companion;", "", "()V", "INSTANCE", "Lcom/app/themoviedatabase/data/source/local/LocalDataSource;", "getInstance", "movieDbDao", "Lcom/app/themoviedatabase/data/source/local/room/MovieDbDao;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.themoviedatabase.data.source.local.LocalDataSource getInstance(@org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.data.source.local.room.MovieDbDao movieDbDao) {
            return null;
        }
    }
}