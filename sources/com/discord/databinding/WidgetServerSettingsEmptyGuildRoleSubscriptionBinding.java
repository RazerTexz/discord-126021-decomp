package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptionBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f2567b;

    @NonNull
    public final AppViewFlipper c;

    public WidgetServerSettingsEmptyGuildRoleSubscriptionBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button button, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2567b = button;
        this.c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
