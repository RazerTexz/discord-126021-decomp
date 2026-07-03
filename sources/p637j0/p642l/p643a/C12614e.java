package p637j0.p642l.p643a;

import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p637j0.InterfaceC12581g;

/* JADX INFO: renamed from: j0.l.a.e */
/* JADX INFO: compiled from: NotificationLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12614e {

    /* JADX INFO: renamed from: a */
    public static final Object f26768a = new a();

    /* JADX INFO: renamed from: b */
    public static final Object f26769b = new b();

    /* JADX INFO: renamed from: j0.l.a.e$a */
    /* JADX INFO: compiled from: NotificationLite.java */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* JADX INFO: renamed from: j0.l.a.e$b */
    /* JADX INFO: compiled from: NotificationLite.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* JADX INFO: renamed from: j0.l.a.e$c */
    /* JADX INFO: compiled from: NotificationLite.java */
    public static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* JADX INFO: renamed from: e */
        public final Throwable f26770e;

        public c(Throwable th) {
            this.f26770e = th;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Notification=>Error:");
            sbM833U.append(this.f26770e);
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> boolean m10744a(InterfaceC12581g<? super T> interfaceC12581g, Object obj) {
        if (obj == f26768a) {
            interfaceC12581g.onCompleted();
            return true;
        }
        if (obj == f26769b) {
            interfaceC12581g.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            interfaceC12581g.onError(((c) obj).f26770e);
            return true;
        }
        interfaceC12581g.onNext(obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public static <T> T m10745b(Object obj) {
        if (obj == f26769b) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m10746c(Object obj) {
        return obj == f26768a;
    }
}
