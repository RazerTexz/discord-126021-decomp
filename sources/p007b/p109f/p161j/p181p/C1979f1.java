package p007b.p109f.p161j.p181p;

import java.util.Objects;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.p.f1 */
/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1979f1<T> implements InterfaceC2018w0<T> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<T> f4051a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1982g1 f4052b;

    /* JADX INFO: renamed from: b.f.j.p.f1$a */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class a extends AbstractRunnableC1976e1<T> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ InterfaceC2024z0 f4053o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ InterfaceC2020x0 f4054p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ InterfaceC1995l f4055q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC1995l interfaceC1995l, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, String str, InterfaceC2024z0 interfaceC2024z1, InterfaceC2020x0 interfaceC2020x1, InterfaceC1995l interfaceC1995l2) {
            super(interfaceC1995l, interfaceC2024z0, interfaceC2020x0, str);
            this.f4053o = interfaceC2024z1;
            this.f4054p = interfaceC2020x1;
            this.f4055q = interfaceC1995l2;
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: b */
        public void mo1465b(T t) {
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: d */
        public T mo1467d() throws Exception {
            return null;
        }

        @Override // p007b.p109f.p161j.p181p.AbstractRunnableC1976e1
        /* JADX INFO: renamed from: g */
        public void mo1470g(T t) {
            this.f4053o.mo1363j(this.f4054p, "BackgroundThreadHandoffProducer", null);
            C1979f1.this.f4051a.mo1417b(this.f4055q, this.f4054p);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.f1$b */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class b extends C1974e {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractRunnableC1976e1 f4057a;

        public b(AbstractRunnableC1976e1 abstractRunnableC1976e1) {
            this.f4057a = abstractRunnableC1976e1;
        }

        @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4057a.m1464a();
            InterfaceC1982g1 interfaceC1982g1 = C1979f1.this.f4052b;
            AbstractRunnableC1976e1 abstractRunnableC1976e1 = this.f4057a;
            C1985h1 c1985h1 = (C1985h1) interfaceC1982g1;
            synchronized (c1985h1) {
                c1985h1.f4073a.remove(abstractRunnableC1976e1);
            }
        }
    }

    public C1979f1(InterfaceC2018w0<T> interfaceC2018w0, InterfaceC1982g1 interfaceC1982g1) {
        Objects.requireNonNull(interfaceC2018w0);
        this.f4051a = interfaceC2018w0;
        this.f4052b = interfaceC1982g1;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<T> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        try {
            C2030b.m1527b();
            InterfaceC2024z0 interfaceC2024z0Mo1457o = interfaceC2020x0.mo1457o();
            Objects.requireNonNull(interfaceC2020x0.mo1449g().getExperiments());
            a aVar = new a(interfaceC1995l, interfaceC2024z0Mo1457o, interfaceC2020x0, "BackgroundThreadHandoffProducer", interfaceC2024z0Mo1457o, interfaceC2020x0, interfaceC1995l);
            interfaceC2020x0.mo1448f(new b(aVar));
            C1985h1 c1985h1 = (C1985h1) this.f4052b;
            synchronized (c1985h1) {
                c1985h1.f4074b.execute(aVar);
            }
            C2030b.m1527b();
        } catch (Throwable th) {
            C2030b.m1527b();
            throw th;
        }
    }
}
