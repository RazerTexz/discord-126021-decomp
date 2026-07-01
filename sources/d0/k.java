package d0;

import java.io.Serializable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k<T> implements Serializable {
    public static final k$a j = new k$a(null);
    private final Object value;

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m97constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m98equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof k) && d0.z.d.m.areEqual(obj, ((k) obj2).m104unboximpl());
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m99exceptionOrNullimpl(Object obj) {
        if (obj instanceof k$b) {
            return ((k$b) obj).exception;
        }
        return null;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m100hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m101isFailureimpl(Object obj) {
        return obj instanceof k$b;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m102isSuccessimpl(Object obj) {
        return !(obj instanceof k$b);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m103toStringimpl(Object obj) {
        if (obj instanceof k$b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m98equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m100hashCodeimpl(this.value);
    }

    public String toString() {
        return m103toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m104unboximpl() {
        return this.value;
    }
}
