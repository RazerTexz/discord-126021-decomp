package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class MaterialElevationScale extends AbstractC4477h<ScaleProvider> {
    private static final float DEFAULT_SCALE = 0.85f;
    private final boolean growing;

    public MaterialElevationScale(boolean z2) {
        super(createPrimaryAnimatorProvider(z2), createSecondaryAnimatorProvider());
        this.growing = z2;
    }

    private static ScaleProvider createPrimaryAnimatorProvider(boolean z2) {
        ScaleProvider scaleProvider = new ScaleProvider(z2);
        scaleProvider.setOutgoingEndScale(DEFAULT_SCALE);
        scaleProvider.setIncomingStartScale(DEFAULT_SCALE);
        return scaleProvider;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeProvider();
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isGrowing() {
        return this.growing;
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
