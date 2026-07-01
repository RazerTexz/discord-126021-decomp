package s.a;

import b.d.b.a.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f3848b;

    /* JADX WARN: Multi-variable type inference failed */
    public x(Object obj, Function1<? super Throwable, Unit> function1) {
        this.a = obj;
        this.f3848b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return d0.z.d.m.areEqual(this.a, xVar.a) && d0.z.d.m.areEqual(this.f3848b, xVar.f3848b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Function1<Throwable, Unit> function1 = this.f3848b;
        return iHashCode + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CompletedWithCancellation(result=");
        sbU.append(this.a);
        sbU.append(", onCancellation=");
        sbU.append(this.f3848b);
        sbU.append(")");
        return sbU.toString();
    }
}
