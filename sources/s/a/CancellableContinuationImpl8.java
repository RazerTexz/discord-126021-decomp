package s.a;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: s.a.v, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuationImpl8 {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CancellableContinuationImpl4 f3845b;
    public final Function1<Throwable, Unit> c;
    public final Object d;
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl8(Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.a = obj;
        this.f3845b = cancellableContinuationImpl4;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    public static CancellableContinuationImpl8 a(CancellableContinuationImpl8 cancellableContinuationImpl8, Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = (i & 1) != 0 ? cancellableContinuationImpl8.a : null;
        if ((i & 2) != 0) {
            cancellableContinuationImpl4 = cancellableContinuationImpl8.f3845b;
        }
        CancellableContinuationImpl4 cancellableContinuationImpl5 = cancellableContinuationImpl4;
        Function1<Throwable, Unit> function2 = (i & 4) != 0 ? cancellableContinuationImpl8.c : null;
        Object obj4 = (i & 8) != 0 ? cancellableContinuationImpl8.d : null;
        if ((i & 16) != 0) {
            th = cancellableContinuationImpl8.e;
        }
        Objects.requireNonNull(cancellableContinuationImpl8);
        return new CancellableContinuationImpl8(obj3, cancellableContinuationImpl5, function2, obj4, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellableContinuationImpl8)) {
            return false;
        }
        CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj;
        return Intrinsics3.areEqual(this.a, cancellableContinuationImpl8.a) && Intrinsics3.areEqual(this.f3845b, cancellableContinuationImpl8.f3845b) && Intrinsics3.areEqual(this.c, cancellableContinuationImpl8.c) && Intrinsics3.areEqual(this.d, cancellableContinuationImpl8.d) && Intrinsics3.areEqual(this.e, cancellableContinuationImpl8.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        CancellableContinuationImpl4 cancellableContinuationImpl4 = this.f3845b;
        int iHashCode2 = (iHashCode + (cancellableContinuationImpl4 != null ? cancellableContinuationImpl4.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.c;
        int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CompletedContinuation(result=");
        sbU.append(this.a);
        sbU.append(", cancelHandler=");
        sbU.append(this.f3845b);
        sbU.append(", onCancellation=");
        sbU.append(this.c);
        sbU.append(", idempotentResume=");
        sbU.append(this.d);
        sbU.append(", cancelCause=");
        sbU.append(this.e);
        sbU.append(")");
        return sbU.toString();
    }

    public CancellableContinuationImpl8(Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1 function1, Object obj2, Throwable th, int i) {
        cancellableContinuationImpl4 = (i & 2) != 0 ? null : cancellableContinuationImpl4;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.a = obj;
        this.f3845b = cancellableContinuationImpl4;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }
}
