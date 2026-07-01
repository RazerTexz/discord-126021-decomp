package d0.z.d;

import d0.e0.g$a;
import kotlin.reflect.KCallable;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends z implements d0.e0.g {
    public x() {
    }

    @Override // d0.z.d.d
    public KCallable computeReflected() {
        return a0.property1(this);
    }

    @Override // d0.e0.g
    public g$a getGetter() {
        return ((d0.e0.g) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public x(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
