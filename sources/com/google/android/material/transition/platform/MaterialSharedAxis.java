package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public final class MaterialSharedAxis extends AbstractC4477h<VisibilityAnimatorProvider> {

    /* JADX INFO: renamed from: X */
    public static final int f21393X = 0;

    /* JADX INFO: renamed from: Y */
    public static final int f21394Y = 1;

    /* JADX INFO: renamed from: Z */
    public static final int f21395Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Axis {
    }

    public MaterialSharedAxis(int i, boolean z2) {
        super(createPrimaryAnimatorProvider(i, z2), createSecondaryAnimatorProvider());
        this.axis = i;
        this.forward = z2;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int i, boolean z2) {
        if (i == 0) {
            return new SlideDistanceProvider(z2 ? GravityCompat.END : GravityCompat.START);
        }
        if (i == 1) {
            return new SlideDistanceProvider(z2 ? 80 : 48);
        }
        if (i == 2) {
            return new ScaleProvider(z2);
        }
        throw new IllegalArgumentException(C1643a.m871q("Invalid axis: ", i));
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // p007b.p225i.p226a.p341g.p353l.p354l.AbstractC4477h
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
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
