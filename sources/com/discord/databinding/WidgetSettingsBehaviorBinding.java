package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsBehaviorBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2605b;

    @NonNull
    public final TextView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final TextView e;

    @NonNull
    public final CheckedSetting f;

    public WidgetSettingsBehaviorBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3) {
        this.a = coordinatorLayout;
        this.f2605b = checkedSetting;
        this.c = textView;
        this.d = checkedSetting2;
        this.e = textView2;
        this.f = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
