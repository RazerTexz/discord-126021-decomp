package com.google.android.material.internal;

import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class StateListAnimator {
    private final ArrayList<StateListAnimator$b> tuples = new ArrayList<>();

    @Nullable
    private StateListAnimator$b lastMatch = null;

    @Nullable
    public ValueAnimator runningAnimator = null;
    private final Animator$AnimatorListener animationListener = new StateListAnimator$a(this);

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    private void start(@NonNull StateListAnimator$b stateListAnimator$b) {
        ValueAnimator valueAnimator = stateListAnimator$b.f3047b;
        this.runningAnimator = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        StateListAnimator$b stateListAnimator$b = new StateListAnimator$b(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(stateListAnimator$b);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] iArr) {
        StateListAnimator$b stateListAnimator$b;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                stateListAnimator$b = null;
                break;
            }
            stateListAnimator$b = this.tuples.get(i);
            if (StateSet.stateSetMatches(stateListAnimator$b.a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        StateListAnimator$b stateListAnimator$b2 = this.lastMatch;
        if (stateListAnimator$b == stateListAnimator$b2) {
            return;
        }
        if (stateListAnimator$b2 != null) {
            cancel();
        }
        this.lastMatch = stateListAnimator$b;
        if (stateListAnimator$b != null) {
            start(stateListAnimator$b);
        }
    }
}
