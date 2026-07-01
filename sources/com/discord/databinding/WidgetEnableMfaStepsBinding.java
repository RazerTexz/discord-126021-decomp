package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEnableMfaStepsBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2380b;

    @NonNull
    public final StepsView c;

    public WidgetEnableMfaStepsBinding(@NonNull FrameLayout frameLayout, @NonNull DimmerView dimmerView, @NonNull StepsView stepsView) {
        this.a = frameLayout;
        this.f2380b = dimmerView;
        this.c = stepsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
