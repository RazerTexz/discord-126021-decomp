package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsActivityStatusBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2601b;

    public WidgetSettingsActivityStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting) {
        this.a = coordinatorLayout;
        this.f2601b = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
