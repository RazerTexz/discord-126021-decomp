package p507d0;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.k */
/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12112k<T> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final a f25169j = new a(null);
    private final Object value;

    /* JADX INFO: renamed from: d0.k$a */
    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.k$b */
    /* JADX INFO: compiled from: Result.kt */
    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            C12238m.checkNotNullParameter(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && C12238m.areEqual(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Failure(");
            sbM833U.append(this.exception);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m11474constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m11475equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof C12112k) && C12238m.areEqual(obj, ((C12112k) obj2).m11481unboximpl());
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m11476exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m11477hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m11478isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m11479isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m11480toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m11475equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m11477hashCodeimpl(this.value);
    }

    public String toString() {
        return m11480toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m11481unboximpl() {
        return this.value;
    }
}
