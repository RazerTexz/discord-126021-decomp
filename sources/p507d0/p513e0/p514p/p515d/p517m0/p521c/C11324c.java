package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11324c implements InterfaceC11477z0 {

    /* JADX INFO: renamed from: j */
    public final InterfaceC11477z0 f22682j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC11450m f22683k;

    /* JADX INFO: renamed from: l */
    public final int f22684l;

    public C11324c(InterfaceC11477z0 interfaceC11477z0, InterfaceC11450m interfaceC11450m, int i) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "originalDescriptor");
        C12238m.checkNotNullParameter(interfaceC11450m, "declarationDescriptor");
        this.f22682j = interfaceC11477z0;
        this.f22683k = interfaceC11450m;
        this.f22684l = i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return (R) this.f22682j.accept(interfaceC11454o, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public InterfaceC11344g getAnnotations() {
        return this.f22682j.getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        return this.f22683k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public AbstractC11934j0 getDefaultType() {
        return this.f22682j.getDefaultType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public int getIndex() {
        return this.f22682j.getIndex() + this.f22684l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public C11716e getName() {
        return this.f22682j.getName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        return this.f22682j.getSource();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public InterfaceC11905o getStorageManager() {
        return this.f22682j.getStorageManager();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public InterfaceC12008u0 getTypeConstructor() {
        return this.f22682j.getTypeConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public List<AbstractC11913c0> getUpperBounds() {
        return this.f22682j.getUpperBounds();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public EnumC11935j1 getVariance() {
        return this.f22682j.getVariance();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0
    public boolean isReified() {
        return this.f22682j.isReified();
    }

    public String toString() {
        return this.f22682j + "[inner-copy]";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11477z0 getOriginal() {
        InterfaceC11477z0 original = this.f22682j.getOriginal();
        C12238m.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }
}
