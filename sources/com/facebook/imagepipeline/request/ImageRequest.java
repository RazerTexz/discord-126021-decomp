package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.cache.common.CacheKey;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p115d.p119d.InterfaceC1681d;
import p007b.p109f.p115d.p121f.C1692a;
import p007b.p109f.p115d.p121f.C1693b;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p169d.C1880a;
import p007b.p109f.p161j.p169d.C1881b;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p169d.EnumC1883d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;
import p007b.p109f.p161j.p182q.InterfaceC2026b;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRequest {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC1681d<ImageRequest, Uri> f19583a = new C10665a();

    /* JADX INFO: renamed from: b */
    public final EnumC10666b f19584b;

    /* JADX INFO: renamed from: c */
    public final Uri f19585c;

    /* JADX INFO: renamed from: d */
    public final int f19586d;

    /* JADX INFO: renamed from: e */
    public File f19587e;

    /* JADX INFO: renamed from: f */
    public final boolean f19588f;

    /* JADX INFO: renamed from: g */
    public final boolean f19589g;

    /* JADX INFO: renamed from: h */
    public final boolean f19590h;

    /* JADX INFO: renamed from: i */
    public final C1881b f19591i;

    /* JADX INFO: renamed from: j */
    public final C1884e f19592j;

    /* JADX INFO: renamed from: k */
    public final C1885f f19593k;

    /* JADX INFO: renamed from: l */
    public final C1880a f19594l;

    /* JADX INFO: renamed from: m */
    public final EnumC1883d f19595m;

    /* JADX INFO: renamed from: n */
    public final EnumC10667c f19596n;

    /* JADX INFO: renamed from: o */
    public final int f19597o;

    /* JADX INFO: renamed from: p */
    public final boolean f19598p;

    /* JADX INFO: renamed from: q */
    public final boolean f19599q;

    /* JADX INFO: renamed from: r */
    public final Boolean f19600r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC2026b f19601s;

    /* JADX INFO: renamed from: t */
    public final InterfaceC1928e f19602t;

    /* JADX INFO: renamed from: u */
    public final int f19603u;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.request.ImageRequest$a */
    public static class C10665a implements InterfaceC1681d<ImageRequest, Uri> {
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.request.ImageRequest$b */
    public enum EnumC10666b {
        SMALL,
        DEFAULT
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.request.ImageRequest$c */
    public enum EnumC10667c {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        EnumC10667c(int i) {
            this.mValue = i;
        }

        /* JADX INFO: renamed from: f */
        public static EnumC10667c m8721f(EnumC10667c enumC10667c, EnumC10667c enumC10667c2) {
            return enumC10667c.mValue > enumC10667c2.mValue ? enumC10667c : enumC10667c2;
        }

        /* JADX INFO: renamed from: g */
        public int m8722g() {
            return this.mValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f19584b = imageRequestBuilder.f19618g;
        Uri uri = imageRequestBuilder.f19612a;
        this.f19585c = uri;
        int i = -1;
        if (uri != null) {
            if (C1717b.m1009e(uri)) {
                i = 0;
            } else if (C1717b.m1008d(uri)) {
                String path = uri.getPath();
                Map<String, String> map = C1692a.f3103a;
                int iLastIndexOf = path.lastIndexOf(46);
                String mimeTypeFromExtension = null;
                String strSubstring = (iLastIndexOf < 0 || iLastIndexOf == path.length() + (-1)) ? null : path.substring(iLastIndexOf + 1);
                if (strSubstring != null) {
                    String lowerCase = strSubstring.toLowerCase(Locale.US);
                    String str = C1693b.f3106c.get(lowerCase);
                    mimeTypeFromExtension = str == null ? C1693b.f3104a.getMimeTypeFromExtension(lowerCase) : str;
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = C1692a.f3103a.get(lowerCase);
                    }
                }
                i = mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/") ? 2 : 3;
            } else if (C1717b.m1007c(uri)) {
                i = 4;
            } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(C1717b.m1005a(uri))) {
                i = 5;
            } else if ("res".equals(C1717b.m1005a(uri))) {
                i = 6;
            } else if ("data".equals(C1717b.m1005a(uri))) {
                i = 7;
            } else if ("android.resource".equals(C1717b.m1005a(uri))) {
                i = 8;
            }
        }
        this.f19586d = i;
        this.f19588f = imageRequestBuilder.f19619h;
        this.f19589g = imageRequestBuilder.f19620i;
        this.f19590h = imageRequestBuilder.f19621j;
        this.f19591i = imageRequestBuilder.f19617f;
        this.f19592j = imageRequestBuilder.f19615d;
        C1885f c1885f = imageRequestBuilder.f19616e;
        this.f19593k = c1885f == null ? C1885f.f3721a : c1885f;
        this.f19594l = imageRequestBuilder.f19626o;
        this.f19595m = imageRequestBuilder.f19622k;
        this.f19596n = imageRequestBuilder.f19613b;
        int i2 = imageRequestBuilder.f19614c;
        this.f19597o = i2;
        this.f19598p = (i2 & 48) == 0 && C1717b.m1009e(imageRequestBuilder.f19612a);
        this.f19599q = (imageRequestBuilder.f19614c & 15) == 0;
        this.f19600r = imageRequestBuilder.f19624m;
        this.f19601s = imageRequestBuilder.f19623l;
        this.f19602t = imageRequestBuilder.f19625n;
        this.f19603u = imageRequestBuilder.f19627p;
    }

    /* JADX INFO: renamed from: a */
    public synchronized File m8719a() {
        if (this.f19587e == null) {
            this.f19587e = new File(this.f19585c.getPath());
        }
        return this.f19587e;
    }

    /* JADX INFO: renamed from: b */
    public boolean m8720b(int i) {
        return (i & this.f19597o) == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (this.f19589g != imageRequest.f19589g || this.f19598p != imageRequest.f19598p || this.f19599q != imageRequest.f19599q || !C1460d.m520g0(this.f19585c, imageRequest.f19585c) || !C1460d.m520g0(this.f19584b, imageRequest.f19584b) || !C1460d.m520g0(this.f19587e, imageRequest.f19587e) || !C1460d.m520g0(this.f19594l, imageRequest.f19594l) || !C1460d.m520g0(this.f19591i, imageRequest.f19591i) || !C1460d.m520g0(this.f19592j, imageRequest.f19592j) || !C1460d.m520g0(this.f19595m, imageRequest.f19595m) || !C1460d.m520g0(this.f19596n, imageRequest.f19596n) || !C1460d.m520g0(Integer.valueOf(this.f19597o), Integer.valueOf(imageRequest.f19597o)) || !C1460d.m520g0(this.f19600r, imageRequest.f19600r)) {
            return false;
        }
        if (!C1460d.m520g0(null, null) || !C1460d.m520g0(this.f19593k, imageRequest.f19593k) || this.f19590h != imageRequest.f19590h) {
            return false;
        }
        InterfaceC2026b interfaceC2026b = this.f19601s;
        CacheKey postprocessorCacheKey = interfaceC2026b != null ? interfaceC2026b.getPostprocessorCacheKey() : null;
        InterfaceC2026b interfaceC2026b2 = imageRequest.f19601s;
        return C1460d.m520g0(postprocessorCacheKey, interfaceC2026b2 != null ? interfaceC2026b2.getPostprocessorCacheKey() : null) && this.f19603u == imageRequest.f19603u;
    }

    public int hashCode() {
        InterfaceC2026b interfaceC2026b = this.f19601s;
        return Arrays.hashCode(new Object[]{this.f19584b, this.f19585c, Boolean.valueOf(this.f19589g), this.f19594l, this.f19595m, this.f19596n, Integer.valueOf(this.f19597o), Boolean.valueOf(this.f19598p), Boolean.valueOf(this.f19599q), this.f19591i, this.f19600r, this.f19592j, this.f19593k, interfaceC2026b != null ? interfaceC2026b.getPostprocessorCacheKey() : null, null, Integer.valueOf(this.f19603u), Boolean.valueOf(this.f19590h)});
    }

    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m971c(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, this.f19585c);
        c1686iM526h2.m971c("cacheChoice", this.f19584b);
        c1686iM526h2.m971c("decodeOptions", this.f19591i);
        c1686iM526h2.m971c("postprocessor", this.f19601s);
        c1686iM526h2.m971c("priority", this.f19595m);
        c1686iM526h2.m971c("resizeOptions", this.f19592j);
        c1686iM526h2.m971c("rotationOptions", this.f19593k);
        c1686iM526h2.m971c("bytesRange", this.f19594l);
        c1686iM526h2.m971c("resizingAllowedOverride", null);
        c1686iM526h2.m970b("progressiveRenderingEnabled", this.f19588f);
        c1686iM526h2.m970b("localThumbnailPreviewsEnabled", this.f19589g);
        c1686iM526h2.m970b("loadThumbnailOnly", this.f19590h);
        c1686iM526h2.m971c("lowestPermittedRequestLevel", this.f19596n);
        c1686iM526h2.m969a("cachesDisabled", this.f19597o);
        c1686iM526h2.m970b("isDiskCacheEnabled", this.f19598p);
        c1686iM526h2.m970b("isMemoryCacheEnabled", this.f19599q);
        c1686iM526h2.m971c("decodePrefetches", this.f19600r);
        c1686iM526h2.m969a("delayMs", this.f19603u);
        return c1686iM526h2.toString();
    }
}
