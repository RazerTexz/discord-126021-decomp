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

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2255b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final MaterialCardView e;

    @NonNull
    public final MaterialCardView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final AppViewFlipper j;

    public WidgetChannelFollowSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull AppViewFlipper appViewFlipper) {
        this.a = nestedScrollView;
        this.f2255b = textView;
        this.c = textView2;
        this.d = simpleDraweeView;
        this.e = materialCardView;
        this.f = materialCardView2;
        this.g = textView3;
        this.h = textView4;
        this.i = materialButton;
        this.j = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
