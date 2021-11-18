package com.app.themoviedatabase.ui.favorites.favoritetvshow;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/app/themoviedatabase/ui/favorites/favoritetvshow/FavoriteTvShowViewModel;", "Landroidx/lifecycle/ViewModel;", "movieDbRepository", "Lcom/app/themoviedatabase/data/MovieDbRepository;", "(Lcom/app/themoviedatabase/data/MovieDbRepository;)V", "getFavouritedTvShows", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "app_debug"})
public final class FavoriteTvShowViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.themoviedatabase.data.MovieDbRepository movieDbRepository = null;
    
    public FavoriteTvShowViewModel(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.data.MovieDbRepository movieDbRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagedList<com.app.themoviedatabase.data.source.local.entity.TvShowEntity>> getFavouritedTvShows() {
        return null;
    }
}