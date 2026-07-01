package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.i5;
import b.a.i.l5;
import b.a.i.m5;
import b.a.i.n5;
import com.discord.widgets.home.HomePanelsLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomeBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m5 f2465b;

    @NonNull
    public final HomePanelsLayout c;

    @NonNull
    public final i5 d;

    @NonNull
    public final l5 e;

    @NonNull
    public final n5 f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final FrameLayout h;

    public WidgetHomeBinding(@NonNull FrameLayout frameLayout, @NonNull m5 m5Var, @NonNull HomePanelsLayout homePanelsLayout, @NonNull i5 i5Var, @NonNull l5 l5Var, @NonNull n5 n5Var, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.f2465b = m5Var;
        this.c = homePanelsLayout;
        this.d = i5Var;
        this.e = l5Var;
        this.f = n5Var;
        this.g = imageView;
        this.h = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
