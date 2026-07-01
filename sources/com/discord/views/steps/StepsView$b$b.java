package com.discord.views.steps;

import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView$b$b extends StepsView$b {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepsView$b$b)) {
            return false;
        }
        Objects.requireNonNull((StepsView$b$b) obj);
        return m.areEqual((Object) null, (Object) null) && m.areEqual((Object) null, (Object) null) && m.areEqual((Object) null, (Object) null);
    }

    public int hashCode() {
        return (((((((((((((((((0 * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public String toString() {
        return "ViewStep(layoutId=0, nextText=0, cancelText=0, doneText=0, onNext=null, onCancel=null, onDone=null, canNext=false, canCancel=false, allowScroll=false)";
    }
}
