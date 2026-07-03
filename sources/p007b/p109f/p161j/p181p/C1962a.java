package p007b.p109f.p161j.p181p;

import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.a */
/* JADX INFO: compiled from: AddImageTransformMetaDataProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1962a implements InterfaceC2018w0<C1919e> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<C1919e> f3986a;

    /* JADX INFO: renamed from: b.f.j.p.a$b */
    /* JADX INFO: compiled from: AddImageTransformMetaDataProducer.java */
    public static class b extends AbstractC2003p<C1919e, C1919e> {
        public b(InterfaceC1995l interfaceC1995l, a aVar) {
            super(interfaceC1995l);
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v3 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r2, int r3) {
            /*
                r1 = this;
                b.f.j.j.e r2 = (p007b.p109f.p161j.p175j.C1919e) r2
                if (r2 != 0) goto Lb
                b.f.j.p.l<O> r2 = r1.f4179b
                r0 = 0
                r2.mo1424b(r0, r3)
                goto L19
            Lb:
                boolean r0 = p007b.p109f.p161j.p175j.C1919e.m1337s(r2)
                if (r0 != 0) goto L14
                r2.m1345q()
            L14:
                b.f.j.p.l<O> r0 = r1.f4179b
                r0.mo1424b(r2, r3)
            L19:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1962a.b.mo1320i(java.lang.Object, int):void");
        }
    }

    public C1962a(InterfaceC2018w0<C1919e> interfaceC2018w0) {
        this.f3986a = interfaceC2018w0;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        this.f3986a.mo1417b(new b(interfaceC1995l, null), interfaceC2020x0);
    }
}
