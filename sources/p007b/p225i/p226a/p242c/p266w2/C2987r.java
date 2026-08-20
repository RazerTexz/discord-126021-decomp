package p007b.p225i.p226a.p242c.p266w2;

import android.media.UnsupportedSchemeException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p257e3.C2716r;
import p007b.p225i.p226a.p242c.p257e3.C2717s;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4530s0;

/* JADX INFO: renamed from: b.i.a.c.w2.r */
/* JADX INFO: compiled from: DefaultDrmSessionManagerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2987r {

    /* JADX INFO: renamed from: a */
    public final Object f8009a = new Object();

    /* JADX INFO: renamed from: b */
    @GuardedBy("lock")
    public C2831o1.f f8010b;

    /* JADX INFO: renamed from: c */
    @GuardedBy("lock")
    public InterfaceC2990u f8011c;

    @RequiresApi(18)
    /* JADX INFO: renamed from: a */
    public final InterfaceC2990u m3586a(C2831o1.f fVar) {
        C2716r.b bVar = new C2716r.b();
        bVar.f6623b = null;
        Uri uri = fVar.f7291b;
        C2972d0 c2972d0 = new C2972d0(uri == null ? null : uri.toString(), fVar.f7295f, bVar);
        AbstractC4530s0<Map.Entry<String, String>> it = fVar.f7292c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            synchronized (c2972d0.f7985d) {
                c2972d0.f7985d.put(key, value);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = C2997x0.f8024d;
        int i = C2970c0.f7977a;
        C2717s c2717s = new C2717s();
        UUID uuid2 = fVar.f7290a;
        C2983n c2983n = new InterfaceC2966a0.c() { // from class: b.i.a.c.w2.n
            @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0.c
            /* JADX INFO: renamed from: a */
            public final InterfaceC2966a0 mo3581a(UUID uuid3) {
                int i2 = C2970c0.f7977a;
                try {
                    try {
                        return new C2970c0(uuid3);
                    } catch (UnsupportedDrmException unused) {
                        String strValueOf = String.valueOf(uuid3);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
                        sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
                        sb.append(strValueOf);
                        sb.append(".");
                        Log.e("FrameworkMediaDrm", sb.toString());
                        return new C2994y();
                    }
                } catch (UnsupportedSchemeException e) {
                    throw new UnsupportedDrmException(1, e);
                } catch (Exception e2) {
                    throw new UnsupportedDrmException(2, e2);
                }
            }
        };
        Objects.requireNonNull(uuid2);
        boolean z2 = fVar.f7293d;
        boolean z3 = fVar.f7294e;
        int[] iArrM4333q1 = C3404f.m4333q1(fVar.f7296g);
        for (int i2 : iArrM4333q1) {
            boolean z4 = true;
            if (i2 != 2 && i2 != 1) {
                z4 = false;
            }
            C1460d.m531j(z4);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, c2983n, c2972d0, map, z2, (int[]) iArrM4333q1.clone(), z3, c2717s, 300000L, null);
        byte[] bArr = fVar.f7297h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        C1460d.m426D(defaultDrmSessionManager.f19826m.isEmpty());
        defaultDrmSessionManager.f19835v = 0;
        defaultDrmSessionManager.f19836w = bArrCopyOf;
        return defaultDrmSessionManager;
    }
}
