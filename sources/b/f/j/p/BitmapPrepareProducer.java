package b.f.j.p;

import b.c.a.a0.AnimatableValueParser;
import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.i, reason: use source file name */
/* JADX INFO: compiled from: BitmapPrepareProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapPrepareProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Producer2<CloseableReference<CloseableImage>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f615b;
    public final int c;
    public final boolean d;

    /* JADX INFO: renamed from: b.f.j.p.i$a */
    /* JADX INFO: compiled from: BitmapPrepareProducer.java */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final int c;
        public final int d;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, int i, int i2) {
            super(consumer2);
            this.c = i;
            this.d = i2;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
                if (r4 == 0) goto L3a
                boolean r0 = r4.x()
                if (r0 != 0) goto Lb
                goto L3a
            Lb:
                java.lang.Object r0 = r4.u()
                b.f.j.j.c r0 = (b.f.j.j.CloseableImage) r0
                boolean r1 = r0.isClosed()
                if (r1 == 0) goto L18
                goto L3a
            L18:
                boolean r1 = r0 instanceof b.f.j.j.CloseableStaticBitmap
                if (r1 == 0) goto L3a
                b.f.j.j.d r0 = (b.f.j.j.CloseableStaticBitmap) r0
                android.graphics.Bitmap r0 = r0.m
                if (r0 != 0) goto L23
                goto L3a
            L23:
                int r1 = r0.getRowBytes()
                int r2 = r0.getHeight()
                int r2 = r2 * r1
                int r1 = r3.c
                if (r2 >= r1) goto L32
                goto L3a
            L32:
                int r1 = r3.d
                if (r2 <= r1) goto L37
                goto L3a
            L37:
                r0.prepareToDraw()
            L3a:
                b.f.j.p.l<O> r0 = r3.f632b
                r0.b(r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.BitmapPrepareProducer.a.i(java.lang.Object, int):void");
        }
    }

    public BitmapPrepareProducer(Producer2<CloseableReference<CloseableImage>> producer2, int i, int i2, boolean z2) {
        AnimatableValueParser.i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.f615b = i;
        this.c = i2;
        this.d = z2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        if (!producerContext.k() || this.d) {
            this.a.b(new a(consumer2, this.f615b, this.c), producerContext);
        } else {
            this.a.b(consumer2, producerContext);
        }
    }
}
