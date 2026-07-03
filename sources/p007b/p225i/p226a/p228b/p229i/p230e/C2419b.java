package p007b.p225i.p226a.p228b.p229i.p230e;

import java.io.IOException;
import p007b.p225i.p361c.p393p.InterfaceC4784c;
import p007b.p225i.p361c.p393p.InterfaceC4785d;
import p007b.p225i.p361c.p393p.p394g.InterfaceC4788a;
import p007b.p225i.p361c.p393p.p394g.InterfaceC4789b;
import p007b.p225i.p361c.p393p.p395h.C4794e;

/* JADX INFO: renamed from: b.i.a.b.i.e.b */
/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2419b implements InterfaceC4788a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4788a f5145a = new C2419b();

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$a */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class a implements InterfaceC4784c<AbstractC2418a> {

        /* JADX INFO: renamed from: a */
        public static final a f5146a = new a();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC2418a abstractC2418a = (AbstractC2418a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("sdkVersion", abstractC2418a.mo2310l());
            interfaceC4785d2.mo6708f("model", abstractC2418a.mo2307i());
            interfaceC4785d2.mo6708f("hardware", abstractC2418a.mo2303e());
            interfaceC4785d2.mo6708f("device", abstractC2418a.mo2301c());
            interfaceC4785d2.mo6708f("product", abstractC2418a.mo2309k());
            interfaceC4785d2.mo6708f("osBuild", abstractC2418a.mo2308j());
            interfaceC4785d2.mo6708f("manufacturer", abstractC2418a.mo2305g());
            interfaceC4785d2.mo6708f("fingerprint", abstractC2418a.mo2302d());
            interfaceC4785d2.mo6708f("locale", abstractC2418a.mo2304f());
            interfaceC4785d2.mo6708f("country", abstractC2418a.mo2300b());
            interfaceC4785d2.mo6708f("mccMnc", abstractC2418a.mo2306h());
            interfaceC4785d2.mo6708f("applicationBuild", abstractC2418a.mo2299a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$b */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class b implements InterfaceC4784c<AbstractC2427j> {

        /* JADX INFO: renamed from: a */
        public static final b f5147a = new b();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            interfaceC4785d.mo6708f("logRequest", ((AbstractC2427j) obj).mo2313a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$c */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class c implements InterfaceC4784c<AbstractC2428k> {

        /* JADX INFO: renamed from: a */
        public static final c f5148a = new c();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC2428k abstractC2428k = (AbstractC2428k) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("clientType", abstractC2428k.mo2315b());
            interfaceC4785d2.mo6708f("androidClientInfo", abstractC2428k.mo2314a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$d */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class d implements InterfaceC4784c<AbstractC2429l> {

        /* JADX INFO: renamed from: a */
        public static final d f5149a = new d();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC2429l abstractC2429l = (AbstractC2429l) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6706b("eventTimeMs", abstractC2429l.mo2317b());
            interfaceC4785d2.mo6708f("eventCode", abstractC2429l.mo2316a());
            interfaceC4785d2.mo6706b("eventUptimeMs", abstractC2429l.mo2318c());
            interfaceC4785d2.mo6708f("sourceExtension", abstractC2429l.mo2320e());
            interfaceC4785d2.mo6708f("sourceExtensionJsonProto3", abstractC2429l.mo2321f());
            interfaceC4785d2.mo6706b("timezoneOffsetSeconds", abstractC2429l.mo2322g());
            interfaceC4785d2.mo6708f("networkConnectionInfo", abstractC2429l.mo2319d());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$e */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class e implements InterfaceC4784c<AbstractC2430m> {

        /* JADX INFO: renamed from: a */
        public static final e f5150a = new e();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC2430m abstractC2430m = (AbstractC2430m) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6706b("requestTimeMs", abstractC2430m.mo2328f());
            interfaceC4785d2.mo6706b("requestUptimeMs", abstractC2430m.mo2329g());
            interfaceC4785d2.mo6708f("clientInfo", abstractC2430m.mo2323a());
            interfaceC4785d2.mo6708f("logSource", abstractC2430m.mo2325c());
            interfaceC4785d2.mo6708f("logSourceName", abstractC2430m.mo2326d());
            interfaceC4785d2.mo6708f("logEvent", abstractC2430m.mo2324b());
            interfaceC4785d2.mo6708f("qosTier", abstractC2430m.mo2327e());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$f */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class f implements InterfaceC4784c<AbstractC2432o> {

        /* JADX INFO: renamed from: a */
        public static final f f5151a = new f();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC2432o abstractC2432o = (AbstractC2432o) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("networkType", abstractC2432o.mo2332b());
            interfaceC4785d2.mo6708f("mobileSubtype", abstractC2432o.mo2331a());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2311a(InterfaceC4789b<?> interfaceC4789b) {
        b bVar = b.f5147a;
        C4794e c4794e = (C4794e) interfaceC4789b;
        c4794e.f12822b.put(AbstractC2427j.class, bVar);
        c4794e.f12823c.remove(AbstractC2427j.class);
        c4794e.f12822b.put(C2421d.class, bVar);
        c4794e.f12823c.remove(C2421d.class);
        e eVar = e.f5150a;
        c4794e.f12822b.put(AbstractC2430m.class, eVar);
        c4794e.f12823c.remove(AbstractC2430m.class);
        c4794e.f12822b.put(C2424g.class, eVar);
        c4794e.f12823c.remove(C2424g.class);
        c cVar = c.f5148a;
        c4794e.f12822b.put(AbstractC2428k.class, cVar);
        c4794e.f12823c.remove(AbstractC2428k.class);
        c4794e.f12822b.put(C2422e.class, cVar);
        c4794e.f12823c.remove(C2422e.class);
        a aVar = a.f5146a;
        c4794e.f12822b.put(AbstractC2418a.class, aVar);
        c4794e.f12823c.remove(AbstractC2418a.class);
        c4794e.f12822b.put(C2420c.class, aVar);
        c4794e.f12823c.remove(C2420c.class);
        d dVar = d.f5149a;
        c4794e.f12822b.put(AbstractC2429l.class, dVar);
        c4794e.f12823c.remove(AbstractC2429l.class);
        c4794e.f12822b.put(C2423f.class, dVar);
        c4794e.f12823c.remove(C2423f.class);
        f fVar = f.f5151a;
        c4794e.f12822b.put(AbstractC2432o.class, fVar);
        c4794e.f12823c.remove(AbstractC2432o.class);
        c4794e.f12822b.put(C2426i.class, fVar);
        c4794e.f12823c.remove(C2426i.class);
    }
}
