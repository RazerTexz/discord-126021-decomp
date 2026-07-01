package b.i.a.c.x2;

import androidx.annotation.Nullable;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final a$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a$f f1159b;

    @Nullable
    public a$c c;
    public final int d;

    public a(a$d a_d, a$f a_f, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.f1159b = a_f;
        this.d = i;
        this.a = new a$a(a_d, j, j2, j3, j4, j5, j6);
    }

    public int a(i iVar, s sVar) throws IOException {
        while (true) {
            a$c a_c = this.c;
            b.c.a.a0.d.H(a_c);
            long j = a_c.f;
            long j2 = a_c.g;
            long j3 = a_c.h;
            if (j2 - j <= this.d) {
                c(false, j);
                return d(iVar, j, sVar);
            }
            if (!f(iVar, j3)) {
                return d(iVar, j3, sVar);
            }
            iVar.k();
            a$e a_eB = this.f1159b.b(iVar, a_c.f1161b);
            int i = a_eB.f1162b;
            if (i == -3) {
                c(false, j3);
                return d(iVar, j3, sVar);
            }
            if (i == -2) {
                long j4 = a_eB.c;
                long j5 = a_eB.d;
                a_c.d = j4;
                a_c.f = j5;
                a_c.h = a$c.a(a_c.f1161b, j4, a_c.e, j5, a_c.g, a_c.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    f(iVar, a_eB.d);
                    c(true, a_eB.d);
                    return d(iVar, a_eB.d, sVar);
                }
                long j6 = a_eB.c;
                long j7 = a_eB.d;
                a_c.e = j6;
                a_c.g = j7;
                a_c.h = a$c.a(a_c.f1161b, a_c.d, j6, a_c.f, j7, a_c.c);
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

    public final int d(i iVar, long j, s sVar) {
        if (j == iVar.getPosition()) {
            return 0;
        }
        sVar.a = j;
        return 1;
    }

    public final void e(long j) {
        a$c a_c = this.c;
        if (a_c == null || a_c.a != j) {
            long jA = this.a.a.a(j);
            a$a a_a = this.a;
            this.c = new a$c(j, jA, a_a.c, a_a.d, a_a.e, a_a.f, a_a.g);
        }
    }

    public final boolean f(i iVar, long j) throws IOException {
        long position = j - iVar.getPosition();
        if (position < 0 || position > Permission.USE_EXTERNAL_EMOJIS) {
            return false;
        }
        iVar.l((int) position);
        return true;
    }
}
