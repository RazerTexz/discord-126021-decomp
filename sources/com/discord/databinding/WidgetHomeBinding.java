package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetHomePanelCenterBinding;
import b.a.i.WidgetHomePanelLeftBinding;
import b.a.i.WidgetHomePanelLoadingBinding;
import b.a.i.WidgetHomePanelRightBinding;
import com.discord.widgets.home.HomePanelsLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomeBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetHomePanelLoadingBinding f2465b;

    @NonNull
    public final HomePanelsLayout c;

    @NonNull
    public final WidgetHomePanelCenterBinding d;

    @NonNull
    public final WidgetHomePanelLeftBinding e;

    @NonNull
    public final WidgetHomePanelRightBinding f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final FrameLayout h;

    public WidgetHomeBinding(@NonNull FrameLayout frameLayout, @NonNull WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding, @NonNull HomePanelsLayout homePanelsLayout, @NonNull WidgetHomePanelCenterBinding widgetHomePanelCenterBinding, @NonNull WidgetHomePanelLeftBinding widgetHomePanelLeftBinding, @NonNull WidgetHomePanelRightBinding widgetHomePanelRightBinding, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.f2465b = widgetHomePanelLoadingBinding;
        this.c = homePanelsLayout;
        this.d = widgetHomePanelCenterBinding;
        this.e = widgetHomePanelLeftBinding;
        this.f = widgetHomePanelRightBinding;
        this.g = imageView;
        this.h = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
