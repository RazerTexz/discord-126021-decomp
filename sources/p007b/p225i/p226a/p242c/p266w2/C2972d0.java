package p007b.p225i.p226a.p242c.p266w2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.discord.restapi.RestAPIBuilder;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p257e3.C2711m;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p257e3.C2716r;
import p007b.p225i.p226a.p242c.p257e3.C2723y;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2718t;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2966a0;
import p007b.p225i.p355b.p357b.C4510i0;

/* JADX INFO: renamed from: b.i.a.c.w2.d0 */
/* JADX INFO: compiled from: HttpMediaDrmCallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2972d0 implements InterfaceC2974e0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2718t f7982a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f7983b;

    /* JADX INFO: renamed from: c */
    public final boolean f7984c;

    /* JADX INFO: renamed from: d */
    public final Map<String, String> f7985d;

    public C2972d0(@Nullable String str, boolean z2, InterfaceC2718t interfaceC2718t) {
        C1460d.m531j((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.f7982a = interfaceC2718t;
        this.f7983b = str;
        this.f7984c = z2;
        this.f7985d = new HashMap();
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m3583b(InterfaceC2718t interfaceC2718t, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        Map<String, List<String>> map2;
        List<String> list;
        C2723y c2723y = new C2723y(((C2716r.b) interfaceC2718t).mo234a());
        Collections.emptyMap();
        Uri uri = Uri.parse(str);
        if (uri == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        C2712n c2712n = new C2712n(uri, 0L, 2, bArr, map, 0L, -1L, null, 1, null);
        C2712n c2712nM2857a = c2712n;
        int i = 0;
        while (true) {
            try {
                C2711m c2711m = new C2711m(c2723y, c2712nM2857a);
                try {
                    try {
                        byte[] bArrM2990K = C2738e0.m2990K(c2711m);
                        int i2 = C2738e0.f6708a;
                        try {
                            c2711m.close();
                        } catch (IOException unused) {
                        }
                        return bArrM2990K;
                    } catch (HttpDataSource$InvalidResponseCodeException e) {
                        int i3 = e.responseCode;
                        String str2 = null;
                        if (((i3 == 307 || i3 == 308) && i < 5) && (map2 = e.headerFields) != null && (list = map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = list.get(0);
                        }
                        if (str2 == null) {
                            throw e;
                        }
                        i++;
                        C2712n.b bVarM2855a = c2712nM2857a.m2855a();
                        bVarM2855a.f6552a = Uri.parse(str2);
                        c2712nM2857a = bVarM2855a.m2857a();
                        int i4 = C2738e0.f6708a;
                        try {
                            c2711m.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    int i5 = C2738e0.f6708a;
                    try {
                        c2711m.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Uri uri2 = c2723y.f6643c;
                Objects.requireNonNull(uri2);
                throw new MediaDrmCallbackException(c2712n, uri2, c2723y.mo2588j(), c2723y.f6642b, e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public byte[] m3584a(UUID uuid, InterfaceC2966a0.a aVar) throws MediaDrmCallbackException {
        String str;
        String str2 = aVar.f7968b;
        if (this.f7984c || TextUtils.isEmpty(str2)) {
            str2 = this.f7983b;
        }
        if (TextUtils.isEmpty(str2)) {
            Map mapEmptyMap = Collections.emptyMap();
            Uri uri = Uri.EMPTY;
            if (uri != null) {
                throw new MediaDrmCallbackException(new C2712n(uri, 0L, 1, null, mapEmptyMap, 0L, -1L, null, 0, null), Uri.EMPTY, C4510i0.f12015m, 0L, new IllegalStateException("No license URL"));
            }
            throw new IllegalStateException("The uri must be set.");
        }
        HashMap map = new HashMap();
        UUID uuid2 = C2997x0.f8025e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C2997x0.f8023c.equals(uuid) ? RestAPIBuilder.CONTENT_TYPE_JSON : "application/octet-stream";
        }
        map.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f7985d) {
            map.putAll(this.f7985d);
        }
        return m3583b(this.f7982a, str2, aVar.f7967a, map);
    }

    /* JADX INFO: renamed from: c */
    public byte[] m3585c(UUID uuid, InterfaceC2966a0.d dVar) throws MediaDrmCallbackException {
        String str = dVar.f7970b;
        String strM3004l = C2738e0.m3004l(dVar.f7969a);
        return m3583b(this.f7982a, C1643a.m859k(strM3004l.length() + C1643a.m841b(str, 15), str, "&signedRequest=", strM3004l), null, Collections.emptyMap());
    }
}
