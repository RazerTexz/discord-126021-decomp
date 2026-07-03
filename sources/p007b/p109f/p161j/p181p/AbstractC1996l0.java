package p007b.p109f.p161j.p181p;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p127l.EnumC1716a;
import p007b.p109f.p161j.p169d.EnumC1883d;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.l0 */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1996l0<K, T extends Closeable> implements InterfaceC2018w0<T> {

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public final Map<K, AbstractC1996l0<K, T>.b> f4127a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2018w0<T> f4128b;

    /* JADX INFO: renamed from: c */
    public final boolean f4129c;

    /* JADX INFO: renamed from: d */
    public final String f4130d;

    /* JADX INFO: renamed from: e */
    public final String f4131e;

    /* JADX INFO: renamed from: b.f.j.p.l0$b */
    /* JADX INFO: compiled from: MultiplexProducer.java */
    @VisibleForTesting
    public class b {

        /* JADX INFO: renamed from: a */
        public final K f4132a;

        /* JADX INFO: renamed from: b */
        public final CopyOnWriteArraySet<Pair<InterfaceC1995l<T>, InterfaceC2020x0>> f4133b = new CopyOnWriteArraySet<>();

        /* JADX INFO: renamed from: c */
        public T f4134c;

        /* JADX INFO: renamed from: d */
        public float f4135d;

        /* JADX INFO: renamed from: e */
        public int f4136e;

        /* JADX INFO: renamed from: f */
        public C1971d f4137f;

        /* JADX INFO: renamed from: g */
        public AbstractC1996l0<K, T>.b.a f4138g;

        /* JADX INFO: renamed from: b.f.j.p.l0$b$a */
        /* JADX INFO: compiled from: MultiplexProducer.java */
        public class a extends AbstractC1965b<T> {
            public a(a aVar) {
            }

            @Override // p007b.p109f.p161j.p181p.AbstractC1965b
            /* JADX INFO: renamed from: g */
            public void mo1318g() {
                try {
                    C2030b.m1527b();
                    b bVar = b.this;
                    synchronized (bVar) {
                        if (bVar.f4138g == this) {
                            bVar.f4138g = null;
                            bVar.f4137f = null;
                            bVar.m1484b(bVar.f4134c);
                            bVar.f4134c = null;
                            bVar.m1491i(EnumC1716a.UNSET);
                        }
                    }
                    C2030b.m1527b();
                } catch (Throwable th) {
                    C2030b.m1527b();
                    throw th;
                }
            }

            @Override // p007b.p109f.p161j.p181p.AbstractC1965b
            /* JADX INFO: renamed from: h */
            public void mo1319h(Throwable th) {
                try {
                    C2030b.m1527b();
                    b.this.m1488f(this, th);
                } finally {
                    C2030b.m1527b();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
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
            @Override // p007b.p109f.p161j.p181p.AbstractC1965b
            /* JADX INFO: renamed from: i */
            public void mo1320i(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    C2030b.m1527b();
                    b.this.m1489g(this, closeable, i);
                } finally {
                    C2030b.m1527b();
                }
            }

            @Override // p007b.p109f.p161j.p181p.AbstractC1965b
            /* JADX INFO: renamed from: j */
            public void mo1321j(float f) {
                try {
                    C2030b.m1527b();
                    b.this.m1490h(this, f);
                } finally {
                    C2030b.m1527b();
                }
            }
        }

        public b(K k) {
            this.f4132a = k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public boolean m1483a(InterfaceC1995l<T> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
            AbstractC1996l0<K, T>.b bVar;
            Pair<InterfaceC1995l<T>, InterfaceC2020x0> pairCreate = Pair.create(interfaceC1995l, interfaceC2020x0);
            synchronized (this) {
                AbstractC1996l0 abstractC1996l0 = AbstractC1996l0.this;
                K k = this.f4132a;
                synchronized (abstractC1996l0) {
                    bVar = abstractC1996l0.f4127a.get(k);
                }
                if (bVar != this) {
                    return false;
                }
                this.f4133b.add(pairCreate);
                List<InterfaceC2022y0> listM1493k = m1493k();
                List<InterfaceC2022y0> listM1494l = m1494l();
                List<InterfaceC2022y0> listM1492j = m1492j();
                Closeable closeableMo1476c = this.f4134c;
                float f = this.f4135d;
                int i = this.f4136e;
                C1971d.m1441s(listM1493k);
                C1971d.m1442t(listM1494l);
                C1971d.m1440r(listM1492j);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableMo1476c != this.f4134c) {
                            closeableMo1476c = null;
                        } else if (closeableMo1476c != null) {
                            closeableMo1476c = AbstractC1996l0.this.mo1476c(closeableMo1476c);
                        }
                    }
                    if (closeableMo1476c != null) {
                        if (f > 0.0f) {
                            interfaceC1995l.mo1423a(f);
                        }
                        interfaceC1995l.mo1424b(closeableMo1476c, i);
                        m1484b(closeableMo1476c);
                    }
                }
                interfaceC2020x0.mo1448f(new C1998m0(this, pairCreate));
                return true;
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m1484b(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public final synchronized boolean m1485c() {
            Iterator<Pair<InterfaceC1995l<T>, InterfaceC2020x0>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                if (((InterfaceC2020x0) it.next().second).mo1458p()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: d */
        public final synchronized boolean m1486d() {
            Iterator<Pair<InterfaceC1995l<T>, InterfaceC2020x0>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                if (!((InterfaceC2020x0) it.next().second).mo1453k()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: renamed from: e */
        public final synchronized EnumC1883d m1487e() {
            EnumC1883d enumC1883d;
            enumC1883d = EnumC1883d.LOW;
            Iterator<Pair<InterfaceC1995l<T>, InterfaceC2020x0>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                EnumC1883d enumC1883dMo1445c = ((InterfaceC2020x0) it.next().second).mo1445c();
                if (enumC1883d.ordinal() <= enumC1883dMo1445c.ordinal()) {
                    enumC1883d = enumC1883dMo1445c;
                }
            }
            return enumC1883d;
        }

        /* JADX INFO: renamed from: f */
        public void m1488f(AbstractC1996l0<K, T>.b.a aVar, Throwable th) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                this.f4133b.clear();
                AbstractC1996l0.this.m1482e(this.f4132a, this);
                m1484b(this.f4134c);
                this.f4134c = null;
                for (Pair<InterfaceC1995l<T>, InterfaceC2020x0> pair : this.f4133b) {
                    synchronized (pair) {
                        ((InterfaceC2020x0) pair.second).mo1457o().mo1364k((InterfaceC2020x0) pair.second, AbstractC1996l0.this.f4130d, th, null);
                        ((InterfaceC1995l) pair.first).mo1425c(th);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: g */
        public void m1489g(AbstractC1996l0<K, T>.b.a aVar, T t, int i) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                m1484b(this.f4134c);
                this.f4134c = null;
                int size = this.f4133b.size();
                if (AbstractC1965b.m1420f(i)) {
                    this.f4134c = (T) AbstractC1996l0.this.mo1476c(t);
                    this.f4136e = i;
                } else {
                    this.f4133b.clear();
                    AbstractC1996l0.this.m1482e(this.f4132a, this);
                }
                for (Pair<InterfaceC1995l<T>, InterfaceC2020x0> pair : this.f4133b) {
                    synchronized (pair) {
                        if (AbstractC1965b.m1419e(i)) {
                            ((InterfaceC2020x0) pair.second).mo1457o().mo1363j((InterfaceC2020x0) pair.second, AbstractC1996l0.this.f4130d, null);
                            C1971d c1971d = this.f4137f;
                            if (c1971d != null) {
                                ((InterfaceC2020x0) pair.second).mo1452j(c1971d.f4032h);
                            }
                            ((InterfaceC2020x0) pair.second).mo1446d(AbstractC1996l0.this.f4131e, Integer.valueOf(size));
                        }
                        ((InterfaceC1995l) pair.first).mo1424b(t, i);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: h */
        public void m1490h(AbstractC1996l0<K, T>.b.a aVar, float f) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                this.f4135d = f;
                for (Pair<InterfaceC1995l<T>, InterfaceC2020x0> pair : this.f4133b) {
                    synchronized (pair) {
                        ((InterfaceC1995l) pair.first).mo1423a(f);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: i */
        public final void m1491i(EnumC1716a enumC1716a) {
            synchronized (this) {
                boolean z2 = true;
                C1460d.m527i(Boolean.valueOf(this.f4137f == null));
                C1460d.m527i(Boolean.valueOf(this.f4138g == null));
                if (this.f4133b.isEmpty()) {
                    AbstractC1996l0.this.m1482e(this.f4132a, this);
                    return;
                }
                InterfaceC2020x0 interfaceC2020x0 = (InterfaceC2020x0) this.f4133b.iterator().next().second;
                C1971d c1971d = new C1971d(interfaceC2020x0.mo1447e(), interfaceC2020x0.getId(), null, interfaceC2020x0.mo1457o(), interfaceC2020x0.mo1444b(), interfaceC2020x0.mo1459q(), m1486d(), m1485c(), m1487e(), interfaceC2020x0.mo1449g());
                this.f4137f = c1971d;
                c1971d.mo1452j(interfaceC2020x0.mo1443a());
                Objects.requireNonNull(enumC1716a);
                if (enumC1716a != EnumC1716a.UNSET) {
                    C1971d c1971d2 = this.f4137f;
                    int iOrdinal = enumC1716a.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            if (iOrdinal == 2) {
                                throw new IllegalStateException("No boolean equivalent for UNSET");
                            }
                            throw new IllegalStateException("Unrecognized TriState value: " + enumC1716a);
                        }
                        z2 = false;
                    }
                    c1971d2.mo1446d("started_as_prefetch", Boolean.valueOf(z2));
                }
                AbstractC1996l0<K, T>.b.a aVar = new a(null);
                this.f4138g = aVar;
                AbstractC1996l0.this.f4128b.mo1417b(aVar, this.f4137f);
            }
        }

        /* JADX INFO: renamed from: j */
        public final synchronized List<InterfaceC2022y0> m1492j() {
            C1971d c1971d = this.f4137f;
            ArrayList arrayList = null;
            if (c1971d == null) {
                return null;
            }
            boolean zM1485c = m1485c();
            synchronized (c1971d) {
                if (zM1485c != c1971d.f4035k) {
                    c1971d.f4035k = zM1485c;
                    arrayList = new ArrayList(c1971d.f4037m);
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: k */
        public final synchronized List<InterfaceC2022y0> m1493k() {
            C1971d c1971d = this.f4137f;
            ArrayList arrayList = null;
            if (c1971d == null) {
                return null;
            }
            boolean zM1486d = m1486d();
            synchronized (c1971d) {
                if (zM1486d != c1971d.f4033i) {
                    c1971d.f4033i = zM1486d;
                    arrayList = new ArrayList(c1971d.f4037m);
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: l */
        public final synchronized List<InterfaceC2022y0> m1494l() {
            C1971d c1971d = this.f4137f;
            if (c1971d == null) {
                return null;
            }
            return c1971d.m1461v(m1487e());
        }
    }

    public AbstractC1996l0(InterfaceC2018w0<T> interfaceC2018w0, String str, String str2) {
        this.f4128b = interfaceC2018w0;
        this.f4127a = new HashMap();
        this.f4129c = false;
        this.f4130d = str;
        this.f4131e = str2;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<T> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        boolean z2;
        AbstractC1996l0<K, T>.b bVar;
        try {
            C2030b.m1527b();
            interfaceC2020x0.mo1457o().mo1358e(interfaceC2020x0, this.f4130d);
            K kMo1477d = mo1477d(interfaceC2020x0);
            do {
                z2 = false;
                synchronized (this) {
                    synchronized (this) {
                        bVar = this.f4127a.get(kMo1477d);
                    }
                }
                if (bVar == null) {
                    synchronized (this) {
                        bVar = new b(kMo1477d);
                        this.f4127a.put(kMo1477d, bVar);
                        z2 = true;
                    }
                }
            } while (!bVar.m1483a(interfaceC1995l, interfaceC2020x0));
            if (z2) {
                bVar.m1491i(EnumC1716a.m1004f(interfaceC2020x0.mo1453k()));
            }
            C2030b.m1527b();
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract T mo1476c(T t);

    /* JADX INFO: renamed from: d */
    public abstract K mo1477d(InterfaceC2020x0 interfaceC2020x0);

    /* JADX INFO: renamed from: e */
    public synchronized void m1482e(K k, AbstractC1996l0<K, T>.b bVar) {
        if (this.f4127a.get(k) == bVar) {
            this.f4127a.remove(k);
        }
    }

    public AbstractC1996l0(InterfaceC2018w0<T> interfaceC2018w0, String str, String str2, boolean z2) {
        this.f4128b = interfaceC2018w0;
        this.f4127a = new HashMap();
        this.f4129c = z2;
        this.f4130d = str;
        this.f4131e = str2;
    }
}
