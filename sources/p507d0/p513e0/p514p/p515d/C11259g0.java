package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.g0 */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11259g0 extends AbstractC12240o implements Function1<Class<?>, CharSequence> {

    /* JADX INFO: renamed from: j */
    public static final C11259g0 f22360j = new C11259g0();

    public C11259g0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Class<?> cls) {
        C12238m.checkNotNullExpressionValue(cls, "it");
        return C11423b.getDesc(cls);
    }
}
