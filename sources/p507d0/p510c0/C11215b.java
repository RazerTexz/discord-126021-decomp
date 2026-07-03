package p507d0.p510c0;

import java.util.Random;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.c0.b */
/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11215b extends AbstractC11214a {

    /* JADX INFO: renamed from: l */
    public final a f22270l = new a();

    /* JADX INFO: renamed from: d0.c0.b$a */
    /* JADX INFO: compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // p507d0.p510c0.AbstractC11214a
    public Random getImpl() {
        Random random = this.f22270l.get();
        C12238m.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
