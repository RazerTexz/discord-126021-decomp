package b.o.a.n.t;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.a.m.e;

/* JADX INFO: compiled from: Angles.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f1940b;

    @VisibleForTesting
    public int c = 0;

    @VisibleForTesting
    public int d = 0;

    @VisibleForTesting
    public int e = 0;

    public final int a(@NonNull b bVar, @NonNull b bVar2) {
        if (bVar == bVar2) {
            return 0;
        }
        b bVar3 = b.BASE;
        if (bVar2 == bVar3) {
            return ((360 - a(bVar2, bVar)) + 360) % 360;
        }
        if (bVar != bVar3) {
            return ((a(bVar3, bVar2) - a(bVar3, bVar)) + 360) % 360;
        }
        int iOrdinal = bVar2.ordinal();
        if (iOrdinal == 1) {
            return ((360 - this.c) + 360) % 360;
        }
        if (iOrdinal == 2) {
            return ((360 - this.d) + 360) % 360;
        }
        if (iOrdinal == 3) {
            return (this.e + 360) % 360;
        }
        throw new RuntimeException("Unknown reference: " + bVar2);
    }

    public boolean b(@NonNull b bVar, @NonNull b bVar2) {
        return c(bVar, bVar2, 1) % 180 != 0;
    }

    public int c(@NonNull b bVar, @NonNull b bVar2, @NonNull int i) {
        int iA = a(bVar, bVar2);
        return (i == 2 && this.f1940b == e.FRONT) ? ((360 - iA) + 360) % 360 : iA;
    }

    public final void d() {
        a.a(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.c), "displayOffset:", Integer.valueOf(this.d), "deviceOrientation:", Integer.valueOf(this.e));
    }

    public final void e(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalStateException(b.d.b.a.a.q("This value is not sanitized: ", i));
        }
    }

    public void f(@NonNull e eVar, int i) {
        e(i);
        this.f1940b = eVar;
        this.c = i;
        if (eVar == e.FRONT) {
            this.c = ((360 - i) + 360) % 360;
        }
        d();
    }
}
