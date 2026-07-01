package f0;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: f0.t, reason: use source file name */
/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EventListener {
    public static final EventListener a = new a();

    /* JADX INFO: renamed from: f0.t$a */
    /* JADX INFO: compiled from: EventListener.kt */
    public static final class a extends EventListener {
    }

    /* JADX INFO: renamed from: f0.t$b */
    /* JADX INFO: compiled from: EventListener.kt */
    public interface b {
        EventListener a(Call2 call2);
    }

    public void a(Call2 call2, Connection2 connection2) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(connection2, "connection");
    }
}
