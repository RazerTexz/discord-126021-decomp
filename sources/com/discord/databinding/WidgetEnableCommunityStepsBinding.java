package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.steps.StepsView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEnableCommunityStepsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final StepsView f16582a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StepsView f16583b;

    public WidgetEnableCommunityStepsBinding(@NonNull StepsView stepsView, @NonNull StepsView stepsView2) {
        this.f16582a = stepsView;
        this.f16583b = stepsView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16582a;
    }
}
