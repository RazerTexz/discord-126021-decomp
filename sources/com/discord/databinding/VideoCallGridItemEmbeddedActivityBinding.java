package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridItemEmbeddedActivityBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PileView f2169b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final View e;

    public VideoCallGridItemEmbeddedActivityBinding(@NonNull FrameLayout frameLayout, @NonNull PileView pileView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull View view) {
        this.a = frameLayout;
        this.f2169b = pileView;
        this.c = textView2;
        this.d = simpleDraweeView;
        this.e = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
