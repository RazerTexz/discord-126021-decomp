package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1052t0;
import p007b.p008a.p025i.C1059u0;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18437a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1052t0 f18438b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1059u0 f18439c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f18440d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RelativeLayout f18441e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final AnchoredVoiceControlsView f18442f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f18443g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final RecyclerView f18444h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CoordinatorLayout f18445i;

    public WidgetVoiceBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull C1052t0 c1052t0, @NonNull C1059u0 c1059u0, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull RelativeLayout relativeLayout, @NonNull AnchoredVoiceControlsView anchoredVoiceControlsView, @NonNull MaterialButton materialButton2, @NonNull RecyclerView recyclerView, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.f18437a = coordinatorLayout;
        this.f18438b = c1052t0;
        this.f18439c = c1059u0;
        this.f18440d = materialButton;
        this.f18441e = relativeLayout;
        this.f18442f = anchoredVoiceControlsView;
        this.f18443g = materialButton2;
        this.f18444h = recyclerView;
        this.f18445i = coordinatorLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18437a;
    }
}
