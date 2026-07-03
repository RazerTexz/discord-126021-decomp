package p600f0;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.t */
/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12376t {

    /* JADX INFO: renamed from: a */
    public static final AbstractC12376t f25962a = new a();

    /* JADX INFO: renamed from: f0.t$a */
    /* JADX INFO: compiled from: EventListener.kt */
    public static final class a extends AbstractC12376t {
    }

    /* JADX INFO: renamed from: f0.t$b */
    /* JADX INFO: compiled from: EventListener.kt */
    public interface b {
        /* JADX INFO: renamed from: a */
        AbstractC12376t mo10115a(InterfaceC12269e interfaceC12269e);
    }

    /* JADX INFO: renamed from: a */
    public void m10393a(InterfaceC12269e interfaceC12269e, InterfaceC12367k interfaceC12367k) {
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(interfaceC12367k, "connection");
    }
}
