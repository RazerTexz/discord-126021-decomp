package b.a.o;

import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$b {
    public static WeakReference<b> a = new WeakReference<>(null);

    @UiThread
    public static final b a() {
        b bVar = a.get();
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        a = new WeakReference<>(bVar2);
        return bVar2;
    }
}
