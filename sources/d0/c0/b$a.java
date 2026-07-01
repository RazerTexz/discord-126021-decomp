package d0.c0;

import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends ThreadLocal<Random> {
    @Override // java.lang.ThreadLocal
    public Random initialValue() {
        return new Random();
    }
}
