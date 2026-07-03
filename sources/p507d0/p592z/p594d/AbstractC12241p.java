package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: renamed from: d0.z.d.p */
/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12241p extends AbstractC12245t implements KMutableProperty0 {
    public AbstractC12241p() {
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KCallable computeReflected() {
        return C12216a0.mutableProperty0(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public AbstractC12241p(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty0
    public KProperty0.Getter getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public KMutableProperty0.Setter getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    public AbstractC12241p(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
