package com.app.themoviedatabase.ui.movie;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/app/themoviedatabase/ui/movie/MovieViewModel;", "Landroidx/lifecycle/ViewModel;", "movieDbRepository", "Lcom/app/themoviedatabase/data/MovieDbRepository;", "(Lcom/app/themoviedatabase/data/MovieDbRepository;)V", "getMovies", "Landroidx/lifecycle/LiveData;", "Lcom/dicoding/academies/vo/Resource;", "Landroidx/paging/PagedList;", "Lcom/app/themoviedatabase/data/source/local/entity/MovieEntity;", "app_debug"})
public final class MovieViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.themoviedatabase.data.MovieDbRepository movieDbRepository = null;
    
    public MovieViewModel(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.MovieDbRepository movieDbRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.dicoding.academies.vo.Resource<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.MovieEntity>>> getMovies() {
        return null;
    }
}