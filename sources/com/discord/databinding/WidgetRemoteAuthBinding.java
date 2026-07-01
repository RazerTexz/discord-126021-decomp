package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.v5;
import b.a.i.w5;
import b.a.i.x5;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRemoteAuthBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final x5 f2519b;

    @NonNull
    public final v5 c;

    @NonNull
    public final w5 d;

    @NonNull
    public final AppViewFlipper e;

    public WidgetRemoteAuthBinding(@NonNull RelativeLayout relativeLayout, @NonNull x5 x5Var, @NonNull v5 v5Var, @NonNull w5 w5Var, @NonNull AppViewFlipper appViewFlipper) {
        this.a = relativeLayout;
        this.f2519b = x5Var;
        this.c = v5Var;
        this.d = w5Var;
        this.e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
