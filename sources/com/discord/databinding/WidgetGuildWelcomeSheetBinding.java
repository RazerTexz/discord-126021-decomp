package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildWelcomeSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17085a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17086b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17087c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppViewFlipper f17088d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f17089e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17090f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17091g;

    public WidgetGuildWelcomeSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f17085a = nestedScrollView;
        this.f17086b = recyclerView;
        this.f17087c = textView;
        this.f17088d = appViewFlipper;
        this.f17089e = simpleDraweeView;
        this.f17090f = textView2;
        this.f17091g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17085a;
    }
}
