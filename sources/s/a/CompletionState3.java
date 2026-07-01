package s.a;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: s.a.x, reason: use source file name */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompletionState3 {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f3848b;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletionState3(Object obj, Function1<? super Throwable, Unit> function1) {
        this.a = obj;
        this.f3848b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletionState3)) {
            return false;
        }
        CompletionState3 completionState3 = (CompletionState3) obj;
        return Intrinsics3.areEqual(this.a, completionState3.a) && Intrinsics3.areEqual(this.f3848b, completionState3.f3848b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Function1<Throwable, Unit> function1 = this.f3848b;
        return iHashCode + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CompletedWithCancellation(result=");
        sbU.append(this.a);
        sbU.append(", onCancellation=");
        sbU.append(this.f3848b);
        sbU.append(")");
        return sbU.toString();
    }
}
