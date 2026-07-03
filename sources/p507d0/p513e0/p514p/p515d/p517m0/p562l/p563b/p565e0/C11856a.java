package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.a */
/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11856a implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty<Object>[] f24521j = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11856a.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final InterfaceC11900j f24522k;

    public C11856a(InterfaceC11905o interfaceC11905o, Function0<? extends List<? extends InterfaceC11340c>> function0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(function0, "compute");
        this.f24522k = interfaceC11905o.createLazyValue(function0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public InterfaceC11340c findAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.findAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.hasAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        return ((List) C11904n.getValue(this.f24522k, this, (KProperty<?>) f24521j[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        return ((List) C11904n.getValue(this.f24522k, this, (KProperty<?>) f24521j[0])).iterator();
    }
}
