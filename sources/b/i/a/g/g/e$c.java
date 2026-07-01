package b.i.a.g.g;

import android.util.Property;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$c extends Property<e, Float> {
    public e$c(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(e eVar) {
        return Float.valueOf(eVar.getGrowFraction());
    }

    @Override // android.util.Property
    public void set(e eVar, Float f) {
        eVar.setGrowFraction(f.floatValue());
    }
}
