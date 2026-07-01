package j0.l.a;

import java.io.Serializable;

/* JADX INFO: compiled from: NotificationLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c implements Serializable {
    private static final long serialVersionUID = 3;
    public final Throwable e;

    public e$c(Throwable th) {
        this.e = th;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Notification=>Error:");
        sbU.append(this.e);
        return sbU.toString();
    }
}
