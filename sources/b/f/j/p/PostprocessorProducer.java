package b.f.j.p;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableMap;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.q.Postprocessor;
import b.f.j.q.RepeatedPostprocessor;
import b.f.j.q.RepeatedPostprocessorRunner;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.t0, reason: use source file name */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PostprocessorProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Producer2<CloseableReference<CloseableImage>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f639b;
    public final Executor c;

    /* JADX INFO: renamed from: b.f.j.p.t0$b */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class b extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerListener2 c;
        public final ProducerContext d;
        public final Postprocessor e;
        public boolean f;
        public CloseableReference<CloseableImage> g;
        public int h;
        public boolean i;
        public boolean j;

        /* JADX INFO: renamed from: b.f.j.p.t0$b$a */
        /* JADX INFO: compiled from: PostprocessorProducer.java */
        public class a extends BaseProducerContextCallbacks {
            public a(PostprocessorProducer postprocessorProducer) {
            }

            @Override // b.f.j.p.ProducerContextCallbacks
            public void a() {
                b bVar = b.this;
                if (bVar.o()) {
                    bVar.f632b.d();
                }
            }
        }

        public b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer2);
            this.g = null;
            this.h = 0;
            this.i = false;
            this.j = false;
            this.c = producerListener2;
            this.e = postprocessor;
            this.d = producerContext;
            producerContext.f(new a(PostprocessorProducer.this));
        }

        public static void n(b bVar, CloseableReference closeableReference, int i) {
            Objects.requireNonNull(bVar);
            AnimatableValueParser.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
            if (!(((CloseableImage) closeableReference.u()) instanceof CloseableStaticBitmap)) {
                bVar.q(closeableReference, i);
                return;
            }
            bVar.c.e(bVar.d, "PostprocessorProducer");
            CloseableReference<CloseableImage> closeableReferenceR = null;
            try {
                try {
                    closeableReferenceR = bVar.r((CloseableImage) closeableReference.u());
                    ProducerListener2 producerListener2 = bVar.c;
                    ProducerContext producerContext = bVar.d;
                    producerListener2.j(producerContext, "PostprocessorProducer", bVar.p(producerListener2, producerContext, bVar.e));
                    bVar.q(closeableReferenceR, i);
                    if (closeableReferenceR != null) {
                        closeableReferenceR.close();
                    }
                } catch (Exception e) {
                    ProducerListener2 producerListener3 = bVar.c;
                    ProducerContext producerContext2 = bVar.d;
                    producerListener3.k(producerContext2, "PostprocessorProducer", e, bVar.p(producerListener3, producerContext2, bVar.e));
                    if (bVar.o()) {
                        bVar.f632b.c(e);
                    }
                }
            } catch (Throwable th) {
                if (closeableReferenceR != null) {
                    closeableReferenceR.close();
                }
                throw th;
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            if (o()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            if (o()) {
                this.f632b.c(th);
            }
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.y(closeableReference)) {
                if (BaseConsumer.e(i)) {
                    q(null, i);
                    return;
                }
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    CloseableReference<CloseableImage> closeableReference2 = this.g;
                    this.g = CloseableReference.n(closeableReference);
                    this.h = i;
                    this.i = true;
                    boolean zS = s();
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                    if (zS) {
                        PostprocessorProducer.this.c.execute(new PostprocessorProducer2(this));
                    }
                }
            }
        }

        public final boolean o() {
            synchronized (this) {
                if (this.f) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.g;
                this.g = null;
                this.f = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }

        public final Map<String, String> p(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (producerListener2.g(producerContext, "PostprocessorProducer")) {
                return ImmutableMap.of("Postprocessor", postprocessor.getName());
            }
            return null;
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        public final void q(com.facebook.common.references.CloseableReference<b.f.j.j.CloseableImage> r3, int r4) {
            /*
                r2 = this;
                boolean r0 = b.f.j.p.BaseConsumer.e(r4)
                if (r0 != 0) goto L10
                monitor-enter(r2)
                boolean r1 = r2.f     // Catch: java.lang.Throwable -> Ld
                monitor-exit(r2)
                if (r1 == 0) goto L18
                goto L10
            Ld:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            L10:
                if (r0 == 0) goto L1d
                boolean r0 = r2.o()
                if (r0 == 0) goto L1d
            L18:
                b.f.j.p.l<O> r0 = r2.f632b
                r0.b(r3, r4)
            L1d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.PostprocessorProducer.b.q(com.facebook.common.references.CloseableReference, int):void");
        }

        public final CloseableReference<CloseableImage> r(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> closeableReferenceProcess = this.e.process(closeableStaticBitmap.m, PostprocessorProducer.this.f639b);
            try {
                CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(closeableReferenceProcess, closeableImage.b(), closeableStaticBitmap.o, closeableStaticBitmap.p);
                closeableStaticBitmap2.e(closeableStaticBitmap.k);
                return CloseableReference.A(closeableStaticBitmap2);
            } finally {
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
            }
        }

        public final synchronized boolean s() {
            if (this.f || !this.i || this.j || !CloseableReference.y(this.g)) {
                return false;
            }
            this.j = true;
            return true;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$c */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class c extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public boolean c;
        public CloseableReference<CloseableImage> d;

        public c(PostprocessorProducer postprocessorProducer, b bVar, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, a aVar) {
            super(bVar);
            this.c = false;
            this.d = null;
            repeatedPostprocessor.a(this);
            producerContext.f(new PostprocessorProducer3(this, postprocessorProducer));
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            if (n()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            if (n()) {
                this.f632b.c(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.f(i)) {
                return;
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference<CloseableImage> closeableReference2 = this.d;
                    this.d = CloseableReference.n(closeableReference);
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference closeableReferenceN = CloseableReference.n(this.d);
                    try {
                        this.f632b.b((O) closeableReferenceN, 0);
                    } finally {
                        if (closeableReferenceN != null) {
                            closeableReferenceN.close();
                        }
                    }
                }
            }
        }

        public final boolean n() {
            synchronized (this) {
                if (this.c) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.d;
                this.d = null;
                this.c = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$d */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class d extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public d(PostprocessorProducer postprocessorProducer, b bVar, a aVar) {
            super(bVar);
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
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // b.f.j.p.BaseConsumer
        public void i(java.lang.Object r2, int r3) {
            /*
                r1 = this;
                com.facebook.common.references.CloseableReference r2 = (com.facebook.common.references.CloseableReference) r2
                boolean r0 = b.f.j.p.BaseConsumer.f(r3)
                if (r0 == 0) goto L9
                goto Le
            L9:
                b.f.j.p.l<O> r0 = r1.f632b
                r0.b(r2, r3)
            Le:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.j.p.PostprocessorProducer.d.i(java.lang.Object, int):void");
        }
    }

    public PostprocessorProducer(Producer2<CloseableReference<CloseableImage>> producer2, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.f639b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.c = executor;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        Postprocessor postprocessor = producerContext.e().f2903s;
        Objects.requireNonNull(postprocessor);
        b bVar = new b(consumer2, producerListener2O, postprocessor, producerContext);
        this.a.b(postprocessor instanceof RepeatedPostprocessor ? new c(this, bVar, (RepeatedPostprocessor) postprocessor, producerContext, null) : new d(this, bVar, null), producerContext);
    }
}
