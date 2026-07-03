package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.l */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11349l implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public final InterfaceC11344g f22745j;

    /* JADX INFO: renamed from: k */
    public final boolean f22746k;

    /* JADX INFO: renamed from: l */
    public final Function1<C11713b, Boolean> f22747l;

    /* JADX WARN: Multi-variable type inference failed */
    public C11349l(InterfaceC11344g interfaceC11344g, boolean z2, Function1<? super C11713b, Boolean> function1) {
        C12238m.checkNotNullParameter(interfaceC11344g, "delegate");
        C12238m.checkNotNullParameter(function1, "fqNameFilter");
        this.f22745j = interfaceC11344g;
        this.f22746k = z2;
        this.f22747l = function1;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m9386c(InterfaceC11340c interfaceC11340c) {
        C11713b fqName = interfaceC11340c.getFqName();
        return fqName != null && this.f22747l.invoke(fqName).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public InterfaceC11340c findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        if (this.f22747l.invoke(c11713b).booleanValue()) {
            return this.f22745j.findAnnotation(c11713b);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        if (this.f22747l.invoke(c11713b).booleanValue()) {
            return this.f22745j.hasAnnotation(c11713b);
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        boolean z2;
        InterfaceC11344g interfaceC11344g = this.f22745j;
        if (!(interfaceC11344g instanceof Collection) || !((Collection) interfaceC11344g).isEmpty()) {
            Iterator<InterfaceC11340c> it = interfaceC11344g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (m9386c(it.next())) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (this.f22746k) {
            return !z2;
        }
        return z2;
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        InterfaceC11344g interfaceC11344g = this.f22745j;
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11340c interfaceC11340c : interfaceC11344g) {
            if (m9386c(interfaceC11340c)) {
                arrayList.add(interfaceC11340c);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11349l(InterfaceC11344g interfaceC11344g, Function1<? super C11713b, Boolean> function1) {
        this(interfaceC11344g, false, function1);
        C12238m.checkNotNullParameter(interfaceC11344g, "delegate");
        C12238m.checkNotNullParameter(function1, "fqNameFilter");
    }
}
