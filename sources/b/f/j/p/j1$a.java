package b.f.j.p;

/* JADX INFO: compiled from: ThumbnailBranchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1$a extends p<b.f.j.j.e, b.f.j.j.e> {
    public final x0 c;
    public final int d;
    public final b.f.j.d.e e;
    public final /* synthetic */ j1 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1$a(j1 j1Var, l<b.f.j.j.e> lVar, x0 x0Var, int i) {
        super(lVar);
        this.f = j1Var;
        this.c = x0Var;
        this.d = i;
        this.e = x0Var.e().j;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.f.j.p.p, b.f.j.p.b
    public void h(Throwable th) {
        if (this.f.c(this.d + 1, this.f632b, this.c)) {
            return;
        }
        this.f632b.c(th);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        b.f.j.j.e eVar = (b.f.j.j.e) obj;
        if (eVar != null && (b.f(i) || b.c.a.a0.d.T0(eVar, this.e))) {
            this.f632b.b(eVar, i);
            return;
        }
        if (b.e(i)) {
            if (eVar != null) {
                eVar.close();
            }
            if (this.f.c(this.d + 1, this.f632b, this.c)) {
                return;
            }
            this.f632b.b(null, 1);
        }
    }
}
