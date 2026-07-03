package com.google.android.exoplayer2.drm;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p242c.p257e3.C2712n;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaDrmCallbackException extends IOException {
    public final long bytesLoaded;
    public final C2712n dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;

    public MediaDrmCallbackException(C2712n c2712n, Uri uri, Map<String, List<String>> map, long j, Throwable th) {
        super(th);
        this.dataSpec = c2712n;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j;
    }
}
