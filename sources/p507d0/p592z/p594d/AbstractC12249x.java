package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import p507d0.p513e0.InterfaceC11234g;

/* JADX INFO: renamed from: d0.z.d.x */
/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12249x extends AbstractC12251z implements InterfaceC11234g {
    public AbstractC12249x() {
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KCallable computeReflected() {
        return C12216a0.property1(this);
    }

    @Override // p507d0.p513e0.InterfaceC11234g
    public InterfaceC11234g.a getGetter() {
        return ((InterfaceC11234g) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public AbstractC12249x(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
