package b.i.a.g.g;

import android.util.Property;

/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b extends Property<d, Float> {
    public d$b(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(d dVar) {
        return Float.valueOf(dVar.o);
    }

    @Override // android.util.Property
    public void set(d dVar, Float f) {
        dVar.o = f.floatValue();
    }
}
