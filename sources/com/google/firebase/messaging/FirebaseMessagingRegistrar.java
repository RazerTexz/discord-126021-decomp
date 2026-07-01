package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import b.i.a.b.Encoding2;
import b.i.a.b.Event2;
import b.i.a.b.Transformer;
import b.i.a.b.Transport2;
import b.i.a.b.TransportFactory;
import b.i.a.b.TransportScheduleCallback;
import b.i.a.b.i.CCTDestination;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender;
import b.i.c.q.Subscriber2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.u.g;
import b.i.c.w.l;
import b.i.c.x.UserAgentPublisher;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class b<T> implements Transport2<T> {
        public b(a aVar) {
        }

        @Override // b.i.a.b.Transport2
        public void a(Event2<T> event2) {
        }

        @Override // b.i.a.b.Transport2
        public void b(Event2<T> event2, TransportScheduleCallback transportScheduleCallback) {
            ((DataTransportCrashlyticsReportSender) transportScheduleCallback).a(null);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public static class c implements TransportFactory {
        @Override // b.i.a.b.TransportFactory
        public <T> Transport2<T> a(String str, Class<T> cls, Encoding2 encoding2, Transformer<T, byte[]> transformer) {
            return new b(null);
        }
    }

    @VisibleForTesting
    public static TransportFactory determineFactory(TransportFactory transportFactory) {
        if (transportFactory != null) {
            Objects.requireNonNull(CCTDestination.e);
            if (CCTDestination.d.contains(new Encoding2("json"))) {
                return transportFactory;
            }
        }
        return new c();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp2) componentContainer.a(FirebaseApp2.class), (FirebaseInstanceId) componentContainer.a(FirebaseInstanceId.class), componentContainer.b(UserAgentPublisher.class), componentContainer.b(HeartBeatInfo.class), (g) componentContainer.a(g.class), determineFactory((TransportFactory) componentContainer.a(TransportFactory.class)), (Subscriber2) componentContainer.a(Subscriber2.class));
    }

    @Override // b.i.c.l.ComponentRegistrar
    @Keep
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(FirebaseMessaging.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(FirebaseInstanceId.class, 1, 0));
        bVarA.a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarA.a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarA.a(new Dependency2(TransportFactory.class, 0, 0));
        bVarA.a(new Dependency2(g.class, 1, 0));
        bVarA.a(new Dependency2(Subscriber2.class, 1, 0));
        bVarA.c(l.a);
        bVarA.d(1);
        return Arrays.asList(bVarA.b(), f.N("fire-fcm", "20.1.7_1p"));
    }
}
