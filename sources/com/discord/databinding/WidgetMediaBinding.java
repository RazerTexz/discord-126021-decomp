package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMediaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f17228a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppBarLayout f17229b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f17230c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ZoomableDraweeView f17231d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ProgressBar f17232e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final PlayerControlView f17233f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final PlayerView f17234g;

    public WidgetMediaBinding(@NonNull FrameLayout frameLayout, @NonNull AppBarLayout appBarLayout, @NonNull FrameLayout frameLayout2, @NonNull ZoomableDraweeView zoomableDraweeView, @NonNull ProgressBar progressBar, @NonNull PlayerControlView playerControlView, @NonNull PlayerView playerView) {
        this.f17228a = frameLayout;
        this.f17229b = appBarLayout;
        this.f17230c = frameLayout2;
        this.f17231d = zoomableDraweeView;
        this.f17232e = progressBar;
        this.f17233f = playerControlView;
        this.f17234g = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17228a;
    }
}
