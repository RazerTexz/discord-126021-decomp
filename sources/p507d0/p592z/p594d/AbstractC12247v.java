package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* JADX INFO: renamed from: d0.z.d.v */
/* JADX INFO: compiled from: PropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12247v extends AbstractC12251z implements KProperty0 {
    public AbstractC12247v() {
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KCallable computeReflected() {
        return C12216a0.property0(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public AbstractC12247v(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty0
    public KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    public AbstractC12247v(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
