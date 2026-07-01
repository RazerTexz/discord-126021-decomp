package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.a, reason: use source file name */
/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BinarySearchSeeker {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1159b;

    @Nullable
    public c c;
    public final int d;

    /* JADX INFO: renamed from: b.i.a.c.x2.a$a */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static class a implements SeekMap {
        public final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1160b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.f1160b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // b.i.a.c.x2.SeekMap
        public boolean c() {
            return true;
        }

        @Override // b.i.a.c.x2.SeekMap
        public SeekMap.a h(long j) {
            return new SeekMap.a(new SeekPoint(j, c.a(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // b.i.a.c.x2.SeekMap
        public long i() {
            return this.f1160b;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$b */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class b implements d {
        @Override // b.i.a.c.x2.BinarySearchSeeker.d
        public long a(long j) {
            return j;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$c */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static class c {
        public final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1161b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.f1161b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = a(j2, j3, j4, j5, j6, j7);
        }

        public static long a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return Util2.i(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$d */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface d {
        long a(long j);
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$e */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class e {
        public static final e a = new e(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1162b;
        public final long c;
        public final long d;

        public e(int i, long j, long j2) {
            this.f1162b = i;
            this.c = j;
            this.d = j2;
        }

        public static e a(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e b(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e c(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.a$f */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface f {
        void a();

        e b(ExtractorInput extractorInput, long j) throws IOException;
    }

    public BinarySearchSeeker(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.f1159b = fVar;
        this.d = i;
        this.a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    public int a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            c cVar = this.c;
            AnimatableValueParser.H(cVar);
            long j = cVar.f;
            long j2 = cVar.g;
            long j3 = cVar.h;
            if (j2 - j <= this.d) {
                c(false, j);
                return d(extractorInput, j, positionHolder);
            }
            if (!f(extractorInput, j3)) {
                return d(extractorInput, j3, positionHolder);
            }
            extractorInput.k();
            e eVarB = this.f1159b.b(extractorInput, cVar.f1161b);
            int i = eVarB.f1162b;
            if (i == -3) {
                c(false, j3);
                return d(extractorInput, j3, positionHolder);
            }
            if (i == -2) {
                long j4 = eVarB.c;
                long j5 = eVarB.d;
                cVar.d = j4;
                cVar.f = j5;
                cVar.h = c.a(cVar.f1161b, j4, cVar.e, j5, cVar.g, cVar.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    f(extractorInput, eVarB.d);
                    c(true, eVarB.d);
                    return d(extractorInput, eVarB.d, positionHolder);
                }
                long j6 = eVarB.c;
                long j7 = eVarB.d;
                cVar.e = j6;
                cVar.g = j7;
                cVar.h = c.a(cVar.f1161b, cVar.d, j6, cVar.f, j7, cVar.c);
            }
        }
    }

    public final boolean b() {
        return this.c != null;
    }

    public final void c(boolean z2, long j) {
        this.c = null;
        this.f1159b.a();
    }

    public final int d(ExtractorInput extractorInput, long j, PositionHolder positionHolder) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.a = j;
        return 1;
    }

    public final void e(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.a != j) {
            long jA = this.a.a.a(j);
            a aVar = this.a;
            this.c = new c(j, jA, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g);
        }
    }

    public final boolean f(ExtractorInput extractorInput, long j) throws IOException {
        long position = j - extractorInput.getPosition();
        if (position < 0 || position > Permission.USE_EXTERNAL_EMOJIS) {
            return false;
        }
        extractorInput.l((int) position);
        return true;
    }
}
