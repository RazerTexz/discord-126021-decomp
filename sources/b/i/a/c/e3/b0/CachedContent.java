package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.i, reason: use source file name */
/* JADX INFO: compiled from: CachedContent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CachedContent {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f930b;
    public final TreeSet<SimpleCacheSpan> c = new TreeSet<>();
    public final ArrayList<a> d = new ArrayList<>();
    public DefaultContentMetadata e;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.i$a */
    /* JADX INFO: compiled from: CachedContent.java */
    public static final class a {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f931b;

        public a(long j, long j2) {
            this.a = j;
            this.f931b = j2;
        }
    }

    public CachedContent(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.a = i;
        this.f930b = str;
        this.e = defaultContentMetadata;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public boolean a(long j, long j2) {
        boolean z2;
        for (int i = 0; i < this.d.size(); i++) {
            a aVar = this.d.get(i);
            long j3 = aVar.f931b;
            if (j3 != -1) {
                if (j2 != -1) {
                    long j4 = aVar.a;
                    if (j4 <= j && j + j2 <= j4 + j3) {
                        z2 = true;
                    }
                }
                z2 = false;
            } else if (j >= aVar.a) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        return this.a == cachedContent.a && this.f930b.equals(cachedContent.f930b) && this.c.equals(cachedContent.c) && this.e.equals(cachedContent.e);
    }

    public int hashCode() {
        return this.e.hashCode() + outline.m(this.f930b, this.a * 31, 31);
    }
}
