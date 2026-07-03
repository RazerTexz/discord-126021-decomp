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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17935a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17936b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17937c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17938d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f17939e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RecyclerView f17940f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f17941g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final CheckedSetting f17942h;

    public WidgetSettingsDeveloperBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull MaterialButton materialButton4, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView) {
        this.f17935a = coordinatorLayout;
        this.f17936b = materialButton;
        this.f17937c = materialButton2;
        this.f17938d = materialButton3;
        this.f17939e = recyclerView;
        this.f17940f = recyclerView2;
        this.f17941g = materialButton4;
        this.f17942h = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17935a;
    }
}
