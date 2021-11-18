package com.app.themoviedatabase.ui.detail.tvshow;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/app/themoviedatabase/ui/detail/tvshow/DetailTvShowActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityDetailBinding", "Lcom/app/themoviedatabase/databinding/ActivityDetailBinding;", "detailContentBinding", "Lcom/app/themoviedatabase/databinding/ContentDetailBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "populateTvShow", "tvShowEntity", "Lcom/app/themoviedatabase/data/source/local/entity/TvShowEntity;", "setFavoritedState", "state", "", "loadImage", "Landroid/widget/ImageView;", "url", "", "Companion", "app_debug"})
public final class DetailTvShowActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.app.themoviedatabase.databinding.ActivityDetailBinding activityDetailBinding;
    private com.app.themoviedatabase.databinding.ContentDetailBinding detailContentBinding;
    @org.jetbrains.annotations.NotNull()
    public static final com.app.themoviedatabase.ui.detail.tvshow.DetailTvShowActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TVSHOW = "extra_tvshow";
    
    public DetailTvShowActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setFavoritedState(boolean state) {
    }
    
    private final void populateTvShow(com.app.themoviedatabase.data.source.local.entity.TvShowEntity tvShowEntity) {
    }
    
    private final void loadImage(android.widget.ImageView $this$loadImage, java.lang.String url) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/app/themoviedatabase/ui/detail/tvshow/DetailTvShowActivity$Companion;", "", "()V", "EXTRA_TVSHOW", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}