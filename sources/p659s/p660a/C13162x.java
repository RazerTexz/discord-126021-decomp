package p659s.p660a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: s.a.x */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13162x {

    /* JADX INFO: renamed from: a */
    public final Object f27917a;

    /* JADX INFO: renamed from: b */
    public final Function1<Throwable, Unit> f27918b;

    /* JADX WARN: Multi-variable type inference failed */
    public C13162x(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f27917a = obj;
        this.f27918b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13162x)) {
            return false;
        }
        C13162x c13162x = (C13162x) obj;
        return C12238m.areEqual(this.f27917a, c13162x.f27917a) && C12238m.areEqual(this.f27918b, c13162x.f27918b);
    }

    public int hashCode() {
        Object obj = this.f27917a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Function1<Throwable, Unit> function1 = this.f27918b;
        return iHashCode + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CompletedWithCancellation(result=");
        sbM833U.append(this.f27917a);
        sbM833U.append(", onCancellation=");
        sbM833U.append(this.f27918b);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
