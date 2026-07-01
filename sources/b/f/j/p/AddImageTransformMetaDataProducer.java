package b.f.j.p;

import b.f.j.j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.a, reason: use source file name */
/* JADX INFO: compiled from: AddImageTransformMetaDataProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AddImageTransformMetaDataProducer implements Producer2<EncodedImage2> {
    public final Producer2<EncodedImage2> a;

    /* JADX INFO: renamed from: b.f.j.p.a$b */
    /* JADX INFO: compiled from: AddImageTransformMetaDataProducer.java */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
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
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r2, int r3) {
            /*
                r1 = this;
                b.f.j.j.e r2 = (b.f.j.j.EncodedImage2) r2
                if (r2 != 0) goto Lb
                b.f.j.p.l<O> r2 = r1.f632b
                r0 = 0
                r2.b(r0, r3)
                goto L19
            Lb:
                boolean r0 = b.f.j.j.EncodedImage2.s(r2)
                if (r0 != 0) goto L14
                r2.q()
            L14:
                b.f.j.p.l<O> r0 = r1.f632b
                r0.b(r2, r3)
            L19:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.AddImageTransformMetaDataProducer.b.i(java.lang.Object, int):void");
        }
    }

    public AddImageTransformMetaDataProducer(Producer2<EncodedImage2> producer2) {
        this.a = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.a.b(new b(consumer2, null), producerContext);
    }
}
