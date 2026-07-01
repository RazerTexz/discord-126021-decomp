package b.i.a.c.e3;

import b.i.a.c.e3.SlidingPercentile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: renamed from: b.i.a.c.e3.x, reason: use source file name */
/* JADX INFO: compiled from: SlidingPercentile.java */
/* JADX INFO: loaded from: classes3.dex */
public class SlidingPercentile {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f954b;
    public int f;
    public int g;
    public int h;
    public final b[] d = new b[5];
    public final ArrayList<b> c = new ArrayList<>();
    public int e = -1;

    /* JADX INFO: renamed from: b.i.a.c.e3.x$b */
    /* JADX INFO: compiled from: SlidingPercentile.java */
    public static class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f955b;
        public float c;

        public b() {
        }

        public b(a aVar) {
        }
    }

    public SlidingPercentile(int i) {
        this.f954b = i;
    }

    public void a(int i, float f) {
        b bVar;
        if (this.e != 1) {
            Collections.sort(this.c, new Comparator() { // from class: b.i.a.c.e3.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i2 = SlidingPercentile.a;
                    return ((SlidingPercentile.b) obj).a - ((SlidingPercentile.b) obj2).a;
                }
            });
            this.e = 1;
        }
        int i2 = this.h;
        if (i2 > 0) {
            b[] bVarArr = this.d;
            int i3 = i2 - 1;
            this.h = i3;
            bVar = bVarArr[i3];
        } else {
            bVar = new b(null);
        }
        int i4 = this.f;
        this.f = i4 + 1;
        bVar.a = i4;
        bVar.f955b = i;
        bVar.c = f;
        this.c.add(bVar);
        this.g += i;
        while (true) {
            int i5 = this.g;
            int i6 = this.f954b;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            b bVar2 = this.c.get(0);
            int i8 = bVar2.f955b;
            if (i8 <= i7) {
                this.g -= i8;
                this.c.remove(0);
                int i9 = this.h;
                if (i9 < 5) {
                    b[] bVarArr2 = this.d;
                    this.h = i9 + 1;
                    bVarArr2[i9] = bVar2;
                }
            } else {
                bVar2.f955b = i8 - i7;
                this.g -= i7;
            }
        }
    }

    public float b(float f) {
        if (this.e != 0) {
            Collections.sort(this.c, new Comparator() { // from class: b.i.a.c.e3.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i = SlidingPercentile.a;
                    return Float.compare(((SlidingPercentile.b) obj).c, ((SlidingPercentile.b) obj2).c);
                }
            });
            this.e = 0;
        }
        float f2 = f * this.g;
        int i = 0;
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            b bVar = this.c.get(i2);
            i += bVar.f955b;
            if (i >= f2) {
                return bVar.c;
            }
        }
        if (this.c.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.c;
        return arrayList.get(arrayList.size() - 1).c;
    }
}
