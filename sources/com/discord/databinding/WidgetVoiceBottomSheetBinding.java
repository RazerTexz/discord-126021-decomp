package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.t0;
import b.a.i.u0;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final t0 f2699b;

    @NonNull
    public final u0 c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final AnchoredVoiceControlsView f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final CoordinatorLayout i;

    public WidgetVoiceBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull t0 t0Var, @NonNull u0 u0Var, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull RelativeLayout relativeLayout, @NonNull AnchoredVoiceControlsView anchoredVoiceControlsView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.a = coordinatorLayout;
        this.f2699b = t0Var;
        this.c = u0Var;
        this.d = materialButton;
        this.e = relativeLayout;
        this.f = anchoredVoiceControlsView;
        this.g = materialButton2;
        this.h = recyclerView;
        this.i = coordinatorLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
