package b.c.a.a0;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: ArrayBuilders.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a {
    public final /* synthetic */ Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f330b;
    public final /* synthetic */ Object c;

    public d$a(Class cls, int i, Object obj) {
        this.a = cls;
        this.f330b = i;
        this.c = obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!b.g.a.c.i0.d.o(obj, this.a) || Array.getLength(obj) != this.f330b) {
            return false;
        }
        for (int i = 0; i < this.f330b; i++) {
            Object obj2 = Array.get(this.c, i);
            Object obj3 = Array.get(obj, i);
            if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                return false;
            }
        }
        return true;
    }
}
