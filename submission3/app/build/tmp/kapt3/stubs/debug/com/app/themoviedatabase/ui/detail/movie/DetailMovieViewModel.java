package com.app.themoviedatabase.ui.detail.movie;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/app/themoviedatabase/ui/detail/movie/DetailMovieViewModel;", "Landroidx/lifecycle/ViewModel;", "movieDbRepository", "Lcom/app/themoviedatabase/data/MovieDbRepository;", "(Lcom/app/themoviedatabase/data/MovieDbRepository;)V", "movieDetail", "Landroidx/lifecycle/LiveData;", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "getMovieDetail", "()Landroidx/lifecycle/LiveData;", "setMovieDetail", "(Landroidx/lifecycle/LiveData;)V", "movieId", "Landroidx/lifecycle/MutableLiveData;", "", "setFavorited", "", "setSelectedMovie", "app_debug"})
public final class DetailMovieViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.themoviedatabase.data.MovieDbRepository movieDbRepository = null;
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> movieId;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> movieDetail;
    
    public DetailMovieViewModel(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.MovieDbRepository movieDbRepository) {
        super();
    }
    
    public final void setSelectedMovie(int movieId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> getMovieDetail() {
        return null;
    }
    
    public final void setMovieDetail(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<com.app.themoviedatabase.data.source.local.entity.MovieEntity> p0) {
    }
    
    public final void setFavorited() {
    }
}