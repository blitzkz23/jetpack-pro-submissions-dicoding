package com.app.themoviedatabase.ui.tvshow;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/app/themoviedatabase/ui/tvshow/TvShowAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "Lcom/app/themoviedatabase/ui/tvshow/TvShowAdapter$TvShowViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "TvShowViewHolder", "app_debug"})
public final class TvShowAdapter extends androidx.paging.PagedListAdapter<com.app.themoviedatabase.data.source.local.entity.TvShowEntity, com.app.themoviedatabase.ui.tvshow.TvShowAdapter.TvShowViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.themoviedatabase.ui.tvshow.TvShowAdapter.Companion Companion = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.app.themoviedatabase.data.source.local.entity.TvShowEntity> DIFF_CALLBACK = null;
    
    public TvShowAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.app.themoviedatabase.ui.tvshow.TvShowAdapter.TvShowViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.app.themoviedatabase.ui.tvshow.TvShowAdapter.TvShowViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/app/themoviedatabase/ui/tvshow/TvShowAdapter$TvShowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/app/themoviedatabase/databinding/ItemsMovieBinding;", "(Lcom/app/themoviedatabase/databinding/ItemsMovieBinding;)V", "bind", "", "tvShow", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "app_debug"})
    public static final class TvShowViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.app.themoviedatabase.databinding.ItemsMovieBinding binding = null;
        
        public TvShowViewHolder(@org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.databinding.ItemsMovieBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShow) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/app/themoviedatabase/ui/tvshow/TvShowAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}