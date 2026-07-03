package p007b.p225i.p361c.p369m.p370d.p375m;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p393p.InterfaceC4784c;
import p007b.p225i.p361c.p393p.InterfaceC4785d;
import p007b.p225i.p361c.p393p.p394g.InterfaceC4788a;
import p007b.p225i.p361c.p393p.p394g.InterfaceC4789b;
import p007b.p225i.p361c.p393p.p395h.C4794e;

/* JADX INFO: renamed from: b.i.c.m.d.m.a */
/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4674a implements InterfaceC4788a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4788a f12497a = new C4674a();

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$a */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class a implements InterfaceC4784c<AbstractC4695v.b> {

        /* JADX INFO: renamed from: a */
        public static final a f12498a = new a();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.b bVar = (AbstractC4695v.b) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("key", bVar.mo6525a());
            interfaceC4785d2.mo6708f("value", bVar.mo6526b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$b */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class b implements InterfaceC4784c<AbstractC4695v> {

        /* JADX INFO: renamed from: a */
        public static final b f12499a = new b();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v abstractC4695v = (AbstractC4695v) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("sdkVersion", abstractC4695v.mo6521g());
            interfaceC4785d2.mo6708f("gmpAppId", abstractC4695v.mo6517c());
            interfaceC4785d2.mo6707c("platform", abstractC4695v.mo6520f());
            interfaceC4785d2.mo6708f("installationUuid", abstractC4695v.mo6518d());
            interfaceC4785d2.mo6708f("buildVersion", abstractC4695v.mo6515a());
            interfaceC4785d2.mo6708f("displayVersion", abstractC4695v.mo6516b());
            interfaceC4785d2.mo6708f("session", abstractC4695v.mo6522h());
            interfaceC4785d2.mo6708f("ndkPayload", abstractC4695v.mo6519e());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$c */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class c implements InterfaceC4784c<AbstractC4695v.c> {

        /* JADX INFO: renamed from: a */
        public static final c f12500a = new c();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.c cVar = (AbstractC4695v.c) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f(ChatInputComponentTypes.FILES, cVar.mo6527a());
            interfaceC4785d2.mo6708f("orgId", cVar.mo6528b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$d */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class d implements InterfaceC4784c<AbstractC4695v.c.a> {

        /* JADX INFO: renamed from: a */
        public static final d f12501a = new d();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.c.a aVar = (AbstractC4695v.c.a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("filename", aVar.mo6530b());
            interfaceC4785d2.mo6708f("contents", aVar.mo6529a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$e */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class e implements InterfaceC4784c<AbstractC4695v.d.a> {

        /* JADX INFO: renamed from: a */
        public static final e f12502a = new e();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.a aVar = (AbstractC4695v.d.a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("identifier", aVar.mo6548d());
            interfaceC4785d2.mo6708f("version", aVar.mo6551g());
            interfaceC4785d2.mo6708f("displayVersion", aVar.mo6547c());
            interfaceC4785d2.mo6708f("organization", aVar.mo6550f());
            interfaceC4785d2.mo6708f("installationUuid", aVar.mo6549e());
            interfaceC4785d2.mo6708f("developmentPlatform", aVar.mo6545a());
            interfaceC4785d2.mo6708f("developmentPlatformVersion", aVar.mo6546b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$f */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class f implements InterfaceC4784c<AbstractC4695v.d.a.AbstractC13232a> {

        /* JADX INFO: renamed from: a */
        public static final f f12503a = new f();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            interfaceC4785d.mo6708f("clsId", ((AbstractC4695v.d.a.AbstractC13232a) obj).mo6552a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$g */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class g implements InterfaceC4784c<AbstractC4695v.d.c> {

        /* JADX INFO: renamed from: a */
        public static final g f12504a = new g();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.c cVar = (AbstractC4695v.d.c) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6707c("arch", cVar.mo6553a());
            interfaceC4785d2.mo6708f("model", cVar.mo6557e());
            interfaceC4785d2.mo6707c("cores", cVar.mo6554b());
            interfaceC4785d2.mo6706b("ram", cVar.mo6559g());
            interfaceC4785d2.mo6706b("diskSpace", cVar.mo6555c());
            interfaceC4785d2.mo6705a("simulator", cVar.mo6561i());
            interfaceC4785d2.mo6707c("state", cVar.mo6560h());
            interfaceC4785d2.mo6708f("manufacturer", cVar.mo6556d());
            interfaceC4785d2.mo6708f("modelClass", cVar.mo6558f());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$h */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class h implements InterfaceC4784c<AbstractC4695v.d> {

        /* JADX INFO: renamed from: a */
        public static final h f12505a = new h();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d dVar = (AbstractC4695v.d) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("generator", dVar.mo6535e());
            interfaceC4785d2.mo6708f("identifier", dVar.mo6537g().getBytes(AbstractC4695v.f12647a));
            interfaceC4785d2.mo6706b("startedAt", dVar.mo6539i());
            interfaceC4785d2.mo6708f("endedAt", dVar.mo6533c());
            interfaceC4785d2.mo6705a("crashed", dVar.mo6541k());
            interfaceC4785d2.mo6708f("app", dVar.mo6531a());
            interfaceC4785d2.mo6708f("user", dVar.mo6540j());
            interfaceC4785d2.mo6708f("os", dVar.mo6538h());
            interfaceC4785d2.mo6708f("device", dVar.mo6532b());
            interfaceC4785d2.mo6708f("events", dVar.mo6534d());
            interfaceC4785d2.mo6707c("generatorType", dVar.mo6536f());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$i */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class i implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a> {

        /* JADX INFO: renamed from: a */
        public static final i f12506a = new i();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a aVar = (AbstractC4695v.d.AbstractC13233d.a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("execution", aVar.mo6570c());
            interfaceC4785d2.mo6708f("customAttributes", aVar.mo6569b());
            interfaceC4785d2.mo6708f("background", aVar.mo6568a());
            interfaceC4785d2.mo6707c("uiOrientation", aVar.mo6571d());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$j */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class j implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a> {

        /* JADX INFO: renamed from: a */
        public static final j f12507a = new j();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a abstractC13235a = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6706b("baseAddress", abstractC13235a.mo6578a());
            interfaceC4785d2.mo6706b("size", abstractC13235a.mo6580c());
            interfaceC4785d2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC13235a.mo6579b());
            String strMo6581d = abstractC13235a.mo6581d();
            interfaceC4785d2.mo6708f("uuid", strMo6581d != null ? strMo6581d.getBytes(AbstractC4695v.f12647a) : null);
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$k */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class k implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b> {

        /* JADX INFO: renamed from: a */
        public static final k f12508a = new k();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b bVar = (AbstractC4695v.d.AbstractC13233d.a.b) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("threads", bVar.mo6577d());
            interfaceC4785d2.mo6708f("exception", bVar.mo6575b());
            interfaceC4785d2.mo6708f("signal", bVar.mo6576c());
            interfaceC4785d2.mo6708f("binaries", bVar.mo6574a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$l */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class l implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b> {

        /* JADX INFO: renamed from: a */
        public static final l f12509a = new l();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("type", abstractC13236b.mo6586e());
            interfaceC4785d2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_REASON, abstractC13236b.mo6585d());
            interfaceC4785d2.mo6708f("frames", abstractC13236b.mo6583b());
            interfaceC4785d2.mo6708f("causedBy", abstractC13236b.mo6582a());
            interfaceC4785d2.mo6707c("overflowCount", abstractC13236b.mo6584c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$m */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class m implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b.c> {

        /* JADX INFO: renamed from: a */
        public static final m f12510a = new m();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b.c cVar = (AbstractC4695v.d.AbstractC13233d.a.b.c) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, cVar.mo6589c());
            interfaceC4785d2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_CODE, cVar.mo6588b());
            interfaceC4785d2.mo6706b("address", cVar.mo6587a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$n */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class n implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d> {

        /* JADX INFO: renamed from: a */
        public static final n f12511a = new n();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d abstractC13237d = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC13237d.mo6592c());
            interfaceC4785d2.mo6707c("importance", abstractC13237d.mo6591b());
            interfaceC4785d2.mo6708f("frames", abstractC13237d.mo6590a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$o */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class o implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> {

        /* JADX INFO: renamed from: a */
        public static final o f12512a = new o();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a abstractC13238a = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6706b("pc", abstractC13238a.mo6596d());
            interfaceC4785d2.mo6708f("symbol", abstractC13238a.mo6597e());
            interfaceC4785d2.mo6708f("file", abstractC13238a.mo6593a());
            interfaceC4785d2.mo6706b("offset", abstractC13238a.mo6595c());
            interfaceC4785d2.mo6707c("importance", abstractC13238a.mo6594b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$p */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class p implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.b> {

        /* JADX INFO: renamed from: a */
        public static final p f12513a = new p();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d.b bVar = (AbstractC4695v.d.AbstractC13233d.b) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6708f("batteryLevel", bVar.mo6599a());
            interfaceC4785d2.mo6707c("batteryVelocity", bVar.mo6600b());
            interfaceC4785d2.mo6705a("proximityOn", bVar.mo6604f());
            interfaceC4785d2.mo6707c("orientation", bVar.mo6602d());
            interfaceC4785d2.mo6706b("ramUsed", bVar.mo6603e());
            interfaceC4785d2.mo6706b("diskUsed", bVar.mo6601c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$q */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class q implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d> {

        /* JADX INFO: renamed from: a */
        public static final q f12514a = new q();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.AbstractC13233d abstractC13233d = (AbstractC4695v.d.AbstractC13233d) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6706b("timestamp", abstractC13233d.mo6566d());
            interfaceC4785d2.mo6708f("type", abstractC13233d.mo6567e());
            interfaceC4785d2.mo6708f("app", abstractC13233d.mo6563a());
            interfaceC4785d2.mo6708f("device", abstractC13233d.mo6564b());
            interfaceC4785d2.mo6708f("log", abstractC13233d.mo6565c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$r */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class r implements InterfaceC4784c<AbstractC4695v.d.AbstractC13233d.c> {

        /* JADX INFO: renamed from: a */
        public static final r f12515a = new r();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            interfaceC4785d.mo6708f("content", ((AbstractC4695v.d.AbstractC13233d.c) obj).mo6606a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$s */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class s implements InterfaceC4784c<AbstractC4695v.d.e> {

        /* JADX INFO: renamed from: a */
        public static final s f12516a = new s();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            AbstractC4695v.d.e eVar = (AbstractC4695v.d.e) obj;
            InterfaceC4785d interfaceC4785d2 = interfaceC4785d;
            interfaceC4785d2.mo6707c("platform", eVar.mo6608b());
            interfaceC4785d2.mo6708f("version", eVar.mo6609c());
            interfaceC4785d2.mo6708f("buildVersion", eVar.mo6607a());
            interfaceC4785d2.mo6705a("jailbroken", eVar.mo6610d());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$t */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class t implements InterfaceC4784c<AbstractC4695v.d.f> {

        /* JADX INFO: renamed from: a */
        public static final t f12517a = new t();

        @Override // p007b.p225i.p361c.p393p.InterfaceC4783b
        /* JADX INFO: renamed from: a */
        public void mo2312a(Object obj, InterfaceC4785d interfaceC4785d) throws IOException {
            interfaceC4785d.mo6708f("identifier", ((AbstractC4695v.d.f) obj).mo6611a());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6514a(InterfaceC4789b<?> interfaceC4789b) {
        b bVar = b.f12499a;
        C4794e c4794e = (C4794e) interfaceC4789b;
        c4794e.f12822b.put(AbstractC4695v.class, bVar);
        c4794e.f12823c.remove(AbstractC4695v.class);
        c4794e.f12822b.put(C4675b.class, bVar);
        c4794e.f12823c.remove(C4675b.class);
        h hVar = h.f12505a;
        c4794e.f12822b.put(AbstractC4695v.d.class, hVar);
        c4794e.f12823c.remove(AbstractC4695v.d.class);
        c4794e.f12822b.put(C4679f.class, hVar);
        c4794e.f12823c.remove(C4679f.class);
        e eVar = e.f12502a;
        c4794e.f12822b.put(AbstractC4695v.d.a.class, eVar);
        c4794e.f12823c.remove(AbstractC4695v.d.a.class);
        c4794e.f12822b.put(C4680g.class, eVar);
        c4794e.f12823c.remove(C4680g.class);
        f fVar = f.f12503a;
        c4794e.f12822b.put(AbstractC4695v.d.a.AbstractC13232a.class, fVar);
        c4794e.f12823c.remove(AbstractC4695v.d.a.AbstractC13232a.class);
        c4794e.f12822b.put(C4681h.class, fVar);
        c4794e.f12823c.remove(C4681h.class);
        t tVar = t.f12517a;
        c4794e.f12822b.put(AbstractC4695v.d.f.class, tVar);
        c4794e.f12823c.remove(AbstractC4695v.d.f.class);
        c4794e.f12822b.put(C4694u.class, tVar);
        c4794e.f12823c.remove(C4694u.class);
        s sVar = s.f12516a;
        c4794e.f12822b.put(AbstractC4695v.d.e.class, sVar);
        c4794e.f12823c.remove(AbstractC4695v.d.e.class);
        c4794e.f12822b.put(C4693t.class, sVar);
        c4794e.f12823c.remove(C4693t.class);
        g gVar = g.f12504a;
        c4794e.f12822b.put(AbstractC4695v.d.c.class, gVar);
        c4794e.f12823c.remove(AbstractC4695v.d.c.class);
        c4794e.f12822b.put(C4682i.class, gVar);
        c4794e.f12823c.remove(C4682i.class);
        q qVar = q.f12514a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.class, qVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.class);
        c4794e.f12822b.put(C4683j.class, qVar);
        c4794e.f12823c.remove(C4683j.class);
        i iVar = i.f12506a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.class, iVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.class);
        c4794e.f12822b.put(C4684k.class, iVar);
        c4794e.f12823c.remove(C4684k.class);
        k kVar = k.f12508a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.class, kVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.class);
        c4794e.f12822b.put(C4685l.class, kVar);
        c4794e.f12823c.remove(C4685l.class);
        n nVar = n.f12511a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.class, nVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.class);
        c4794e.f12822b.put(C4689p.class, nVar);
        c4794e.f12823c.remove(C4689p.class);
        o oVar = o.f12512a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a.class, oVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a.class);
        c4794e.f12822b.put(C4690q.class, oVar);
        c4794e.f12823c.remove(C4690q.class);
        l lVar = l.f12509a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b.class, lVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b.class);
        c4794e.f12822b.put(C4687n.class, lVar);
        c4794e.f12823c.remove(C4687n.class);
        m mVar = m.f12510a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.c.class, mVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.c.class);
        c4794e.f12822b.put(C4688o.class, mVar);
        c4794e.f12823c.remove(C4688o.class);
        j jVar = j.f12507a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a.class, jVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a.class);
        c4794e.f12822b.put(C4686m.class, jVar);
        c4794e.f12823c.remove(C4686m.class);
        a aVar = a.f12498a;
        c4794e.f12822b.put(AbstractC4695v.b.class, aVar);
        c4794e.f12823c.remove(AbstractC4695v.b.class);
        c4794e.f12822b.put(C4676c.class, aVar);
        c4794e.f12823c.remove(C4676c.class);
        p pVar = p.f12513a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.b.class, pVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.b.class);
        c4794e.f12822b.put(C4691r.class, pVar);
        c4794e.f12823c.remove(C4691r.class);
        r rVar = r.f12515a;
        c4794e.f12822b.put(AbstractC4695v.d.AbstractC13233d.c.class, rVar);
        c4794e.f12823c.remove(AbstractC4695v.d.AbstractC13233d.c.class);
        c4794e.f12822b.put(C4692s.class, rVar);
        c4794e.f12823c.remove(C4692s.class);
        c cVar = c.f12500a;
        c4794e.f12822b.put(AbstractC4695v.c.class, cVar);
        c4794e.f12823c.remove(AbstractC4695v.c.class);
        c4794e.f12822b.put(C4677d.class, cVar);
        c4794e.f12823c.remove(C4677d.class);
        d dVar = d.f12501a;
        c4794e.f12822b.put(AbstractC4695v.c.a.class, dVar);
        c4794e.f12823c.remove(AbstractC4695v.c.a.class);
        c4794e.f12822b.put(C4678e.class, dVar);
        c4794e.f12823c.remove(C4678e.class);
    }
}
