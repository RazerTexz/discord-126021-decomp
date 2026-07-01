package b.i.e.o.c;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements Serializable, Comparator<a$b> {
    public a$c(a$a a_a) {
    }

    @Override // java.util.Comparator
    public int compare(a$b a_b, a$b a_b2) {
        return a_b.c - a_b2.c;
    }
}
