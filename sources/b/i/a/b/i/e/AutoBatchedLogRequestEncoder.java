package b.i.a.b.i.e;

import b.i.c.p.ObjectEncoder;
import b.i.c.p.ObjectEncoderContext;
import b.i.c.p.g.Configurator;
import b.i.c.p.g.EncoderConfig;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.b.i.e.b, reason: use source file name */
/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final Configurator a = new AutoBatchedLogRequestEncoder();

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$a */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class a implements ObjectEncoder<AndroidClientInfo> {
        public static final a a = new a();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("sdkVersion", androidClientInfo.l());
            objectEncoderContext2.f("model", androidClientInfo.i());
            objectEncoderContext2.f("hardware", androidClientInfo.e());
            objectEncoderContext2.f("device", androidClientInfo.c());
            objectEncoderContext2.f("product", androidClientInfo.k());
            objectEncoderContext2.f("osBuild", androidClientInfo.j());
            objectEncoderContext2.f("manufacturer", androidClientInfo.g());
            objectEncoderContext2.f("fingerprint", androidClientInfo.d());
            objectEncoderContext2.f("locale", androidClientInfo.f());
            objectEncoderContext2.f("country", androidClientInfo.b());
            objectEncoderContext2.f("mccMnc", androidClientInfo.h());
            objectEncoderContext2.f("applicationBuild", androidClientInfo.a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$b */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class b implements ObjectEncoder<BatchedLogRequest> {
        public static final b a = new b();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f("logRequest", ((BatchedLogRequest) obj).a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$c */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class c implements ObjectEncoder<ClientInfo2> {
        public static final c a = new c();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            ClientInfo2 clientInfo2 = (ClientInfo2) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("clientType", clientInfo2.b());
            objectEncoderContext2.f("androidClientInfo", clientInfo2.a());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$d */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class d implements ObjectEncoder<LogEvent> {
        public static final d a = new d();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogEvent logEvent = (LogEvent) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.b("eventTimeMs", logEvent.b());
            objectEncoderContext2.f("eventCode", logEvent.a());
            objectEncoderContext2.b("eventUptimeMs", logEvent.c());
            objectEncoderContext2.f("sourceExtension", logEvent.e());
            objectEncoderContext2.f("sourceExtensionJsonProto3", logEvent.f());
            objectEncoderContext2.b("timezoneOffsetSeconds", logEvent.g());
            objectEncoderContext2.f("networkConnectionInfo", logEvent.d());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$e */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class e implements ObjectEncoder<LogRequest> {
        public static final e a = new e();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogRequest logRequest = (LogRequest) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.b("requestTimeMs", logRequest.f());
            objectEncoderContext2.b("requestUptimeMs", logRequest.g());
            objectEncoderContext2.f("clientInfo", logRequest.a());
            objectEncoderContext2.f("logSource", logRequest.c());
            objectEncoderContext2.f("logSourceName", logRequest.d());
            objectEncoderContext2.f("logEvent", logRequest.b());
            objectEncoderContext2.f("qosTier", logRequest.e());
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.e.b$f */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class f implements ObjectEncoder<NetworkConnectionInfo> {
        public static final f a = new f();

        @Override // b.i.c.p.Encoder
        public void a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.f("networkType", networkConnectionInfo.b());
            objectEncoderContext2.f("mobileSubtype", networkConnectionInfo.a());
        }
    }

    public void a(EncoderConfig<?> encoderConfig) {
        b bVar = b.a;
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = (JsonDataEncoderBuilder5) encoderConfig;
        jsonDataEncoderBuilder5.f1761b.put(BatchedLogRequest.class, bVar);
        jsonDataEncoderBuilder5.c.remove(BatchedLogRequest.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_BatchedLogRequest.class, bVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_BatchedLogRequest.class);
        e eVar = e.a;
        jsonDataEncoderBuilder5.f1761b.put(LogRequest.class, eVar);
        jsonDataEncoderBuilder5.c.remove(LogRequest.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_LogRequest.class, eVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_LogRequest.class);
        c cVar = c.a;
        jsonDataEncoderBuilder5.f1761b.put(ClientInfo2.class, cVar);
        jsonDataEncoderBuilder5.c.remove(ClientInfo2.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_ClientInfo.class, cVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_ClientInfo.class);
        a aVar = a.a;
        jsonDataEncoderBuilder5.f1761b.put(AndroidClientInfo.class, aVar);
        jsonDataEncoderBuilder5.c.remove(AndroidClientInfo.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_AndroidClientInfo.class, aVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_AndroidClientInfo.class);
        d dVar = d.a;
        jsonDataEncoderBuilder5.f1761b.put(LogEvent.class, dVar);
        jsonDataEncoderBuilder5.c.remove(LogEvent.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_LogEvent.class, dVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_LogEvent.class);
        f fVar = f.a;
        jsonDataEncoderBuilder5.f1761b.put(NetworkConnectionInfo.class, fVar);
        jsonDataEncoderBuilder5.c.remove(NetworkConnectionInfo.class);
        jsonDataEncoderBuilder5.f1761b.put(AutoValue_NetworkConnectionInfo.class, fVar);
        jsonDataEncoderBuilder5.c.remove(AutoValue_NetworkConnectionInfo.class);
    }
}
