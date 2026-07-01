package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    private final ArrayList<b> tuples = new ArrayList<>();

    @Nullable
    private b lastMatch = null;

    @Nullable
    public ValueAnimator runningAnimator = null;
    private final Animator.AnimatorListener animationListener = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.runningAnimator == animator) {
                stateListAnimator.runningAnimator = null;
            }
        }
    }

    public static class b {
        public final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f3047b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.f3047b = valueAnimator;
        }
    }

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(@NonNull b bVar) {
        ValueAnimator valueAnimator = bVar.f3047b;
        this.runningAnimator = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(bVar);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        b bVar;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.tuples.get(i);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        b bVar2 = this.lastMatch;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            cancel();
        }
        this.lastMatch = bVar;
        if (bVar != null) {
            start(bVar);
        }
    }
}
