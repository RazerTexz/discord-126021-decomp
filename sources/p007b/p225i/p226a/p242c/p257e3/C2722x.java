package p007b.p225i.p226a.p242c.p257e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: renamed from: b.i.a.c.e3.x */
/* JADX INFO: compiled from: SlidingPercentile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2722x {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f6630a = 0;

    /* JADX INFO: renamed from: b */
    public final int f6631b;

    /* JADX INFO: renamed from: f */
    public int f6635f;

    /* JADX INFO: renamed from: g */
    public int f6636g;

    /* JADX INFO: renamed from: h */
    public int f6637h;

    /* JADX INFO: renamed from: d */
    public final b[] f6633d = new b[5];

    /* JADX INFO: renamed from: c */
    public final ArrayList<b> f6632c = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    public int f6634e = -1;

    /* JADX INFO: renamed from: b.i.a.c.e3.x$b */
    /* JADX INFO: compiled from: SlidingPercentile.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public int f6638a;

        /* JADX INFO: renamed from: b */
        public int f6639b;

        /* JADX INFO: renamed from: c */
        public float f6640c;

        public b() {
        }

        public b(a aVar) {
        }
    }

    public C2722x(int i) {
        this.f6631b = i;
    }

    /* JADX INFO: renamed from: a */
    public void m2875a(int i, float f) {
        b bVar;
        if (this.f6634e != 1) {
            Collections.sort(this.f6632c, new Comparator() { // from class: b.i.a.c.e3.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i2 = C2722x.f6630a;
                    return ((C2722x.b) obj).f6638a - ((C2722x.b) obj2).f6638a;
                }
            });
            this.f6634e = 1;
        }
        int i2 = this.f6637h;
        if (i2 > 0) {
            b[] bVarArr = this.f6633d;
            int i3 = i2 - 1;
            this.f6637h = i3;
            bVar = bVarArr[i3];
        } else {
            bVar = new b(null);
        }
        int i4 = this.f6635f;
        this.f6635f = i4 + 1;
        bVar.f6638a = i4;
        bVar.f6639b = i;
        bVar.f6640c = f;
        this.f6632c.add(bVar);
        this.f6636g += i;
        while (true) {
            int i5 = this.f6636g;
            int i6 = this.f6631b;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            b bVar2 = this.f6632c.get(0);
            int i8 = bVar2.f6639b;
            if (i8 <= i7) {
                this.f6636g -= i8;
                this.f6632c.remove(0);
                int i9 = this.f6637h;
                if (i9 < 5) {
                    b[] bVarArr2 = this.f6633d;
                    this.f6637h = i9 + 1;
                    bVarArr2[i9] = bVar2;
                }
            } else {
                bVar2.f6639b = i8 - i7;
                this.f6636g -= i7;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public float m2876b(float f) {
        if (this.f6634e != 0) {
            Collections.sort(this.f6632c, new Comparator() { // from class: b.i.a.c.e3.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i = C2722x.f6630a;
                    return Float.compare(((C2722x.b) obj).f6640c, ((C2722x.b) obj2).f6640c);
                }
            });
            this.f6634e = 0;
        }
        float f2 = f * this.f6636g;
        int i = 0;
        for (int i2 = 0; i2 < this.f6632c.size(); i2++) {
            b bVar = this.f6632c.get(i2);
            i += bVar.f6639b;
            if (i >= f2) {
                return bVar.f6640c;
            }
        }
        if (this.f6632c.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f6632c;
        return arrayList.get(arrayList.size() - 1).f6640c;
    }
}
