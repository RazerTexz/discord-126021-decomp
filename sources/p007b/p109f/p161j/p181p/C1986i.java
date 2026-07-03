package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.j.p.i */
/* JADX INFO: compiled from: BitmapPrepareProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1986i implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4075a;

    /* JADX INFO: renamed from: b */
    public final int f4076b;

    /* JADX INFO: renamed from: c */
    public final int f4077c;

    /* JADX INFO: renamed from: d */
    public final boolean f4078d;

    /* JADX INFO: renamed from: b.f.j.p.i$a */
    /* JADX INFO: compiled from: BitmapPrepareProducer.java */
    public static class a extends AbstractC2003p<CloseableReference<AbstractC1917c>, CloseableReference<AbstractC1917c>> {

        /* JADX INFO: renamed from: c */
        public final int f4079c;

        /* JADX INFO: renamed from: d */
        public final int f4080d;

        public a(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, int i, int i2) {
            super(interfaceC1995l);
            this.f4079c = i;
            this.f4080d = i2;
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
        @Override // p007b.p109f.p161j.p181p.AbstractC1965b
        /* JADX INFO: renamed from: i */
        public void mo1320i(java.lang.Object r4, int r5) {
            /*
                r3 = this;
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
                if (r4 == 0) goto L3a
                boolean r0 = r4.m8643x()
                if (r0 != 0) goto Lb
                goto L3a
            Lb:
                java.lang.Object r0 = r4.m8642u()
                b.f.j.j.c r0 = (p007b.p109f.p161j.p175j.AbstractC1917c) r0
                boolean r1 = r0.isClosed()
                if (r1 == 0) goto L18
                goto L3a
            L18:
                boolean r1 = r0 instanceof p007b.p109f.p161j.p175j.C1918d
                if (r1 == 0) goto L3a
                b.f.j.j.d r0 = (p007b.p109f.p161j.p175j.C1918d) r0
                android.graphics.Bitmap r0 = r0.f3887m
                if (r0 != 0) goto L23
                goto L3a
            L23:
                int r1 = r0.getRowBytes()
                int r2 = r0.getHeight()
                int r2 = r2 * r1
                int r1 = r3.f4079c
                if (r2 >= r1) goto L32
                goto L3a
            L32:
                int r1 = r3.f4080d
                if (r2 <= r1) goto L37
                goto L3a
            L37:
                r0.prepareToDraw()
            L3a:
                b.f.j.p.l<O> r0 = r3.f4179b
                r0.mo1424b(r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p109f.p161j.p181p.C1986i.a.mo1320i(java.lang.Object, int):void");
        }
    }

    public C1986i(InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0, int i, int i2, boolean z2) {
        C1460d.m527i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(interfaceC2018w0);
        this.f4075a = interfaceC2018w0;
        this.f4076b = i;
        this.f4077c = i2;
        this.f4078d = z2;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        if (!interfaceC2020x0.mo1453k() || this.f4078d) {
            this.f4075a.mo1417b(new a(interfaceC1995l, this.f4076b, this.f4077c), interfaceC2020x0);
        } else {
            this.f4075a.mo1417b(interfaceC1995l, interfaceC2020x0);
        }
    }
}
