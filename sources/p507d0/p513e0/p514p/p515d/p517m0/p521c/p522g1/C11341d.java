package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.d */
/* JADX INFO: compiled from: AnnotationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11341d implements InterfaceC11340c {

    /* JADX INFO: renamed from: a */
    public final AbstractC11913c0 f22717a;

    /* JADX INFO: renamed from: b */
    public final Map<C11716e, AbstractC11815g<?>> f22718b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11467u0 f22719c;

    public C11341d(AbstractC11913c0 abstractC11913c0, Map<C11716e, AbstractC11815g<?>> map, InterfaceC11467u0 interfaceC11467u0) {
        if (abstractC11913c0 == null) {
            m9385a(0);
            throw null;
        }
        if (map == null) {
            m9385a(1);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9385a(2);
            throw null;
        }
        this.f22717a = abstractC11913c0;
        this.f22718b = map;
        this.f22719c = interfaceC11467u0;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9385a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public Map<C11716e, AbstractC11815g<?>> getAllValueArguments() {
        Map<C11716e, AbstractC11815g<?>> map = this.f22718b;
        if (map != null) {
            return map;
        }
        m9385a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public C11713b getFqName() {
        return InterfaceC11340c.a.getFqName(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = this.f22719c;
        if (interfaceC11467u0 != null) {
            return interfaceC11467u0;
        }
        m9385a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public AbstractC11913c0 getType() {
        AbstractC11913c0 abstractC11913c0 = this.f22717a;
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        m9385a(3);
        throw null;
    }

    public String toString() {
        return AbstractC11746c.f24226b.renderAnnotation(this, null);
    }
}
