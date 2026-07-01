package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.f.a0.a$c;
import d0.e0.p.d.m0.f.a0.a$d;
import d0.e0.p.d.m0.i.g$f;
import java.util.Objects;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c extends e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f3195b;
    public final d0.e0.p.d.m0.f.n c;
    public final a$d d;
    public final d0.e0.p.d.m0.f.z.c e;
    public final d0.e0.p.d.m0.f.z.g f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:27:0x0109  */
    public e$c(n0 n0Var, d0.e0.p.d.m0.f.n nVar, a$d a_d, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar) {
        String string;
        String strK;
        super(null);
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(a_d, "signature");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        this.f3195b = n0Var;
        this.c = nVar;
        this.d = a_d;
        this.e = cVar;
        this.f = gVar;
        if (a_d.hasGetter()) {
            StringBuilder sb = new StringBuilder();
            a$c getter = a_d.getGetter();
            d0.z.d.m.checkNotNullExpressionValue(getter, "signature.getter");
            sb.append(cVar.getString(getter.getName()));
            a$c getter2 = a_d.getGetter();
            d0.z.d.m.checkNotNullExpressionValue(getter2, "signature.getter");
            sb.append(cVar.getString(getter2.getDesc()));
            strK = sb.toString();
        } else {
            d0.e0.p.d.m0.f.a0.b.e$a jvmFieldSignature$default = d0.e0.p.d.m0.f.a0.b.h.getJvmFieldSignature$default(d0.e0.p.d.m0.f.a0.b.h.a, nVar, cVar, gVar, false, 8, null);
            if (jvmFieldSignature$default == null) {
                throw new a0("No field signature for property: " + n0Var);
            }
            String strComponent1 = jvmFieldSignature$default.component1();
            String strComponent2 = jvmFieldSignature$default.component2();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d0.e0.p.d.m0.e.a.z.getterName(strComponent1));
            d0.e0.p.d.m0.c.m containingDeclaration = n0Var.getContainingDeclaration();
            d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (d0.z.d.m.areEqual(n0Var.getVisibility(), d0.e0.p.d.m0.c.t.d) && (containingDeclaration instanceof d0.e0.p.d.m0.l.b.e0.d)) {
                d0.e0.p.d.m0.f.c classProto = ((d0.e0.p.d.m0.l.b.e0.d) containingDeclaration).getClassProto();
                g$f<d0.e0.p.d.m0.f.c, Integer> g_f = d0.e0.p.d.m0.f.a0.a.i;
                d0.z.d.m.checkNotNullExpressionValue(g_f, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(classProto, g_f);
                String string2 = (num == null || (string2 = cVar.getString(num.intValue())) == null) ? "main" : string2;
                StringBuilder sbU = b.d.b.a.a.U("$");
                sbU.append(d0.e0.p.d.m0.g.f.sanitizeAsJavaIdentifier(string2));
                string = sbU.toString();
            } else if (d0.z.d.m.areEqual(n0Var.getVisibility(), d0.e0.p.d.m0.c.t.a) && (containingDeclaration instanceof d0.e0.p.d.m0.c.e0)) {
                Objects.requireNonNull(n0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                d0.e0.p.d.m0.l.b.e0.f containerSource = ((d0.e0.p.d.m0.l.b.e0.j) n0Var).getContainerSource();
                if (containerSource instanceof d0.e0.p.d.m0.e.b.j) {
                    d0.e0.p.d.m0.e.b.j jVar = (d0.e0.p.d.m0.e.b.j) containerSource;
                    if (jVar.getFacadeClassName() != null) {
                        StringBuilder sbU2 = b.d.b.a.a.U("$");
                        sbU2.append(jVar.getSimpleName().asString());
                        string = sbU2.toString();
                    } else {
                        string = "";
                    }
                } else {
                    string = "";
                }
            } else {
                string = "";
            }
            strK = b.d.b.a.a.K(sb2, string, "()", strComponent2);
        }
        this.a = strK;
    }

    @Override // d0.e0.p.d.e
    public String asString() {
        return this.a;
    }

    public final n0 getDescriptor() {
        return this.f3195b;
    }

    public final d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.e;
    }

    public final d0.e0.p.d.m0.f.n getProto() {
        return this.c;
    }

    public final a$d getSignature() {
        return this.d;
    }

    public final d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.f;
    }
}
