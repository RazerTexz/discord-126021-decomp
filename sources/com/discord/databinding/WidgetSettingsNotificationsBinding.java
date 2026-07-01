package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsNotificationsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2632b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final LinearLayout g;

    public WidgetSettingsNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull LinearLayout linearLayout) {
        this.a = coordinatorLayout;
        this.f2632b = checkedSetting;
        this.c = checkedSetting2;
        this.d = checkedSetting3;
        this.e = checkedSetting4;
        this.f = checkedSetting5;
        this.g = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
