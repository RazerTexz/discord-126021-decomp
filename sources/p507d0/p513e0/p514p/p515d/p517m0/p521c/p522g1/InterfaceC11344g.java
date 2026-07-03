package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11344g extends Iterable<InterfaceC11340c>, InterfaceC12228a {

    /* JADX INFO: renamed from: f */
    public static final a f22735f = a.f22736a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f22736a = new a();

        /* JADX INFO: renamed from: b */
        public static final InterfaceC11344g f22737b = new C13306a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Annotations.kt */
        public static final class C13306a implements InterfaceC11344g {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
            public /* bridge */ /* synthetic */ InterfaceC11340c findAnnotation(C11713b c11713b) {
                return (InterfaceC11340c) m11461findAnnotation(c11713b);
            }

            /* JADX INFO: renamed from: findAnnotation, reason: collision with other method in class */
            public Void m11461findAnnotation(C11713b c11713b) {
                C12238m.checkNotNullParameter(c11713b, "fqName");
                return null;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
            public boolean hasAnnotation(C11713b c11713b) {
                return b.hasAnnotation(this, c11713b);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<InterfaceC11340c> iterator() {
                return C12147n.emptyList().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final InterfaceC11344g create(List<? extends InterfaceC11340c> list) {
            C12238m.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? f22737b : new C11345h(list);
        }

        public final InterfaceC11344g getEMPTY() {
            return f22737b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.g$b */
    /* JADX INFO: compiled from: Annotations.kt */
    public static final class b {
        public static InterfaceC11340c findAnnotation(InterfaceC11344g interfaceC11344g, C11713b c11713b) {
            InterfaceC11340c next;
            C12238m.checkNotNullParameter(interfaceC11344g, "this");
            C12238m.checkNotNullParameter(c11713b, "fqName");
            Iterator<InterfaceC11340c> it = interfaceC11344g.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (C12238m.areEqual(next.getFqName(), c11713b)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public static boolean hasAnnotation(InterfaceC11344g interfaceC11344g, C11713b c11713b) {
            C12238m.checkNotNullParameter(interfaceC11344g, "this");
            C12238m.checkNotNullParameter(c11713b, "fqName");
            return interfaceC11344g.findAnnotation(c11713b) != null;
        }
    }

    InterfaceC11340c findAnnotation(C11713b c11713b);

    boolean hasAnnotation(C11713b c11713b);

    boolean isEmpty();
}
