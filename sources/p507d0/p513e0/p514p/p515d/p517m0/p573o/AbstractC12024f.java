package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.f */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12024f implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public final String f24912a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.f$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12024f {

        /* JADX INFO: renamed from: b */
        public static final a f24913b = new a();

        public a() {
            super("must be a member function", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return interfaceC11472x.getDispatchReceiverParameter() != null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.f$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12024f {

        /* JADX INFO: renamed from: b */
        public static final b f24914b = new b();

        public b() {
            super("must be a member or an extension function", null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
        public boolean check(InterfaceC11472x interfaceC11472x) {
            C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
            return (interfaceC11472x.getDispatchReceiverParameter() == null && interfaceC11472x.getExtensionReceiverParameter() == null) ? false : true;
        }
    }

    public AbstractC12024f(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24912a = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return this.f24912a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(InterfaceC11472x interfaceC11472x) {
        return InterfaceC12020b.a.invoke(this, interfaceC11472x);
    }
}
