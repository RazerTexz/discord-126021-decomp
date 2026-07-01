package b.i.a.c.w2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import b.i.a.c.e3.r$b;
import b.i.a.c.o1$f;
import b.i.a.c.x0;
import b.i.b.b.s0;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: DefaultDrmSessionManagerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    public o1$f f1155b;

    @GuardedBy("lock")
    public u c;

    @RequiresApi(18)
    public final u a(o1$f o1_f) {
        r$b r_b = new r$b();
        r_b.f951b = null;
        Uri uri = o1_f.f1036b;
        d0 d0Var = new d0(uri == null ? null : uri.toString(), o1_f.f, r_b);
        s0<Map$Entry<String, String>> s0VarJ = o1_f.c.e().j();
        while (s0VarJ.hasNext()) {
            Map$Entry<String, String> next = s0VarJ.next();
            String key = next.getKey();
            String value = next.getValue();
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            synchronized (d0Var.d) {
                d0Var.d.put(key, value);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = x0.d;
        int i = c0.a;
        b.i.a.c.e3.s sVar = new b.i.a.c.e3.s();
        UUID uuid2 = o1_f.a;
        n nVar = n.a;
        Objects.requireNonNull(uuid2);
        boolean z2 = o1_f.d;
        boolean z3 = o1_f.e;
        int[] iArrQ1 = b.i.a.f.e.o.f.q1(o1_f.g);
        for (int i2 : iArrQ1) {
            boolean z4 = true;
            if (i2 != 2 && i2 != 1) {
                z4 = false;
            }
            b.c.a.a0.d.j(z4);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, nVar, d0Var, map, z2, (int[]) iArrQ1.clone(), z3, sVar, 300000L, null);
        byte[] bArr = o1_f.h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        b.c.a.a0.d.D(defaultDrmSessionManager.m.isEmpty());
        defaultDrmSessionManager.v = 0;
        defaultDrmSessionManager.w = bArrCopyOf;
        return defaultDrmSessionManager;
    }
}
