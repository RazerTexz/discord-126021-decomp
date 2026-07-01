package b.i.a.c.w2;

import android.media.UnsupportedSchemeException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.C;
import b.i.a.c.MediaItem2;
import b.i.a.c.e3.DefaultHttpDataSource;
import b.i.a.c.e3.DefaultLoadErrorHandlingPolicy;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.b.b.UnmodifiableIterator;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: renamed from: b.i.a.c.w2.r, reason: use source file name */
/* JADX INFO: compiled from: DefaultDrmSessionManagerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDrmSessionManagerProvider {
    public final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    public MediaItem2.f f1155b;

    @GuardedBy("lock")
    public DrmSessionManager2 c;

    @RequiresApi(18)
    public final DrmSessionManager2 a(MediaItem2.f fVar) {
        DefaultHttpDataSource.b bVar = new DefaultHttpDataSource.b();
        bVar.f951b = null;
        Uri uri = fVar.f1036b;
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri == null ? null : uri.toString(), fVar.f, bVar);
        UnmodifiableIterator<Map.Entry<String, String>> it = fVar.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            synchronized (httpMediaDrmCallback.d) {
                httpMediaDrmCallback.d.put(key, value);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = C.d;
        int i = FrameworkMediaDrm.a;
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        UUID uuid2 = fVar.a;
        n nVar = new ExoMediaDrm.c() { // from class: b.i.a.c.w2.n
            @Override // b.i.a.c.w2.ExoMediaDrm.c
            public final ExoMediaDrm a(UUID uuid3) {
                int i2 = FrameworkMediaDrm.a;
                try {
                    try {
                        return new FrameworkMediaDrm(uuid3);
                    } catch (UnsupportedDrmException unused) {
                        String strValueOf = String.valueOf(uuid3);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
                        sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
                        sb.append(strValueOf);
                        sb.append(".");
                        Log.e("FrameworkMediaDrm", sb.toString());
                        return new DummyExoMediaDrm();
                    }
                } catch (UnsupportedSchemeException e) {
                    throw new UnsupportedDrmException(1, e);
                } catch (Exception e2) {
                    throw new UnsupportedDrmException(2, e2);
                }
            }
        };
        Objects.requireNonNull(uuid2);
        boolean z2 = fVar.d;
        boolean z3 = fVar.e;
        int[] iArrQ1 = b.i.a.f.e.o.f.q1(fVar.g);
        for (int i2 : iArrQ1) {
            boolean z4 = true;
            if (i2 != 2 && i2 != 1) {
                z4 = false;
            }
            AnimatableValueParser.j(z4);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, nVar, httpMediaDrmCallback, map, z2, (int[]) iArrQ1.clone(), z3, defaultLoadErrorHandlingPolicy, 300000L, null);
        byte[] bArr = fVar.h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        AnimatableValueParser.D(defaultDrmSessionManager.m.isEmpty());
        defaultDrmSessionManager.v = 0;
        defaultDrmSessionManager.w = bArrCopyOf;
        return defaultDrmSessionManager;
    }
}
