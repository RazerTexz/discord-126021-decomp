package b.f.j.p;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c1$a extends p<b.f.j.j.e, b.f.j.j.e> {
    public final boolean c;
    public final b.f.j.s.c d;
    public final x0 e;
    public boolean f;
    public final c0 g;
    public final /* synthetic */ c1 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1$a(c1 c1Var, l<b.f.j.j.e> lVar, x0 x0Var, boolean z2, b.f.j.s.c cVar) {
        super(lVar);
        this.h = c1Var;
        this.f = false;
        this.e = x0Var;
        Objects.requireNonNull(x0Var.e());
        this.c = z2;
        this.d = cVar;
        this.g = new c0(c1Var.a, new c1$a$a(this, c1Var), 100);
        x0Var.f(new c1$a$b(this, c1Var, lVar));
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v10 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // b.f.j.p.b
    public void i(java.lang.Object r10, int r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.c1$a.i(java.lang.Object, int):void");
    }

    public final Map<String, String> n(b.f.j.j.e eVar, b.f.j.d.e eVar2, b.f.j.s.a aVar, String str) {
        String str2;
        long j;
        if (!this.e.o().g(this.e, "ResizeAndRotateProducer")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        eVar.x();
        sb.append(eVar.o);
        sb.append("x");
        eVar.x();
        sb.append(eVar.p);
        String string = sb.toString();
        if (eVar2 != null) {
            str2 = eVar2.a + "x" + eVar2.f566b;
        } else {
            str2 = "Unspecified";
        }
        HashMap map = new HashMap();
        eVar.x();
        map.put("Image format", String.valueOf(eVar.l));
        map.put("Original size", string);
        map.put("Requested size", str2);
        c0 c0Var = this.g;
        synchronized (c0Var) {
            j = c0Var.j - c0Var.i;
        }
        map.put("queueTime", String.valueOf(j));
        map.put("Transcoder id", str);
        map.put("Transcoding result", String.valueOf(aVar));
        return new b.f.d.d.f(map);
    }
}
