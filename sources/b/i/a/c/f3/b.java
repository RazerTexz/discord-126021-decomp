package b.i.a.c.f3;

import android.os.Handler$Callback;
import android.os.Message;
import java.util.Iterator;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Handler$Callback {
    public final /* synthetic */ p j;

    public /* synthetic */ b(p pVar) {
        this.j = pVar;
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
    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        p pVar = this.j;
        Iterator it = pVar.d.iterator();
        while (it.hasNext()) {
            p$c p_c = (p$c) it.next();
            p$b<T> p_b = pVar.c;
            if (!p_c.d && p_c.c) {
                n nVarB = p_c.f974b.b();
                p_c.f974b = new n$b();
                p_c.c = false;
                p_b.a(p_c.a, nVarB);
            }
            if (pVar.f973b.e(0)) {
                return true;
            }
        }
        return true;
    }
}
