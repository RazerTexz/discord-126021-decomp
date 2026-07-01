package b.a.q;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ThermalDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i0$a extends d0.z.d.o implements Function0<Handler> {
    public static final i0$a j = new i0$a();

    public i0$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
