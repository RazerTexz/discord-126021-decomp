package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.rlottie.RLottieImageView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsNearbyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16686a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16687b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16688c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f16689d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16690e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RLottieImageView f16691f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16692g;

    public WidgetFriendsNearbyBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull RLottieImageView rLottieImageView, @NonNull TextView textView3) {
        this.f16686a = nestedScrollView;
        this.f16687b = materialButton;
        this.f16688c = textView;
        this.f16689d = recyclerView;
        this.f16690e = textView2;
        this.f16691f = rLottieImageView;
        this.f16692g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16686a;
    }
}
