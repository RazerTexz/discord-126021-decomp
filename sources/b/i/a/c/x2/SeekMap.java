package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.i.a.c.x2.t, reason: use source file name */
/* JADX INFO: compiled from: SeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public interface SeekMap {

    /* JADX INFO: renamed from: b.i.a.c.x2.t$b */
    /* JADX INFO: compiled from: SeekMap.java */
    public static class b implements SeekMap {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f1297b;

        public b(long j, long j2) {
            this.a = j;
            this.f1297b = new a(j2 == 0 ? SeekPoint.a : new SeekPoint(0L, j2));
        }

        @Override // b.i.a.c.x2.SeekMap
        public boolean c() {
            return false;
        }

        @Override // b.i.a.c.x2.SeekMap
        public a h(long j) {
            return this.f1297b;
        }

        @Override // b.i.a.c.x2.SeekMap
        public long i() {
            return this.a;
        }
    }

    boolean c();

    a h(long j);

    long i();

    /* JADX INFO: renamed from: b.i.a.c.x2.t$a */
    /* JADX INFO: compiled from: SeekMap.java */
    public static final class a {
        public final SeekPoint a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SeekPoint f1296b;

        public a(SeekPoint seekPoint) {
            this.a = seekPoint;
            this.f1296b = seekPoint;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.f1296b.equals(aVar.f1296b);
        }

        public int hashCode() {
            return this.f1296b.hashCode() + (this.a.hashCode() * 31);
        }

        public String toString() {
            String strJ;
            String strValueOf = String.valueOf(this.a);
            if (this.a.equals(this.f1296b)) {
                strJ = "";
            } else {
                String strValueOf2 = String.valueOf(this.f1296b);
                strJ = outline.j(strValueOf2.length() + 2, ", ", strValueOf2);
            }
            return outline.l(outline.b(strJ, strValueOf.length() + 2), "[", strValueOf, strJ, "]");
        }

        public a(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.a = seekPoint;
            this.f1296b = seekPoint2;
        }
    }
}
