package p507d0.p592z.p594d;

import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.z.d.a */
/* JADX INFO: compiled from: AdaptedFunctionReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12215a implements InterfaceC12234i, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private final String signature;

    public C12215a(int i, Class cls, String str, String str2, int i2) {
        this(i, AbstractC12221d.NO_RECEIVER, cls, str, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12215a)) {
            return false;
        }
        C12215a c12215a = (C12215a) obj;
        return this.isTopLevel == c12215a.isTopLevel && this.arity == c12215a.arity && this.flags == c12215a.flags && C12238m.areEqual(this.receiver, c12215a.receiver) && C12238m.areEqual(this.owner, c12215a.owner) && this.name.equals(c12215a.name) && this.signature.equals(c12215a.signature);
    }

    @Override // p507d0.p592z.p594d.InterfaceC12234i
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? C12216a0.getOrCreateKotlinPackage(cls) : C12216a0.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((C1643a.m863m(this.signature, C1643a.m863m(this.name, (iHashCode + (cls != null ? cls.hashCode() : 0)) * 31, 31), 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return C12216a0.renderLambdaToString(this);
    }

    public C12215a(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i2 & 1) == 1;
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
