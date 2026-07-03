package p659s.p660a;

import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: s.a.v */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13156v {

    /* JADX INFO: renamed from: a */
    public final Object f27906a;

    /* JADX INFO: renamed from: b */
    public final AbstractC13120j f27907b;

    /* JADX INFO: renamed from: c */
    public final Function1<Throwable, Unit> f27908c;

    /* JADX INFO: renamed from: d */
    public final Object f27909d;

    /* JADX INFO: renamed from: e */
    public final Throwable f27910e;

    /* JADX WARN: Multi-variable type inference failed */
    public C13156v(Object obj, AbstractC13120j abstractC13120j, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f27906a = obj;
        this.f27907b = abstractC13120j;
        this.f27908c = function1;
        this.f27909d = obj2;
        this.f27910e = th;
    }

    /* JADX INFO: renamed from: a */
    public static C13156v m11349a(C13156v c13156v, Object obj, AbstractC13120j abstractC13120j, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = (i & 1) != 0 ? c13156v.f27906a : null;
        if ((i & 2) != 0) {
            abstractC13120j = c13156v.f27907b;
        }
        AbstractC13120j abstractC13120j2 = abstractC13120j;
        Function1<Throwable, Unit> function2 = (i & 4) != 0 ? c13156v.f27908c : null;
        Object obj4 = (i & 8) != 0 ? c13156v.f27909d : null;
        if ((i & 16) != 0) {
            th = c13156v.f27910e;
        }
        Objects.requireNonNull(c13156v);
        return new C13156v(obj3, abstractC13120j2, function2, obj4, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13156v)) {
            return false;
        }
        C13156v c13156v = (C13156v) obj;
        return C12238m.areEqual(this.f27906a, c13156v.f27906a) && C12238m.areEqual(this.f27907b, c13156v.f27907b) && C12238m.areEqual(this.f27908c, c13156v.f27908c) && C12238m.areEqual(this.f27909d, c13156v.f27909d) && C12238m.areEqual(this.f27910e, c13156v.f27910e);
    }

    public int hashCode() {
        Object obj = this.f27906a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        AbstractC13120j abstractC13120j = this.f27907b;
        int iHashCode2 = (iHashCode + (abstractC13120j != null ? abstractC13120j.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.f27908c;
        int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.f27909d;
        int iHashCode4 = (iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f27910e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CompletedContinuation(result=");
        sbM833U.append(this.f27906a);
        sbM833U.append(", cancelHandler=");
        sbM833U.append(this.f27907b);
        sbM833U.append(", onCancellation=");
        sbM833U.append(this.f27908c);
        sbM833U.append(", idempotentResume=");
        sbM833U.append(this.f27909d);
        sbM833U.append(", cancelCause=");
        sbM833U.append(this.f27910e);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public C13156v(Object obj, AbstractC13120j abstractC13120j, Function1 function1, Object obj2, Throwable th, int i) {
        abstractC13120j = (i & 2) != 0 ? null : abstractC13120j;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.f27906a = obj;
        this.f27907b = abstractC13120j;
        this.f27908c = function1;
        this.f27909d = obj2;
        this.f27910e = th;
    }
}
