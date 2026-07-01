package d0.z.d;

import d0.e0.KProperty3;
import kotlin.reflect.KCallable;

/* JADX INFO: renamed from: d0.z.d.x, reason: use source file name */
/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty3 {
    public PropertyReference1() {
    }

    @Override // d0.z.d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.property1(this);
    }

    @Override // d0.e0.KProperty3
    public KProperty3.a getGetter() {
        return ((KProperty3) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
