package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.C0982j0;
import p007b.p008a.p025i.C0989k0;
import p007b.p008a.p025i.C0996l0;
import p007b.p008a.p025i.C1003m0;
import p007b.p008a.p025i.C1010n0;
import p007b.p008a.p025i.C1024p0;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetContactSyncBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16409a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C0982j0 f16410b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1003m0 f16411c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C1010n0 f16412d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C0989k0 f16413e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final C0996l0 f16414f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final C1024p0 f16415g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final AppViewFlipper f16416h;

    public WidgetContactSyncBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull C0982j0 c0982j0, @NonNull C1003m0 c1003m0, @NonNull C1010n0 c1010n0, @NonNull C0989k0 c0989k0, @NonNull C0996l0 c0996l0, @NonNull C1024p0 c1024p0, @NonNull AppViewFlipper appViewFlipper) {
        this.f16409a = coordinatorLayout;
        this.f16410b = c0982j0;
        this.f16411c = c1003m0;
        this.f16412d = c1010n0;
        this.f16413e = c0989k0;
        this.f16414f = c0996l0;
        this.f16415g = c1024p0;
        this.f16416h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16409a;
    }
}
