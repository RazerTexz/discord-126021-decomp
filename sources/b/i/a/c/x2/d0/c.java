package b.i.a.c.x2.d0;

import b.i.a.c.x2.o;
import com.discord.api.permission.Permission;
import java.util.Objects;

/* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b.i.a.c.x2.a {
    public c(o oVar, int i, long j, long j2) {
        long j3;
        long j4;
        Objects.requireNonNull(oVar);
        b bVar = new b(oVar);
        c$b c_b = new c$b(oVar, i, null);
        long jD = oVar.d();
        long j5 = oVar.j;
        int i2 = oVar.d;
        if (i2 > 0) {
            j3 = (((long) i2) + ((long) oVar.c)) / 2;
            j4 = 1;
        } else {
            int i3 = oVar.a;
            j3 = ((((i3 != oVar.f1292b || i3 <= 0) ? Permission.SEND_TTS_MESSAGES : i3) * ((long) oVar.g)) * ((long) oVar.h)) / 8;
            j4 = 64;
        }
        super(bVar, c_b, jD, 0L, j5, j, j2, j3 + j4, Math.max(6, oVar.c));
    }
}
