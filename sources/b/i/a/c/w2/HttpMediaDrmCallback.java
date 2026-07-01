package b.i.a.c.w2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.e3.DataSourceInputStream;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.e3.DefaultHttpDataSource;
import b.i.a.c.e3.HttpDataSource;
import b.i.a.c.e3.StatsDataSource;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.ExoMediaDrm;
import b.i.b.b.RegularImmutableMap;
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

/* JADX INFO: renamed from: b.i.a.c.w2.d0, reason: use source file name */
/* JADX INFO: compiled from: HttpMediaDrmCallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    public final HttpDataSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1152b;
    public final boolean c;
    public final Map<String, String> d;

    public HttpMediaDrmCallback(@Nullable String str, boolean z2, HttpDataSource httpDataSource) {
        AnimatableValueParser.j((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.a = httpDataSource;
        this.f1152b = str;
        this.c = z2;
        this.d = new HashMap();
    }

    public static byte[] b(HttpDataSource httpDataSource, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        Map<String, List<String>> map2;
        List<String> list;
        StatsDataSource statsDataSource = new StatsDataSource(((DefaultHttpDataSource.b) httpDataSource).a());
        Collections.emptyMap();
        Uri uri = Uri.parse(str);
        if (uri == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        DataSpec dataSpec = new DataSpec(uri, 0L, 2, bArr, map, 0L, -1L, null, 1, null);
        DataSpec dataSpecA = dataSpec;
        int i = 0;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecA);
                try {
                    try {
                        byte[] bArrK = Util2.K(dataSourceInputStream);
                        int i2 = Util2.a;
                        try {
                            dataSourceInputStream.close();
                        } catch (IOException unused) {
                        }
                        return bArrK;
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
                        DataSpec.b bVarA = dataSpecA.a();
                        bVarA.a = Uri.parse(str2);
                        dataSpecA = bVarA.a();
                        int i4 = Util2.a;
                        try {
                            dataSourceInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    int i5 = Util2.a;
                    try {
                        dataSourceInputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Uri uri2 = statsDataSource.c;
                Objects.requireNonNull(uri2);
                throw new MediaDrmCallbackException(dataSpec, uri2, statsDataSource.j(), statsDataSource.f956b, e2);
            }
        }
    }

    public byte[] a(UUID uuid, ExoMediaDrm.a aVar) throws MediaDrmCallbackException {
        String str;
        String str2 = aVar.f1148b;
        if (this.c || TextUtils.isEmpty(str2)) {
            str2 = this.f1152b;
        }
        if (TextUtils.isEmpty(str2)) {
            Map mapEmptyMap = Collections.emptyMap();
            Uri uri = Uri.EMPTY;
            if (uri != null) {
                throw new MediaDrmCallbackException(new DataSpec(uri, 0L, 1, null, mapEmptyMap, 0L, -1L, null, 0, null), Uri.EMPTY, RegularImmutableMap.m, 0L, new IllegalStateException("No license URL"));
            }
            throw new IllegalStateException("The uri must be set.");
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.e;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.c.equals(uuid) ? RestAPIBuilder.CONTENT_TYPE_JSON : "application/octet-stream";
        }
        map.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            map.putAll(this.d);
        }
        return b(this.a, str2, aVar.a, map);
    }

    public byte[] c(UUID uuid, ExoMediaDrm.d dVar) throws MediaDrmCallbackException {
        String str = dVar.f1149b;
        String strL = Util2.l(dVar.a);
        return b(this.a, outline.k(strL.length() + outline.b(str, 15), str, "&signedRequest=", strL), null, Collections.emptyMap());
    }
}
