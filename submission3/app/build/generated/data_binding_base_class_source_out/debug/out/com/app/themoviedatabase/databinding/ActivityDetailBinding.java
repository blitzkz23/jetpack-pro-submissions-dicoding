// Generated by view binder compiler. Do not edit!
package com.app.themoviedatabase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.themoviedatabase.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final NestedScrollView content;

  @NonNull
  public final ContentDetailBinding detailContent;

  @NonNull
  public final FloatingActionButton fabFavourite;

  @NonNull
  public final ImageView imgPoster;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final Toolbar toolbar;

  private ActivityDetailBinding(@NonNull CoordinatorLayout rootView,
      @NonNull AppBarLayout appBarLayout, @NonNull NestedScrollView content,
      @NonNull ContentDetailBinding detailContent, @NonNull FloatingActionButton fabFavourite,
      @NonNull ImageView imgPoster, @NonNull ProgressBar progressBar, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.content = content;
    this.detailContent = detailContent;
    this.fabFavourite = fabFavourite;
    this.imgPoster = imgPoster;
    this.progressBar = progressBar;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.content;
      NestedScrollView content = ViewBindings.findChildViewById(rootView, id);
      if (content == null) {
        break missingId;
      }

      id = R.id.detail_content;
      View detailContent = ViewBindings.findChildViewById(rootView, id);
      if (detailContent == null) {
        break missingId;
      }
      ContentDetailBinding binding_detailContent = ContentDetailBinding.bind(detailContent);

      id = R.id.fab_favourite;
      FloatingActionButton fabFavourite = ViewBindings.findChildViewById(rootView, id);
      if (fabFavourite == null) {
        break missingId;
      }

      id = R.id.img_poster;
      ImageView imgPoster = ViewBindings.findChildViewById(rootView, id);
      if (imgPoster == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityDetailBinding((CoordinatorLayout) rootView, appBarLayout, content,
          binding_detailContent, fabFavourite, imgPoster, progressBar, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
