package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import b.a.i.IntegrationSyncSettingsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEditIntegrationBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2560b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final CheckedSetting h;

    @NonNull
    public final CheckedSetting i;

    @NonNull
    public final CheckedSetting j;

    @NonNull
    public final CheckedSetting k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final FloatingActionButton o;

    @NonNull
    public final IntegrationSyncSettingsBinding p;

    public WidgetServerSettingsEditIntegrationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6, @NonNull CheckedSetting checkedSetting7, @NonNull CheckedSetting checkedSetting8, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout4, @NonNull TextView textView2, @NonNull FloatingActionButton floatingActionButton, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull IntegrationSyncSettingsBinding integrationSyncSettingsBinding) {
        this.a = coordinatorLayout;
        this.f2560b = dimmerView;
        this.c = linearLayout;
        this.d = checkedSetting;
        this.e = checkedSetting2;
        this.f = checkedSetting3;
        this.g = checkedSetting4;
        this.h = checkedSetting5;
        this.i = checkedSetting6;
        this.j = checkedSetting7;
        this.k = checkedSetting8;
        this.l = imageView;
        this.m = textView;
        this.n = textView2;
        this.o = floatingActionButton;
        this.p = integrationSyncSettingsBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
