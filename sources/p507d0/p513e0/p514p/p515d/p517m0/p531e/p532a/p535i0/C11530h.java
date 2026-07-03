package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11552s;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.h */
/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11530h implements InterfaceC11533k {

    /* JADX INFO: renamed from: a */
    public final C11529g f23315a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11450m f23316b;

    /* JADX INFO: renamed from: c */
    public final int f23317c;

    /* JADX INFO: renamed from: d */
    public final Map<InterfaceC11592y, Integer> f23318d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC11899i<InterfaceC11592y, C11552s> f23319e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.h$a */
    /* JADX INFO: compiled from: resolvers.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11592y, C11552s> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11552s invoke(InterfaceC11592y interfaceC11592y) {
            C12238m.checkNotNullParameter(interfaceC11592y, "typeParameter");
            Integer num = (Integer) C11530h.this.f23318d.get(interfaceC11592y);
            if (num == null) {
                return null;
            }
            C11530h c11530h = C11530h.this;
            return new C11552s(C11523a.copyWithNewDefaultTypeQualifiers(C11523a.child(c11530h.f23315a, c11530h), c11530h.f23316b.getAnnotations()), interfaceC11592y, c11530h.f23317c + num.intValue(), c11530h.f23316b);
        }
    }

    public C11530h(C11529g c11529g, InterfaceC11450m interfaceC11450m, InterfaceC11593z interfaceC11593z, int i) {
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11593z, "typeParameterOwner");
        this.f23315a = c11529g;
        this.f23316b = interfaceC11450m;
        this.f23317c = i;
        this.f23318d = C12033a.mapToIndex(interfaceC11593z.getTypeParameters());
        this.f23319e = c11529g.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.InterfaceC11533k
    public InterfaceC11477z0 resolveTypeParameter(InterfaceC11592y interfaceC11592y) {
        C12238m.checkNotNullParameter(interfaceC11592y, "javaTypeParameter");
        C11552s c11552sInvoke = this.f23319e.invoke(interfaceC11592y);
        return c11552sInvoke == null ? this.f23315a.getTypeParameterResolver().resolveTypeParameter(interfaceC11592y) : c11552sInvoke;
    }
}
