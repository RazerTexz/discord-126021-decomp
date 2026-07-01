package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboardingBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2558b;

    @NonNull
    public final ViewStub c;

    @NonNull
    public final ViewStub d;

    @NonNull
    public final AppViewFlipper e;

    public WidgetServerSettingsCreatorMonetizationOnboardingBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2558b = textView;
        this.c = viewStub;
        this.d = viewStub2;
        this.e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
