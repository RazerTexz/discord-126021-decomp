package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.f.d.d.d;
import b.f.d.d.i;
import b.f.j.d.a;
import b.f.j.d.b;
import b.f.j.d.e;
import b.f.j.d.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.cache.common.CacheKey;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRequest {
    public static final d<ImageRequest, Uri> a = new ImageRequest$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRequest$b f2902b;
    public final Uri c;
    public final int d;
    public File e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final b i;
    public final e j;
    public final f k;
    public final a l;
    public final b.f.j.d.d m;
    public final ImageRequest$c n;
    public final int o;
    public final boolean p;
    public final boolean q;
    public final Boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b.f.j.q.b f2903s;
    public final b.f.j.k.e t;
    public final int u;

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f2902b = imageRequestBuilder.g;
        Uri uri = imageRequestBuilder.a;
        this.c = uri;
        int i = -1;
        if (uri != null) {
            if (b.f.d.l.b.e(uri)) {
                i = 0;
            } else if (b.f.d.l.b.d(uri)) {
                String path = uri.getPath();
                Map<String, String> map = b.f.d.f.a.a;
                int iLastIndexOf = path.lastIndexOf(46);
                String mimeTypeFromExtension = null;
                String strSubstring = (iLastIndexOf < 0 || iLastIndexOf == path.length() + (-1)) ? null : path.substring(iLastIndexOf + 1);
                if (strSubstring != null) {
                    String lowerCase = strSubstring.toLowerCase(Locale.US);
                    String str = b.f.d.f.b.c.get(lowerCase);
                    mimeTypeFromExtension = str == null ? b.f.d.f.b.a.getMimeTypeFromExtension(lowerCase) : str;
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = b.f.d.f.a.a.get(lowerCase);
                    }
                }
                i = mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/") ? 2 : 3;
            } else if (b.f.d.l.b.c(uri)) {
                i = 4;
            } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(b.f.d.l.b.a(uri))) {
                i = 5;
            } else if ("res".equals(b.f.d.l.b.a(uri))) {
                i = 6;
            } else if ("data".equals(b.f.d.l.b.a(uri))) {
                i = 7;
            } else if ("android.resource".equals(b.f.d.l.b.a(uri))) {
                i = 8;
            }
        }
        this.d = i;
        this.f = imageRequestBuilder.h;
        this.g = imageRequestBuilder.i;
        this.h = imageRequestBuilder.j;
        this.i = imageRequestBuilder.f;
        this.j = imageRequestBuilder.d;
        f fVar = imageRequestBuilder.e;
        this.k = fVar == null ? f.a : fVar;
        this.l = imageRequestBuilder.o;
        this.m = imageRequestBuilder.k;
        this.n = imageRequestBuilder.f2904b;
        int i2 = imageRequestBuilder.c;
        this.o = i2;
        this.p = (i2 & 48) == 0 && b.f.d.l.b.e(imageRequestBuilder.a);
        this.q = (imageRequestBuilder.c & 15) == 0;
        this.r = imageRequestBuilder.m;
        this.f2903s = imageRequestBuilder.l;
        this.t = imageRequestBuilder.n;
        this.u = imageRequestBuilder.p;
    }

    public synchronized File a() {
        if (this.e == null) {
            this.e = new File(this.c.getPath());
        }
        return this.e;
    }

    public boolean b(int i) {
        return (i & this.o) == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (this.g != imageRequest.g || this.p != imageRequest.p || this.q != imageRequest.q || !b.c.a.a0.d.g0(this.c, imageRequest.c) || !b.c.a.a0.d.g0(this.f2902b, imageRequest.f2902b) || !b.c.a.a0.d.g0(this.e, imageRequest.e) || !b.c.a.a0.d.g0(this.l, imageRequest.l) || !b.c.a.a0.d.g0(this.i, imageRequest.i) || !b.c.a.a0.d.g0(this.j, imageRequest.j) || !b.c.a.a0.d.g0(this.m, imageRequest.m) || !b.c.a.a0.d.g0(this.n, imageRequest.n) || !b.c.a.a0.d.g0(Integer.valueOf(this.o), Integer.valueOf(imageRequest.o)) || !b.c.a.a0.d.g0(this.r, imageRequest.r)) {
            return false;
        }
        if (!b.c.a.a0.d.g0(null, null) || !b.c.a.a0.d.g0(this.k, imageRequest.k) || this.h != imageRequest.h) {
            return false;
        }
        b.f.j.q.b bVar = this.f2903s;
        CacheKey postprocessorCacheKey = bVar != null ? bVar.getPostprocessorCacheKey() : null;
        b.f.j.q.b bVar2 = imageRequest.f2903s;
        return b.c.a.a0.d.g0(postprocessorCacheKey, bVar2 != null ? bVar2.getPostprocessorCacheKey() : null) && this.u == imageRequest.u;
    }

    public int hashCode() {
        b.f.j.q.b bVar = this.f2903s;
        return Arrays.hashCode(new Object[]{this.f2902b, this.c, Boolean.valueOf(this.g), this.l, this.m, this.n, Integer.valueOf(this.o), Boolean.valueOf(this.p), Boolean.valueOf(this.q), this.i, this.r, this.j, this.k, bVar != null ? bVar.getPostprocessorCacheKey() : null, null, Integer.valueOf(this.u), Boolean.valueOf(this.h)});
    }

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c(NotificationCompat$MessagingStyle$Message.KEY_DATA_URI, this.c);
        iVarH2.c("cacheChoice", this.f2902b);
        iVarH2.c("decodeOptions", this.i);
        iVarH2.c("postprocessor", this.f2903s);
        iVarH2.c("priority", this.m);
        iVarH2.c("resizeOptions", this.j);
        iVarH2.c("rotationOptions", this.k);
        iVarH2.c("bytesRange", this.l);
        iVarH2.c("resizingAllowedOverride", null);
        iVarH2.b("progressiveRenderingEnabled", this.f);
        iVarH2.b("localThumbnailPreviewsEnabled", this.g);
        iVarH2.b("loadThumbnailOnly", this.h);
        iVarH2.c("lowestPermittedRequestLevel", this.n);
        iVarH2.a("cachesDisabled", this.o);
        iVarH2.b("isDiskCacheEnabled", this.p);
        iVarH2.b("isMemoryCacheEnabled", this.q);
        iVarH2.c("decodePrefetches", this.r);
        iVarH2.a("delayMs", this.u);
        return iVarH2.toString();
    }
}
