package b.f.j.p;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.j.d.ResizeOptions;
import b.f.j.j.EncodedImage2;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.j1, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailBranchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThumbnailBranchProducer implements Producer2<EncodedImage2> {
    public final ThumbnailProducer<EncodedImage2>[] a;

    /* JADX INFO: renamed from: b.f.j.p.j1$a */
    /* JADX INFO: compiled from: ThumbnailBranchProducer.java */
    public class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final ProducerContext c;
        public final int d;
        public final ResizeOptions e;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, int i) {
            super(consumer2);
            this.c = producerContext;
            this.d = i;
            this.e = producerContext.e().j;
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
        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            if (ThumbnailBranchProducer.this.c(this.d + 1, this.f632b, this.c)) {
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
        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            if (encodedImage2 != null && (BaseConsumer.f(i) || AnimatableValueParser.T0(encodedImage2, this.e))) {
                this.f632b.b(encodedImage2, i);
                return;
            }
            if (BaseConsumer.e(i)) {
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                if (ThumbnailBranchProducer.this.c(this.d + 1, this.f632b, this.c)) {
                    return;
                }
                this.f632b.b(null, 1);
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage2>... thumbnailProducerArr) {
        Objects.requireNonNull(thumbnailProducerArr);
        this.a = thumbnailProducerArr;
        int length = thumbnailProducerArr.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(outline.q("negative size: ", length));
            }
            throw new IndexOutOfBoundsException(AnimatableValueParser.k0("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        if (producerContext.e().j == null) {
            consumer2.b(null, 1);
        } else {
            if (c(0, consumer2, producerContext)) {
                return;
            }
            consumer2.b(null, 1);
        }
    }

    public final boolean c(int i, Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ResizeOptions resizeOptions = producerContext.e().j;
        while (true) {
            ThumbnailProducer<EncodedImage2>[] thumbnailProducerArr = this.a;
            if (i >= thumbnailProducerArr.length) {
                i = -1;
                break;
            }
            if (thumbnailProducerArr[i].a(resizeOptions)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.a[i].b(new a(consumer2, producerContext, i), producerContext);
        return true;
    }
}
