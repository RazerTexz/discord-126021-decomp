package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsModerationBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2580b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final TextView e;

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
    public final TextView k;

    public WidgetServerSettingsModerationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6, @NonNull CheckedSetting checkedSetting7, @NonNull CheckedSetting checkedSetting8, @NonNull TextView textView2) {
        this.a = coordinatorLayout;
        this.f2580b = checkedSetting;
        this.c = checkedSetting2;
        this.d = checkedSetting3;
        this.e = textView;
        this.f = checkedSetting4;
        this.g = checkedSetting5;
        this.h = checkedSetting6;
        this.i = checkedSetting7;
        this.j = checkedSetting8;
        this.k = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
