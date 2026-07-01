package j0.l.a;

import b.d.b.a.outline;
import j0.Observer2;
import java.io.Serializable;

/* JADX INFO: renamed from: j0.l.a.e, reason: use source file name */
/* JADX INFO: compiled from: NotificationLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NotificationLite {
    public static final Object a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3771b = new b();

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
        public final Throwable e;

        public c(Throwable th) {
            this.e = th;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Notification=>Error:");
            sbU.append(this.e);
            return sbU.toString();
        }
    }

    public static <T> boolean a(Observer2<? super T> observer2, Object obj) {
        if (obj == a) {
            observer2.onCompleted();
            return true;
        }
        if (obj == f3771b) {
            observer2.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            observer2.onError(((c) obj).e);
            return true;
        }
        observer2.onNext(obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(Object obj) {
        if (obj == f3771b) {
            return null;
        }
        return obj;
    }

    public static boolean c(Object obj) {
        return obj == a;
    }
}
