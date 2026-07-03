package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11363b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11707f;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11849c0;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11876l;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11887w;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11890z;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.m */
/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11868m extends AbstractC11363b {

    /* JADX INFO: renamed from: t */
    public final C11876l f24622t;

    /* JADX INFO: renamed from: u */
    public final C11694s f24623u;

    /* JADX INFO: renamed from: v */
    public final C11856a f24624v;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.m$a */
    /* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11340c>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends InterfaceC11340c> invoke() {
            return C12163u.toList(C11868m.this.f24622t.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(C11868m.this.getProto(), C11868m.this.f24622t.getNameResolver()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11868m(C11876l c11876l, C11694s c11694s, int i) {
        C12238m.checkNotNullParameter(c11876l, "c");
        C12238m.checkNotNullParameter(c11694s, "proto");
        InterfaceC11905o storageManager = c11876l.getStorageManager();
        InterfaceC11450m containingDeclaration = c11876l.getContainingDeclaration();
        C11716e name = C11887w.getName(c11876l.getNameResolver(), c11694s.getName());
        C11890z c11890z = C11890z.f24700a;
        C11694s.c variance = c11694s.getVariance();
        C12238m.checkNotNullExpressionValue(variance, "proto.variance");
        super(storageManager, containingDeclaration, name, c11890z.variance(variance), c11694s.getReified(), i, InterfaceC11467u0.f23099a, InterfaceC11473x0.a.f23103a);
        this.f24622t = c11876l;
        this.f24623u = c11694s;
        this.f24624v = new C11856a(c11876l.getStorageManager(), new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: c */
    public void mo9400c(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        throw new IllegalStateException(C12238m.stringPlus("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: d */
    public List<AbstractC11913c0> mo9401d() {
        List<C11692q> listUpperBounds = C11707f.upperBounds(this.f24623u, this.f24622t.getTypeTable());
        if (listUpperBounds.isEmpty()) {
            return C12145m.listOf(C11836a.getBuiltIns(this).getDefaultBound());
        }
        C11849c0 typeDeserializer = this.f24622t.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listUpperBounds, 10));
        Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((C11692q) it.next()));
        }
        return arrayList;
    }

    public final C11694s getProto() {
        return this.f24623u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11339b, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
    public C11856a getAnnotations() {
        return this.f24624v;
    }
}
