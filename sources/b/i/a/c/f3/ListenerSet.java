package b.i.a.c.f3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: renamed from: b.i.a.c.f3.p, reason: use source file name */
/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ListenerSet<T> {
    public final Clock4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerWrapper f973b;
    public final b<T> c;
    public final CopyOnWriteArraySet<c<T>> d;
    public final ArrayDeque<Runnable> e = new ArrayDeque<>();
    public final ArrayDeque<Runnable> f = new ArrayDeque<>();
    public boolean g;

    /* JADX INFO: renamed from: b.i.a.c.f3.p$a */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface a<T> {
        void invoke(T t);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$b */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface b<T> {
        void a(T t, FlagSet flagSet);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$c */
    /* JADX INFO: compiled from: ListenerSet.java */
    public static final class c<T> {
        public final T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FlagSet.b f974b = new FlagSet.b();
        public boolean c;
        public boolean d;

        public c(T t) {
            this.a = t;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public ListenerSet(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, Clock4 clock4, b<T> bVar) {
        this.a = clock4;
        this.d = copyOnWriteArraySet;
        this.c = bVar;
        this.f973b = clock4.b(looper, new Handler.Callback() { // from class: b.i.a.c.f3.b
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
                ListenerSet listenerSet = this.j;
                Iterator it = listenerSet.d.iterator();
                while (it.hasNext()) {
                    ListenerSet.c cVar = (ListenerSet.c) it.next();
                    ListenerSet.b<T> bVar2 = listenerSet.c;
                    if (!cVar.d && cVar.c) {
                        FlagSet flagSetB = cVar.f974b.b();
                        cVar.f974b = new FlagSet.b();
                        cVar.c = false;
                        bVar2.a(cVar.a, flagSetB);
                    }
                    if (listenerSet.f973b.e(0)) {
                        return true;
                    }
                }
                return true;
            }
        });
    }

    public void a() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.f973b.e(0)) {
            HandlerWrapper handlerWrapper = this.f973b;
            handlerWrapper.d(handlerWrapper.c(0));
        }
        boolean z2 = !this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (z2) {
            return;
        }
        while (!this.e.isEmpty()) {
            this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }

    public void b(final int i, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
        this.f.add(new Runnable() { // from class: b.i.a.c.f3.a
            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArraySet<ListenerSet.c> copyOnWriteArraySet2 = copyOnWriteArraySet;
                int i2 = i;
                ListenerSet.a aVar2 = aVar;
                for (ListenerSet.c cVar : copyOnWriteArraySet2) {
                    if (!cVar.d) {
                        if (i2 != -1) {
                            FlagSet.b bVar = cVar.f974b;
                            AnimatableValueParser.D(!bVar.f972b);
                            bVar.a.append(i2, true);
                        }
                        cVar.c = true;
                        aVar2.invoke(cVar.a);
                    }
                }
            }
        });
    }

    public void c() {
        for (c<T> cVar : this.d) {
            b<T> bVar = this.c;
            cVar.d = true;
            if (cVar.c) {
                bVar.a(cVar.a, cVar.f974b.b());
            }
        }
        this.d.clear();
        this.g = true;
    }
}
