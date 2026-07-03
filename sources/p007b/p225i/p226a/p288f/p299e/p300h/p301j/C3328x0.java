package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.x0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3328x0 {

    /* JADX INFO: renamed from: a */
    public final Map<BasePendingResult<?>, Boolean> f9464a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    public final Map<TaskCompletionSource<?>, Boolean> f9465b = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: a */
    public final void m4120a(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f9464a) {
            map = new HashMap(this.f9464a);
        }
        synchronized (this.f9465b) {
            map2 = new HashMap(this.f9465b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m9033e(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).m9125a(new ApiException(status));
            }
        }
    }
}
