package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* JADX INFO: renamed from: d0.z.d.p, reason: use source file name */
/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KProperty5 {
    public MutablePropertyReference0() {
    }

    @Override // d0.z.d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.mutableProperty0(this);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return ((KProperty5) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty6
    public KProperty6.Getter getGetter() {
        return ((KProperty5) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KProperty5
    public KProperty5.Setter getSetter() {
        return ((KProperty5) getReflected()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
