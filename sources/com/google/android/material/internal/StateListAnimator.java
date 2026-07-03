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
    private final ArrayList<C10945b> tuples = new ArrayList<>();

    @Nullable
    private C10945b lastMatch = null;

    @Nullable
    public ValueAnimator runningAnimator = null;
    private final Animator.AnimatorListener animationListener = new C10944a();

    /* JADX INFO: renamed from: com.google.android.material.internal.StateListAnimator$a */
    public class C10944a extends AnimatorListenerAdapter {
        public C10944a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.runningAnimator == animator) {
                stateListAnimator.runningAnimator = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.StateListAnimator$b */
    public static class C10945b {

        /* JADX INFO: renamed from: a */
        public final int[] f21043a;

        /* JADX INFO: renamed from: b */
        public final ValueAnimator f21044b;

        public C10945b(int[] iArr, ValueAnimator valueAnimator) {
            this.f21043a = iArr;
            this.f21044b = valueAnimator;
        }
    }

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(@NonNull C10945b c10945b) {
        ValueAnimator valueAnimator = c10945b.f21044b;
        this.runningAnimator = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        C10945b c10945b = new C10945b(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(c10945b);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        C10945b c10945b;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c10945b = null;
                break;
            }
            c10945b = this.tuples.get(i);
            if (StateSet.stateSetMatches(c10945b.f21043a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        C10945b c10945b2 = this.lastMatch;
        if (c10945b == c10945b2) {
            return;
        }
        if (c10945b2 != null) {
            cancel();
        }
        this.lastMatch = c10945b;
        if (c10945b != null) {
            start(c10945b);
        }
    }
}
