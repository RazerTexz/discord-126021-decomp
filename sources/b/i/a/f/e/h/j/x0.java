package b.i.a.f.e.h.j;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 {
    public final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<TaskCompletionSource<?>, Boolean> f1374b = Collections.synchronizedMap(new WeakHashMap());

    public final void a(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.a) {
            map = new HashMap(this.a);
        }
        synchronized (this.f1374b) {
            map2 = new HashMap(this.f1374b);
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            if (z2 || ((Boolean) map$Entry.getValue()).booleanValue()) {
                ((BasePendingResult) map$Entry.getKey()).e(status);
            }
        }
        for (Map$Entry map$Entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) map$Entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) map$Entry2.getKey()).a(new ApiException(status));
            }
        }
    }
}
