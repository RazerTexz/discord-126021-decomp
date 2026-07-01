package d0.z.d;

import d0.e0.KProperty2;
import d0.e0.KProperty3;
import kotlin.reflect.KCallable;

/* JADX INFO: renamed from: d0.z.d.r, reason: use source file name */
/* JADX INFO: compiled from: MutablePropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KProperty2 {
    public MutablePropertyReference1() {
    }

    @Override // d0.z.d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.mutableProperty1(this);
    }

    @Override // d0.e0.KProperty3
    public KProperty3.a getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
