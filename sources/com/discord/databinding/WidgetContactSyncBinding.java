package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutContactSyncAddPhoneBinding;
import b.a.i.LayoutContactSyncLandingBinding;
import b.a.i.LayoutContactSyncNameInputBinding;
import b.a.i.LayoutContactSyncSuggestionsBinding;
import b.a.i.LayoutContactSyncSuggestionsEmptyBinding;
import b.a.i.LayoutContactSyncVerifyPhoneBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetContactSyncBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LayoutContactSyncAddPhoneBinding f2355b;

    @NonNull
    public final LayoutContactSyncSuggestionsBinding c;

    @NonNull
    public final LayoutContactSyncSuggestionsEmptyBinding d;

    @NonNull
    public final LayoutContactSyncLandingBinding e;

    @NonNull
    public final LayoutContactSyncNameInputBinding f;

    @NonNull
    public final LayoutContactSyncVerifyPhoneBinding g;

    @NonNull
    public final AppViewFlipper h;

    public WidgetContactSyncBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LayoutContactSyncAddPhoneBinding layoutContactSyncAddPhoneBinding, @NonNull LayoutContactSyncSuggestionsBinding layoutContactSyncSuggestionsBinding, @NonNull LayoutContactSyncSuggestionsEmptyBinding layoutContactSyncSuggestionsEmptyBinding, @NonNull LayoutContactSyncLandingBinding layoutContactSyncLandingBinding, @NonNull LayoutContactSyncNameInputBinding layoutContactSyncNameInputBinding, @NonNull LayoutContactSyncVerifyPhoneBinding layoutContactSyncVerifyPhoneBinding, @NonNull AppViewFlipper appViewFlipper) {
        this.a = coordinatorLayout;
        this.f2355b = layoutContactSyncAddPhoneBinding;
        this.c = layoutContactSyncSuggestionsBinding;
        this.d = layoutContactSyncSuggestionsEmptyBinding;
        this.e = layoutContactSyncLandingBinding;
        this.f = layoutContactSyncNameInputBinding;
        this.g = layoutContactSyncVerifyPhoneBinding;
        this.h = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
