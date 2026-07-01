package f0.e0;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.EventListener;

/* JADX INFO: renamed from: f0.e0.a, reason: use source file name */
/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Util5 implements EventListener.b {
    public final /* synthetic */ EventListener a;

    public Util5(EventListener eventListener) {
        this.a = eventListener;
    }

    @Override // f0.EventListener.b
    public EventListener a(Call2 call2) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        return this.a;
    }
}
