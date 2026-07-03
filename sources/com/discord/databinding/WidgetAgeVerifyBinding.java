package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.C0960g0;
import p007b.p008a.p025i.C0968h0;
import p007b.p008a.p025i.C0975i0;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAgeVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15643a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f15644b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C0968h0 f15645c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C0975i0 f15646d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C0960g0 f15647e;

    public WidgetAgeVerifyBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull C0968h0 c0968h0, @NonNull C0975i0 c0975i0, @NonNull C0960g0 c0960g0) {
        this.f15643a = coordinatorLayout;
        this.f15644b = appViewFlipper;
        this.f15645c = c0968h0;
        this.f15646d = c0975i0;
        this.f15647e = c0960g0;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15643a;
    }
}
