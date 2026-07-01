package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.e.a.k0.n;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.f, reason: use source file name */
/* JADX INFO: compiled from: JavaPropertyInitializerEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface JavaPropertyInitializerEvaluator {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.f$a */
    /* JADX INFO: compiled from: JavaPropertyInitializerEvaluator.kt */
    public static final class a implements JavaPropertyInitializerEvaluator {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.g0.JavaPropertyInitializerEvaluator
        public d0.e0.p.d.m0.k.v.g<?> getInitializerConstant(n nVar, PropertyDescriptor propertyDescriptor) {
            Intrinsics3.checkNotNullParameter(nVar, "field");
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            return null;
        }
    }

    d0.e0.p.d.m0.k.v.g<?> getInitializerConstant(n nVar, PropertyDescriptor propertyDescriptor);
}
