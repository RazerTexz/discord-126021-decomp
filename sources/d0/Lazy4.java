package d0;

import kotlin.Lazy;

/* JADX INFO: renamed from: d0.h, reason: use source file name */
/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Lazy4 extends LazyJVM {
    public static final <T> Lazy<T> lazyOf(T t) {
        return new Lazy3(t);
    }
}
