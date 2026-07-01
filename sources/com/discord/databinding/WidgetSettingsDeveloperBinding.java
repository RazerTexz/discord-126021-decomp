package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsDeveloperBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2615b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final RecyclerView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final CheckedSetting h;

    public WidgetSettingsDeveloperBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull MaterialButton materialButton4, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView) {
        this.a = coordinatorLayout;
        this.f2615b = materialButton;
        this.c = materialButton2;
        this.d = materialButton3;
        this.e = recyclerView;
        this.f = recyclerView2;
        this.g = materialButton4;
        this.h = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
