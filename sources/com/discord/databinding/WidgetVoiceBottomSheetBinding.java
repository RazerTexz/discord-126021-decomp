package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutVoiceBottomSheetEmptyBinding;
import b.a.i.LayoutVoiceBottomSheetHeaderBinding;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LayoutVoiceBottomSheetEmptyBinding f2699b;

    @NonNull
    public final LayoutVoiceBottomSheetHeaderBinding c;

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

    public WidgetVoiceBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding, @NonNull LayoutVoiceBottomSheetHeaderBinding layoutVoiceBottomSheetHeaderBinding, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull RelativeLayout relativeLayout, @NonNull AnchoredVoiceControlsView anchoredVoiceControlsView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.a = coordinatorLayout;
        this.f2699b = layoutVoiceBottomSheetEmptyBinding;
        this.c = layoutVoiceBottomSheetHeaderBinding;
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
