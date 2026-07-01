package b.a.g;

import java.util.Comparator;

/* JADX INFO: compiled from: ColorCutQuantizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$a<T> implements Comparator<a$c> {
    public static final a$a j = new a$a();

    @Override // java.util.Comparator
    public int compare(a$c a_c, a$c a_c2) {
        return a_c2.b() - a_c.b();
    }
}
