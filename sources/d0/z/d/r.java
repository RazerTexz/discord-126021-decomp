package d0.z.d;

import d0.e0.g$a;
import kotlin.reflect.KCallable;

/* JADX INFO: compiled from: MutablePropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends t implements d0.e0.e {
    public r() {
    }

    @Override // d0.z.d.d
    public KCallable computeReflected() {
        return a0.mutableProperty1(this);
    }

    @Override // d0.e0.g
    public g$a getGetter() {
        return ((d0.e0.e) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public r(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
