package b.i.c.m.d.m;

import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.p.ObjectEncoder;
import b.i.c.p.ObjectEncoderContext;
import b.i.c.p.g.Configurator;
import b.i.c.p.g.EncoderConfig;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.c.m.d.m.a, reason: use source file name */
/* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {
    public static final Configurator a = new AutoCrashlyticsReportEncoder();

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$a */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class a implements ObjectEncoder<CrashlyticsReport.b> {
        public static final a a = new a();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.b bVar = (CrashlyticsReport.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("key", bVar.a());
            objectEncoderContext2.f("value", bVar.b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$b */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class b implements ObjectEncoder<CrashlyticsReport> {
        public static final b a = new b();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("sdkVersion", crashlyticsReport.g());
            objectEncoderContext2.f("gmpAppId", crashlyticsReport.c());
            objectEncoderContext2.c("platform", crashlyticsReport.f());
            objectEncoderContext2.f("installationUuid", crashlyticsReport.d());
            objectEncoderContext2.f("buildVersion", crashlyticsReport.a());
            objectEncoderContext2.f("displayVersion", crashlyticsReport.b());
            objectEncoderContext2.f("session", crashlyticsReport.h());
            objectEncoderContext2.f("ndkPayload", crashlyticsReport.e());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$c */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class c implements ObjectEncoder<CrashlyticsReport.c> {
        public static final c a = new c();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f(ChatInputComponentTypes.FILES, cVar.a());
            objectEncoderContext2.f("orgId", cVar.b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$d */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class d implements ObjectEncoder<CrashlyticsReport.c.a> {
        public static final d a = new d();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.c.a aVar = (CrashlyticsReport.c.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("filename", aVar.b());
            objectEncoderContext2.f("contents", aVar.a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$e */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class e implements ObjectEncoder<CrashlyticsReport.d.a> {
        public static final e a = new e();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.a aVar = (CrashlyticsReport.d.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("identifier", aVar.d());
            objectEncoderContext2.f("version", aVar.g());
            objectEncoderContext2.f("displayVersion", aVar.c());
            objectEncoderContext2.f("organization", aVar.f());
            objectEncoderContext2.f("installationUuid", aVar.e());
            objectEncoderContext2.f("developmentPlatform", aVar.a());
            objectEncoderContext2.f("developmentPlatformVersion", aVar.b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$f */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class f implements ObjectEncoder<CrashlyticsReport.d.a.AbstractC0048a> {
        public static final f a = new f();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f("clsId", ((CrashlyticsReport.d.a.AbstractC0048a) obj).a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$g */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class g implements ObjectEncoder<CrashlyticsReport.d.c> {
        public static final g a = new g();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.c cVar = (CrashlyticsReport.d.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.c("arch", cVar.a());
            objectEncoderContext2.f("model", cVar.e());
            objectEncoderContext2.c("cores", cVar.b());
            objectEncoderContext2.b("ram", cVar.g());
            objectEncoderContext2.b("diskSpace", cVar.c());
            objectEncoderContext2.a("simulator", cVar.i());
            objectEncoderContext2.c("state", cVar.h());
            objectEncoderContext2.f("manufacturer", cVar.d());
            objectEncoderContext2.f("modelClass", cVar.f());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$h */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class h implements ObjectEncoder<CrashlyticsReport.d> {
        public static final h a = new h();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d dVar = (CrashlyticsReport.d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("generator", dVar.e());
            objectEncoderContext2.f("identifier", dVar.g().getBytes(CrashlyticsReport.a));
            objectEncoderContext2.b("startedAt", dVar.i());
            objectEncoderContext2.f("endedAt", dVar.c());
            objectEncoderContext2.a("crashed", dVar.k());
            objectEncoderContext2.f("app", dVar.a());
            objectEncoderContext2.f("user", dVar.j());
            objectEncoderContext2.f("os", dVar.h());
            objectEncoderContext2.f("device", dVar.b());
            objectEncoderContext2.f("events", dVar.d());
            objectEncoderContext2.c("generatorType", dVar.f());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$i */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class i implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a> {
        public static final i a = new i();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a aVar = (CrashlyticsReport.d.AbstractC0049d.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("execution", aVar.c());
            objectEncoderContext2.f("customAttributes", aVar.b());
            objectEncoderContext2.f("background", aVar.a());
            objectEncoderContext2.c("uiOrientation", aVar.d());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$j */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class j implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a> {
        public static final j a = new j();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a abstractC0051a = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.b("baseAddress", abstractC0051a.a());
            objectEncoderContext2.b("size", abstractC0051a.c());
            objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC0051a.b());
            String strD = abstractC0051a.d();
            objectEncoderContext2.f("uuid", strD != null ? strD.getBytes(CrashlyticsReport.a) : null);
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$k */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class k implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b> {
        public static final k a = new k();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b bVar = (CrashlyticsReport.d.AbstractC0049d.a.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("threads", bVar.d());
            objectEncoderContext2.f("exception", bVar.b());
            objectEncoderContext2.f("signal", bVar.c());
            objectEncoderContext2.f("binaries", bVar.a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$l */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class l implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b> {
        public static final l a = new l();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052b = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("type", abstractC0052b.e());
            objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_REASON, abstractC0052b.d());
            objectEncoderContext2.f("frames", abstractC0052b.b());
            objectEncoderContext2.f("causedBy", abstractC0052b.a());
            objectEncoderContext2.c("overflowCount", abstractC0052b.c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$m */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class m implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b.c> {
        public static final m a = new m();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b.c cVar = (CrashlyticsReport.d.AbstractC0049d.a.b.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, cVar.c());
            objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_CODE, cVar.b());
            objectEncoderContext2.b("address", cVar.a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$n */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class n implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d> {
        public static final n a = new n();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d abstractC0053d = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC0053d.c());
            objectEncoderContext2.c("importance", abstractC0053d.b());
            objectEncoderContext2.f("frames", abstractC0053d.a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$o */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class o implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a> {
        public static final o a = new o();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a abstractC0054a = (CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.b("pc", abstractC0054a.d());
            objectEncoderContext2.f("symbol", abstractC0054a.e());
            objectEncoderContext2.f("file", abstractC0054a.a());
            objectEncoderContext2.b("offset", abstractC0054a.c());
            objectEncoderContext2.c("importance", abstractC0054a.b());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$p */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class p implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.b> {
        public static final p a = new p();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d.b bVar = (CrashlyticsReport.d.AbstractC0049d.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("batteryLevel", bVar.a());
            objectEncoderContext2.c("batteryVelocity", bVar.b());
            objectEncoderContext2.a("proximityOn", bVar.f());
            objectEncoderContext2.c("orientation", bVar.d());
            objectEncoderContext2.b("ramUsed", bVar.e());
            objectEncoderContext2.b("diskUsed", bVar.c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$q */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class q implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d> {
        public static final q a = new q();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC0049d abstractC0049d = (CrashlyticsReport.d.AbstractC0049d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.b("timestamp", abstractC0049d.d());
            objectEncoderContext2.f("type", abstractC0049d.e());
            objectEncoderContext2.f("app", abstractC0049d.a());
            objectEncoderContext2.f("device", abstractC0049d.b());
            objectEncoderContext2.f("log", abstractC0049d.c());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$r */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class r implements ObjectEncoder<CrashlyticsReport.d.AbstractC0049d.c> {
        public static final r a = new r();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f("content", ((CrashlyticsReport.d.AbstractC0049d.c) obj).a());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$s */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class s implements ObjectEncoder<CrashlyticsReport.d.e> {
        public static final s a = new s();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.e eVar = (CrashlyticsReport.d.e) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.c("platform", eVar.b());
            objectEncoderContext2.f("version", eVar.c());
            objectEncoderContext2.f("buildVersion", eVar.a());
            objectEncoderContext2.a("jailbroken", eVar.d());
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.m.a$t */
    /* JADX INFO: compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class t implements ObjectEncoder<CrashlyticsReport.d.f> {
        public static final t a = new t();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f("identifier", ((CrashlyticsReport.d.f) obj).a());
        }
    }

    public void a(EncoderConfig<?> encoderConfig) {
        b bVar = b.a;
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = (JsonDataEncoderBuilder5) encoderConfig;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.class, bVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport.class, bVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport.class);
        h hVar = h.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.class, hVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session.class, hVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session.class);
        e eVar = e.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.a.class, eVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Application.class, eVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Application.class);
        f fVar = f.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.a.AbstractC0048a.class, fVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.a.AbstractC0048a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Application_Organization.class, fVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Application_Organization.class);
        t tVar = t.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.f.class, tVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.f.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_User.class, tVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_User.class);
        s sVar = s.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.e.class, sVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.e.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, sVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_OperatingSystem.class);
        g gVar = g.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.c.class, gVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.c.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Device.class, gVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Device.class);
        q qVar = q.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.class, qVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event.class, qVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event.class);
        i iVar = i.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.class, iVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application.class, iVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application.class);
        k kVar = k.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.class, kVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, kVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class);
        n nVar = n.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.class, nVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, nVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class);
        o oVar = o.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a.class, oVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, oVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class);
        l lVar = l.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b.class, lVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, lVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class);
        m mVar = m.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.c.class, mVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.c.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, mVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class);
        j jVar = j.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a.class, jVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, jVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class);
        a aVar = a.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.b.class, aVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.b.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_CustomAttribute.class, aVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_CustomAttribute.class);
        p pVar = p.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.b.class, pVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.b.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Device.class, pVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Device.class);
        r rVar = r.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.d.AbstractC0049d.c.class, rVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.d.AbstractC0049d.c.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_Session_Event_Log.class, rVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_Session_Event_Log.class);
        c cVar = c.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.c.class, cVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.c.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_FilesPayload.class, cVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_FilesPayload.class);
        d dVar = d.a;
        jsonDataEncoderBuilder5.f1761b.put(CrashlyticsReport.c.a.class, dVar);
        jsonDataEncoderBuilder5.c.remove(CrashlyticsReport.c.a.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_CrashlyticsReport_FilesPayload_File.class, dVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_CrashlyticsReport_FilesPayload_File.class);
    }
}
