package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.b */
/* JADX INFO: compiled from: ExtensionReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11778b extends AbstractC11777a implements InterfaceC11780d {

    /* JADX INFO: renamed from: c */
    public final InterfaceC11318a f24388c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11778b(InterfaceC11318a interfaceC11318a, AbstractC11913c0 abstractC11913c0, InterfaceC11780d interfaceC11780d) {
        super(abstractC11913c0, interfaceC11780d);
        if (interfaceC11318a == null) {
            m9915a(0);
            throw null;
        }
        if (abstractC11913c0 == null) {
            m9915a(1);
            throw null;
        }
        this.f24388c = interfaceC11318a;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9915a(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "receiverType";
        } else if (i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f24388c + "}";
    }
}
