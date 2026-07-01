package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetRemoteAuthNotFoundBinding;
import b.a.i.WidgetRemoteAuthPendingLoginBinding;
import b.a.i.WidgetRemoteAuthSuccessBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRemoteAuthBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetRemoteAuthSuccessBinding f2519b;

    @NonNull
    public final WidgetRemoteAuthNotFoundBinding c;

    @NonNull
    public final WidgetRemoteAuthPendingLoginBinding d;

    @NonNull
    public final AppViewFlipper e;

    public WidgetRemoteAuthBinding(@NonNull RelativeLayout relativeLayout, @NonNull WidgetRemoteAuthSuccessBinding widgetRemoteAuthSuccessBinding, @NonNull WidgetRemoteAuthNotFoundBinding widgetRemoteAuthNotFoundBinding, @NonNull WidgetRemoteAuthPendingLoginBinding widgetRemoteAuthPendingLoginBinding, @NonNull AppViewFlipper appViewFlipper) {
        this.a = relativeLayout;
        this.f2519b = widgetRemoteAuthSuccessBinding;
        this.c = widgetRemoteAuthNotFoundBinding;
        this.d = widgetRemoteAuthPendingLoginBinding;
        this.e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
