package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b;
import p007b.p225i.p226a.p288f.p333j.p334b.C4265b;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.x0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC4317x0 extends BinderC3925b implements InterfaceC4315w0 {
    public AbstractBinderC4317x0() {
        super("com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b
    /* JADX INFO: renamed from: c */
    public final boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        BinderC4304r binderC4304r = (BinderC4304r) this;
        binderC4304r.f11430d.m4045b(binderC4304r.f11429c.f9430c);
        C3301k<C4265b> c3301k = binderC4304r.f11405b;
        if (c3301k != null) {
            c3301k.m4106a(BinderC4272b0.f11404a);
        }
        return true;
    }
}
