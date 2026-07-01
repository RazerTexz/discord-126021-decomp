package com.discord.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewServerSettingsIconNameBinding;
import b.a.i.ViewServerSettingsNotificationsBinding;
import b.a.i.ViewServerSettingsSystemChannelWrapBinding;
import b.a.i.ViewServerSettingsUploadBannerBinding;
import b.a.i.ViewServerSettingsUploadSplashBinding;
import b.a.i.WidgetServerSettingsOverviewSectionAfkChannelBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsOverviewBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetServerSettingsOverviewSectionAfkChannelBinding f2582b;

    @NonNull
    public final ViewServerSettingsIconNameBinding c;

    @NonNull
    public final ViewServerSettingsNotificationsBinding d;

    @NonNull
    public final FloatingActionButton e;

    @NonNull
    public final ScrollView f;

    @NonNull
    public final ViewServerSettingsSystemChannelWrapBinding g;

    @NonNull
    public final ViewServerSettingsUploadBannerBinding h;

    @NonNull
    public final ViewServerSettingsUploadSplashBinding i;

    public WidgetServerSettingsOverviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull WidgetServerSettingsOverviewSectionAfkChannelBinding widgetServerSettingsOverviewSectionAfkChannelBinding, @NonNull ViewServerSettingsIconNameBinding viewServerSettingsIconNameBinding, @NonNull ViewServerSettingsNotificationsBinding viewServerSettingsNotificationsBinding, @NonNull FloatingActionButton floatingActionButton, @NonNull ScrollView scrollView, @NonNull ViewServerSettingsSystemChannelWrapBinding viewServerSettingsSystemChannelWrapBinding, @NonNull ViewServerSettingsUploadBannerBinding viewServerSettingsUploadBannerBinding, @NonNull ViewServerSettingsUploadSplashBinding viewServerSettingsUploadSplashBinding) {
        this.a = coordinatorLayout;
        this.f2582b = widgetServerSettingsOverviewSectionAfkChannelBinding;
        this.c = viewServerSettingsIconNameBinding;
        this.d = viewServerSettingsNotificationsBinding;
        this.e = floatingActionButton;
        this.f = scrollView;
        this.g = viewServerSettingsSystemChannelWrapBinding;
        this.h = viewServerSettingsUploadBannerBinding;
        this.i = viewServerSettingsUploadSplashBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
