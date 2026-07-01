package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutFullscreenCallPreviewEmptyBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Toolbar f2249b;

    @NonNull
    public final AppBarLayout c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final ViewStub j;

    @NonNull
    public final RecyclerView k;

    @NonNull
    public final LayoutFullscreenCallPreviewEmptyBinding l;

    public WidgetCallPreviewFullscreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ViewStub viewStub, @NonNull RecyclerView recyclerView, @NonNull LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding) {
        this.a = constraintLayout;
        this.f2249b = toolbar;
        this.c = appBarLayout;
        this.d = constraintLayout2;
        this.e = textView;
        this.f = constraintLayout3;
        this.g = constraintLayout4;
        this.h = materialButton;
        this.i = materialButton2;
        this.j = viewStub;
        this.k = recyclerView;
        this.l = layoutFullscreenCallPreviewEmptyBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
