// Generated by view binder compiler. Do not edit!
package com.app.themoviedatabase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.themoviedatabase.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView tvDetailDate;

  @NonNull
  public final TextView tvDetailDescription;

  @NonNull
  public final TextView tvDetailLanguage;

  @NonNull
  public final TextView tvDetailOverview;

  @NonNull
  public final TextView tvDetailPopularity;

  @NonNull
  public final TextView tvDetailRate;

  @NonNull
  public final TextView tvDetailTitle;

  private ContentDetailBinding(@NonNull ConstraintLayout rootView, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView tvDetailDate,
      @NonNull TextView tvDetailDescription, @NonNull TextView tvDetailLanguage,
      @NonNull TextView tvDetailOverview, @NonNull TextView tvDetailPopularity,
      @NonNull TextView tvDetailRate, @NonNull TextView tvDetailTitle) {
    this.rootView = rootView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.tvDetailDate = tvDetailDate;
    this.tvDetailDescription = tvDetailDescription;
    this.tvDetailLanguage = tvDetailLanguage;
    this.tvDetailOverview = tvDetailOverview;
    this.tvDetailPopularity = tvDetailPopularity;
    this.tvDetailRate = tvDetailRate;
    this.tvDetailTitle = tvDetailTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.tv_detail_date;
      TextView tvDetailDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailDate == null) {
        break missingId;
      }

      id = R.id.tv_detail_description;
      TextView tvDetailDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailDescription == null) {
        break missingId;
      }

      id = R.id.tv_detail_language;
      TextView tvDetailLanguage = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailLanguage == null) {
        break missingId;
      }

      id = R.id.tv_detail_overview;
      TextView tvDetailOverview = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailOverview == null) {
        break missingId;
      }

      id = R.id.tv_detail_popularity;
      TextView tvDetailPopularity = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailPopularity == null) {
        break missingId;
      }

      id = R.id.tv_detail_rate;
      TextView tvDetailRate = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailRate == null) {
        break missingId;
      }

      id = R.id.tv_detail_title;
      TextView tvDetailTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailTitle == null) {
        break missingId;
      }

      return new ContentDetailBinding((ConstraintLayout) rootView, textView2, textView3, textView4,
          tvDetailDate, tvDetailDescription, tvDetailLanguage, tvDetailOverview, tvDetailPopularity,
          tvDetailRate, tvDetailTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
