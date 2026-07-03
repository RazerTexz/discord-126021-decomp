package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11348k implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public final List<InterfaceC11344g> f22743j;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k$a */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11344g, InterfaceC11340c> {
        public final /* synthetic */ C11713b $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11713b c11713b) {
            super(1);
            this.$fqName = c11713b;
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11340c invoke(InterfaceC11344g interfaceC11344g) {
            C12238m.checkNotNullParameter(interfaceC11344g, "it");
            return interfaceC11344g.findAnnotation(this.$fqName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.k$b */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11344g, Sequence<? extends InterfaceC11340c>> {

        /* JADX INFO: renamed from: j */
        public static final b f22744j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Sequence<InterfaceC11340c> invoke(InterfaceC11344g interfaceC11344g) {
            C12238m.checkNotNullParameter(interfaceC11344g, "it");
            return C12163u.asSequence(interfaceC11344g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11348k(List<? extends InterfaceC11344g> list) {
        C12238m.checkNotNullParameter(list, "delegates");
        this.f22743j = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public InterfaceC11340c findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return (InterfaceC11340c) C12078q.firstOrNull(C12078q.mapNotNull(C12163u.asSequence(this.f22743j), new a(c11713b)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        Iterator it = C12163u.asSequence(this.f22743j).iterator();
        while (it.hasNext()) {
            if (((InterfaceC11344g) it.next()).hasAnnotation(c11713b)) {
                return true;
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        List<InterfaceC11344g> list = this.f22743j;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((InterfaceC11344g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        return C12078q.flatMap(C12163u.asSequence(this.f22743j), b.f22744j).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11348k(InterfaceC11344g... interfaceC11344gArr) {
        this((List<? extends InterfaceC11344g>) C12141k.toList(interfaceC11344gArr));
        C12238m.checkNotNullParameter(interfaceC11344gArr, "delegates");
    }
}
