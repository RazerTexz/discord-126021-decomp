package j0.l.a;

/* JADX INFO: compiled from: NotificationLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final Object a = new e$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3771b = new e$b();

    public static <T> boolean a(j0.g<? super T> gVar, Object obj) {
        if (obj == a) {
            gVar.onCompleted();
            return true;
        }
        if (obj == f3771b) {
            gVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == e$c.class) {
            gVar.onError(((e$c) obj).e);
            return true;
        }
        gVar.onNext(obj);
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
