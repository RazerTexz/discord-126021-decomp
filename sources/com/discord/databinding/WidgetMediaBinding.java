package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMediaBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f2486b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final ZoomableDraweeView d;

    @NonNull
    public final ProgressBar e;

    @NonNull
    public final PlayerControlView f;

    @NonNull
    public final PlayerView g;

    public WidgetMediaBinding(@NonNull FrameLayout frameLayout, @NonNull AppBarLayout appBarLayout, @NonNull FrameLayout frameLayout2, @NonNull ZoomableDraweeView zoomableDraweeView, @NonNull ProgressBar progressBar, @NonNull PlayerControlView playerControlView, @NonNull PlayerView playerView) {
        this.a = frameLayout;
        this.f2486b = appBarLayout;
        this.c = frameLayout2;
        this.d = zoomableDraweeView;
        this.e = progressBar;
        this.f = playerControlView;
        this.g = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
