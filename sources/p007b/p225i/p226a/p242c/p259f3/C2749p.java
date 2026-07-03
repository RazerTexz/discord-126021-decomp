package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2747n;
import p007b.p225i.p226a.p242c.p259f3.C2749p;

/* JADX INFO: renamed from: b.i.a.c.f3.p */
/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2749p<T> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2740g f6736a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2748o f6737b;

    /* JADX INFO: renamed from: c */
    public final b<T> f6738c;

    /* JADX INFO: renamed from: d */
    public final CopyOnWriteArraySet<c<T>> f6739d;

    /* JADX INFO: renamed from: e */
    public final ArrayDeque<Runnable> f6740e = new ArrayDeque<>();

    /* JADX INFO: renamed from: f */
    public final ArrayDeque<Runnable> f6741f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g */
    public boolean f6742g;

    /* JADX INFO: renamed from: b.i.a.c.f3.p$a */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface a<T> {
        void invoke(T t);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$b */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface b<T> {
        /* JADX INFO: renamed from: a */
        void mo3037a(T t, C2747n c2747n);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$c */
    /* JADX INFO: compiled from: ListenerSet.java */
    public static final class c<T> {

        /* JADX INFO: renamed from: a */
        public final T f6743a;

        /* JADX INFO: renamed from: b */
        public C2747n.b f6744b = new C2747n.b();

        /* JADX INFO: renamed from: c */
        public boolean f6745c;

        /* JADX INFO: renamed from: d */
        public boolean f6746d;

        public c(T t) {
            this.f6743a = t;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f6743a.equals(((c) obj).f6743a);
        }

        public int hashCode() {
            return this.f6743a.hashCode();
        }
    }

    public C2749p(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, InterfaceC2740g interfaceC2740g, b<T> bVar) {
        this.f6736a = interfaceC2740g;
        this.f6739d = copyOnWriteArraySet;
        this.f6738c = bVar;
        this.f6737b = interfaceC2740g.mo2950b(looper, new Handler.Callback() { // from class: b.i.a.c.f3.b
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                C2749p c2749p = this.f6689j;
                Iterator it = c2749p.f6739d.iterator();
                while (it.hasNext()) {
                    C2749p.c cVar = (C2749p.c) it.next();
                    C2749p.b<T> bVar2 = c2749p.f6738c;
                    if (!cVar.f6746d && cVar.f6745c) {
                        C2747n c2747nM3033b = cVar.f6744b.m3033b();
                        cVar.f6744b = new C2747n.b();
                        cVar.f6745c = false;
                        bVar2.mo3037a(cVar.f6743a, c2747nM3033b);
                    }
                    if (c2749p.f6737b.mo2958e(0)) {
                        return true;
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m3034a() {
        if (this.f6741f.isEmpty()) {
            return;
        }
        if (!this.f6737b.mo2958e(0)) {
            InterfaceC2748o interfaceC2748o = this.f6737b;
            interfaceC2748o.mo2957d(interfaceC2748o.mo2956c(0));
        }
        boolean z2 = !this.f6740e.isEmpty();
        this.f6740e.addAll(this.f6741f);
        this.f6741f.clear();
        if (z2) {
            return;
        }
        while (!this.f6740e.isEmpty()) {
            this.f6740e.peekFirst().run();
            this.f6740e.removeFirst();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3035b(final int i, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f6739d);
        this.f6741f.add(new Runnable() { // from class: b.i.a.c.f3.a
            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArraySet<C2749p.c> copyOnWriteArraySet2 = copyOnWriteArraySet;
                int i2 = i;
                C2749p.a aVar2 = aVar;
                for (C2749p.c cVar : copyOnWriteArraySet2) {
                    if (!cVar.f6746d) {
                        if (i2 != -1) {
                            C2747n.b bVar = cVar.f6744b;
                            C1460d.m426D(!bVar.f6735b);
                            bVar.f6734a.append(i2, true);
                        }
                        cVar.f6745c = true;
                        aVar2.invoke(cVar.f6743a);
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m3036c() {
        for (c<T> cVar : this.f6739d) {
            b<T> bVar = this.f6738c;
            cVar.f6746d = true;
            if (cVar.f6745c) {
                bVar.mo3037a(cVar.f6743a, cVar.f6744b.m3033b());
            }
        }
        this.f6739d.clear();
        this.f6742g = true;
    }
}
