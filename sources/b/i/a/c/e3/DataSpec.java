package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.ExoPlayerLibraryInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.e3.n, reason: use source file name */
/* JADX INFO: compiled from: DataSpec.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSpec {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f942b;
    public final int c;

    @Nullable
    public final byte[] d;
    public final Map<String, String> e;
    public final long f;
    public final long g;

    @Nullable
    public final String h;
    public final int i;

    @Nullable
    public final Object j;

    /* JADX INFO: renamed from: b.i.a.c.e3.n$b */
    /* JADX INFO: compiled from: DataSpec.java */
    public static final class b {

        @Nullable
        public Uri a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f943b;
        public int c;

        @Nullable
        public byte[] d;
        public Map<String, String> e;
        public long f;
        public long g;

        @Nullable
        public String h;
        public int i;

        @Nullable
        public Object j;

        public b(DataSpec dataSpec, a aVar) {
            this.a = dataSpec.a;
            this.f943b = dataSpec.f942b;
            this.c = dataSpec.c;
            this.d = dataSpec.d;
            this.e = dataSpec.e;
            this.f = dataSpec.f;
            this.g = dataSpec.g;
            this.h = dataSpec.h;
            this.i = dataSpec.i;
            this.j = dataSpec.j;
        }

        public DataSpec a() {
            if (this.a != null) {
                return new DataSpec(this.a, this.f943b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            throw new IllegalStateException("The uri must be set.");
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.datasource");
    }

    public DataSpec(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        boolean z2 = true;
        AnimatableValueParser.j(j + j2 >= 0);
        AnimatableValueParser.j(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z2 = false;
        }
        AnimatableValueParser.j(z2);
        this.a = uri;
        this.f942b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i2;
        this.j = obj;
    }

    public static String b(int i) {
        if (i == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b(this, null);
    }

    public boolean c(int i) {
        return (this.i & i) == i;
    }

    public String toString() {
        String strB = b(this.c);
        String strValueOf = String.valueOf(this.a);
        long j = this.f;
        long j2 = this.g;
        String str = this.h;
        int i = this.i;
        StringBuilder sbS = outline.S(outline.b(str, strValueOf.length() + strB.length() + 70), "DataSpec[", strB, " ", strValueOf);
        sbS.append(", ");
        sbS.append(j);
        sbS.append(", ");
        sbS.append(j2);
        sbS.append(", ");
        sbS.append(str);
        sbS.append(", ");
        sbS.append(i);
        sbS.append("]");
        return sbS.toString();
    }
}
