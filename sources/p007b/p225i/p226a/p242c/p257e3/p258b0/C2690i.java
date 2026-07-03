package p007b.p225i.p226a.p242c.p257e3.p258b0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.TreeSet;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.i */
/* JADX INFO: compiled from: CachedContent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2690i {

    /* JADX INFO: renamed from: a */
    public final int f6471a;

    /* JADX INFO: renamed from: b */
    public final String f6472b;

    /* JADX INFO: renamed from: c */
    public final TreeSet<C2700s> f6473c = new TreeSet<>();

    /* JADX INFO: renamed from: d */
    public final ArrayList<a> f6474d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    public C2695n f6475e;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.i$a */
    /* JADX INFO: compiled from: CachedContent.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final long f6476a;

        /* JADX INFO: renamed from: b */
        public final long f6477b;

        public a(long j, long j2) {
            this.f6476a = j;
            this.f6477b = j2;
        }
    }

    public C2690i(int i, String str, C2695n c2695n) {
        this.f6471a = i;
        this.f6472b = str;
        this.f6475e = c2695n;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    /* JADX INFO: renamed from: a */
    public boolean m2792a(long j, long j2) {
        boolean z2;
        for (int i = 0; i < this.f6474d.size(); i++) {
            a aVar = this.f6474d.get(i);
            long j3 = aVar.f6477b;
            if (j3 != -1) {
                if (j2 != -1) {
                    long j4 = aVar.f6476a;
                    if (j4 <= j && j + j2 <= j4 + j3) {
                        z2 = true;
                    }
                }
                z2 = false;
            } else if (j >= aVar.f6476a) {
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
        if (obj == null || C2690i.class != obj.getClass()) {
            return false;
        }
        C2690i c2690i = (C2690i) obj;
        return this.f6471a == c2690i.f6471a && this.f6472b.equals(c2690i.f6472b) && this.f6473c.equals(c2690i.f6473c) && this.f6475e.equals(c2690i.f6475e);
    }

    public int hashCode() {
        return this.f6475e.hashCode() + C1643a.m863m(this.f6472b, this.f6471a * 31, 31);
    }
}
