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

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2399b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final RLottieImageView f;

    @NonNull
    public final TextView g;

    public WidgetFriendsNearbyBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull RLottieImageView rLottieImageView, @NonNull TextView textView3) {
        this.a = nestedScrollView;
        this.f2399b = materialButton;
        this.c = textView;
        this.d = recyclerView;
        this.e = textView2;
        this.f = rLottieImageView;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
