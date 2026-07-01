package d0.c0;

import d0.z.d.m;
import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    public final b$a l = new b$a();

    @Override // d0.c0.a
    public Random getImpl() {
        Random random = this.l.get();
        m.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
