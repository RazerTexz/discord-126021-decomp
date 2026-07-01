package b.f.j.p;

import b.c.a.a0.AnimatableValueParser;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: renamed from: b.f.j.p.k, reason: use source file name */
/* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BranchOnSeparateImagesProducer implements Producer2<EncodedImage2> {
    public final Producer2<EncodedImage2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Producer2<EncodedImage2> f620b;

    /* JADX INFO: renamed from: b.f.j.p.k$b */
    /* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
    public class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public ProducerContext c;

        public b(Consumer2 consumer2, ProducerContext producerContext, a aVar) {
            super(consumer2);
            this.c = producerContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            BranchOnSeparateImagesProducer.this.f620b.b(this.f632b, this.c);
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            ImageRequest imageRequestE = this.c.e();
            boolean zE = BaseConsumer.e(i);
            boolean zT0 = AnimatableValueParser.T0(encodedImage2, imageRequestE.j);
            if (encodedImage2 != null && (zT0 || imageRequestE.g)) {
                if (zE && zT0) {
                    this.f632b.b(encodedImage2, i);
                } else {
                    this.f632b.b(encodedImage2, i & (-2));
                }
            }
            if (!zE || zT0 || imageRequestE.h) {
                return;
            }
            if (encodedImage2 != null) {
                encodedImage2.close();
            }
            BranchOnSeparateImagesProducer.this.f620b.b(this.f632b, this.c);
        }
    }

    public BranchOnSeparateImagesProducer(Producer2<EncodedImage2> producer2, Producer2<EncodedImage2> producer3) {
        this.a = producer2;
        this.f620b = producer3;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.a.b(new b(consumer2, producerContext, null), producerContext);
    }
}
