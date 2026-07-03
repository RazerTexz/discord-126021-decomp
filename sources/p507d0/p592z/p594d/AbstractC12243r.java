package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import p507d0.p513e0.InterfaceC11232e;
import p507d0.p513e0.InterfaceC11234g;

/* JADX INFO: renamed from: d0.z.d.r */
/* JADX INFO: compiled from: MutablePropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12243r extends AbstractC12245t implements InterfaceC11232e {
    public AbstractC12243r() {
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KCallable computeReflected() {
        return C12216a0.mutableProperty1(this);
    }

    @Override // p507d0.p513e0.InterfaceC11234g
    public InterfaceC11234g.a getGetter() {
        return ((InterfaceC11232e) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public AbstractC12243r(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
