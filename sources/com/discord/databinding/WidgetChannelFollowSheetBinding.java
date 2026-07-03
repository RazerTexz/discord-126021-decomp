package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelFollowSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15831a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15832b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15833c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15834d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialCardView f15835e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialCardView f15836f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15837g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15838h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f15839i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final AppViewFlipper f15840j;

    public WidgetChannelFollowSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull AppViewFlipper appViewFlipper) {
        this.f15831a = nestedScrollView;
        this.f15832b = textView;
        this.f15833c = textView2;
        this.f15834d = simpleDraweeView;
        this.f15835e = materialCardView;
        this.f15836f = materialCardView2;
        this.f15837g = textView3;
        this.f15838h = textView4;
        this.f15839i = materialButton;
        this.f15840j = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15831a;
    }
}
