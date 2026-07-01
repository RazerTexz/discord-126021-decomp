package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Fn;
import b.f.d.d.Objects2;
import b.f.d.f.MediaUtils;
import b.f.d.f.MimeTypeMapWrapper;
import b.f.d.l.UriUtil;
import b.f.j.d.BytesRange;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.d.Priority2;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.k.RequestListener;
import b.f.j.q.Postprocessor;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.cache.common.CacheKey;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRequest {
    public static final Fn<ImageRequest, Uri> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2902b;
    public final Uri c;
    public final int d;
    public File e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final ImageDecodeOptions i;
    public final ResizeOptions j;
    public final RotationOptions k;
    public final BytesRange l;
    public final Priority2 m;
    public final c n;
    public final int o;
    public final boolean p;
    public final boolean q;
    public final Boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Postprocessor f2903s;
    public final RequestListener t;
    public final int u;

    public static class a implements Fn<ImageRequest, Uri> {
    }

    public enum b {
        SMALL,
        DEFAULT
    }

    public enum c {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        c(int i) {
            this.mValue = i;
        }

        public static c f(c cVar, c cVar2) {
            return cVar.mValue > cVar2.mValue ? cVar : cVar2;
        }

        public int g() {
            return this.mValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f2902b = imageRequestBuilder.g;
        Uri uri = imageRequestBuilder.a;
        this.c = uri;
        int i = -1;
        if (uri != null) {
            if (UriUtil.e(uri)) {
                i = 0;
            } else if (UriUtil.d(uri)) {
                String path = uri.getPath();
                Map<String, String> map = MediaUtils.a;
                int iLastIndexOf = path.lastIndexOf(46);
                String mimeTypeFromExtension = null;
                String strSubstring = (iLastIndexOf < 0 || iLastIndexOf == path.length() + (-1)) ? null : path.substring(iLastIndexOf + 1);
                if (strSubstring != null) {
                    String lowerCase = strSubstring.toLowerCase(Locale.US);
                    String str = MimeTypeMapWrapper.c.get(lowerCase);
                    mimeTypeFromExtension = str == null ? MimeTypeMapWrapper.a.getMimeTypeFromExtension(lowerCase) : str;
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = MediaUtils.a.get(lowerCase);
                    }
                }
                i = mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/") ? 2 : 3;
            } else if (UriUtil.c(uri)) {
                i = 4;
            } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(UriUtil.a(uri))) {
                i = 5;
            } else if ("res".equals(UriUtil.a(uri))) {
                i = 6;
            } else if ("data".equals(UriUtil.a(uri))) {
                i = 7;
            } else if ("android.resource".equals(UriUtil.a(uri))) {
                i = 8;
            }
        }
        this.d = i;
        this.f = imageRequestBuilder.h;
        this.g = imageRequestBuilder.i;
        this.h = imageRequestBuilder.j;
        this.i = imageRequestBuilder.f;
        this.j = imageRequestBuilder.d;
        RotationOptions rotationOptions = imageRequestBuilder.e;
        this.k = rotationOptions == null ? RotationOptions.a : rotationOptions;
        this.l = imageRequestBuilder.o;
        this.m = imageRequestBuilder.k;
        this.n = imageRequestBuilder.f2904b;
        int i2 = imageRequestBuilder.c;
        this.o = i2;
        this.p = (i2 & 48) == 0 && UriUtil.e(imageRequestBuilder.a);
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
        if (this.g != imageRequest.g || this.p != imageRequest.p || this.q != imageRequest.q || !AnimatableValueParser.g0(this.c, imageRequest.c) || !AnimatableValueParser.g0(this.f2902b, imageRequest.f2902b) || !AnimatableValueParser.g0(this.e, imageRequest.e) || !AnimatableValueParser.g0(this.l, imageRequest.l) || !AnimatableValueParser.g0(this.i, imageRequest.i) || !AnimatableValueParser.g0(this.j, imageRequest.j) || !AnimatableValueParser.g0(this.m, imageRequest.m) || !AnimatableValueParser.g0(this.n, imageRequest.n) || !AnimatableValueParser.g0(Integer.valueOf(this.o), Integer.valueOf(imageRequest.o)) || !AnimatableValueParser.g0(this.r, imageRequest.r)) {
            return false;
        }
        if (!AnimatableValueParser.g0(null, null) || !AnimatableValueParser.g0(this.k, imageRequest.k) || this.h != imageRequest.h) {
            return false;
        }
        Postprocessor postprocessor = this.f2903s;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.f2903s;
        return AnimatableValueParser.g0(postprocessorCacheKey, postprocessor2 != null ? postprocessor2.getPostprocessorCacheKey() : null) && this.u == imageRequest.u;
    }

    public int hashCode() {
        Postprocessor postprocessor = this.f2903s;
        return Arrays.hashCode(new Object[]{this.f2902b, this.c, Boolean.valueOf(this.g), this.l, this.m, this.n, Integer.valueOf(this.o), Boolean.valueOf(this.p), Boolean.valueOf(this.q), this.i, this.r, this.j, this.k, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, null, Integer.valueOf(this.u), Boolean.valueOf(this.h)});
    }

    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.c(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, this.c);
        objects2H2.c("cacheChoice", this.f2902b);
        objects2H2.c("decodeOptions", this.i);
        objects2H2.c("postprocessor", this.f2903s);
        objects2H2.c("priority", this.m);
        objects2H2.c("resizeOptions", this.j);
        objects2H2.c("rotationOptions", this.k);
        objects2H2.c("bytesRange", this.l);
        objects2H2.c("resizingAllowedOverride", null);
        objects2H2.b("progressiveRenderingEnabled", this.f);
        objects2H2.b("localThumbnailPreviewsEnabled", this.g);
        objects2H2.b("loadThumbnailOnly", this.h);
        objects2H2.c("lowestPermittedRequestLevel", this.n);
        objects2H2.a("cachesDisabled", this.o);
        objects2H2.b("isDiskCacheEnabled", this.p);
        objects2H2.b("isMemoryCacheEnabled", this.q);
        objects2H2.c("decodePrefetches", this.r);
        objects2H2.a("delayMs", this.u);
        return objects2H2.toString();
    }
}
