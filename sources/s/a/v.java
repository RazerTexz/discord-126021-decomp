package s.a;

import b.d.b.a.a;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3845b;
    public final Function1<Throwable, Unit> c;
    public final Object d;
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Object obj, j jVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.a = obj;
        this.f3845b = jVar;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    public static v a(v vVar, Object obj, j jVar, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = (i & 1) != 0 ? vVar.a : null;
        if ((i & 2) != 0) {
            jVar = vVar.f3845b;
        }
        j jVar2 = jVar;
        Function1<Throwable, Unit> function2 = (i & 4) != 0 ? vVar.c : null;
        Object obj4 = (i & 8) != 0 ? vVar.d : null;
        if ((i & 16) != 0) {
            th = vVar.e;
        }
        Objects.requireNonNull(vVar);
        return new v(obj3, jVar2, function2, obj4, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return d0.z.d.m.areEqual(this.a, vVar.a) && d0.z.d.m.areEqual(this.f3845b, vVar.f3845b) && d0.z.d.m.areEqual(this.c, vVar.c) && d0.z.d.m.areEqual(this.d, vVar.d) && d0.z.d.m.areEqual(this.e, vVar.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        j jVar = this.f3845b;
        int iHashCode2 = (iHashCode + (jVar != null ? jVar.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.c;
        int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CompletedContinuation(result=");
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

    public v(Object obj, j jVar, Function1 function1, Object obj2, Throwable th, int i) {
        jVar = (i & 2) != 0 ? null : jVar;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.a = obj;
        this.f3845b = jVar;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }
}
