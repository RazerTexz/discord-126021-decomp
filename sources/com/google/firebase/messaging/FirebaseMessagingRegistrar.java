package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p228b.AbstractC2408c;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.InterfaceC2410e;
import p007b.p225i.p226a.p228b.InterfaceC2411f;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p228b.InterfaceC2413h;
import p007b.p225i.p226a.p228b.p229i.C2414a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p369m.p370d.p383r.C4730a;
import p007b.p225i.p361c.p396q.InterfaceC4799d;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p406w.C4874l;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseMessagingRegistrar implements InterfaceC4575g {

    /* JADX INFO: renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$b */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class C11090b<T> implements InterfaceC2411f<T> {
        public C11090b(C11089a c11089a) {
        }

        @Override // p007b.p225i.p226a.p228b.InterfaceC2411f
        /* JADX INFO: renamed from: a */
        public void mo2289a(AbstractC2408c<T> abstractC2408c) {
        }

        @Override // p007b.p225i.p226a.p228b.InterfaceC2411f
        /* JADX INFO: renamed from: b */
        public void mo2290b(AbstractC2408c<T> abstractC2408c, InterfaceC2413h interfaceC2413h) {
            ((C4730a) interfaceC2413h).mo2292a(null);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$c */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public static class C11091c implements InterfaceC2412g {
        @Override // p007b.p225i.p226a.p228b.InterfaceC2412g
        /* JADX INFO: renamed from: a */
        public <T> InterfaceC2411f<T> mo2291a(String str, Class<T> cls, C2407b c2407b, InterfaceC2410e<T, byte[]> interfaceC2410e) {
            return new C11090b(null);
        }
    }

    @VisibleForTesting
    public static InterfaceC2412g determineFactory(InterfaceC2412g interfaceC2412g) {
        if (interfaceC2412g != null) {
            Objects.requireNonNull(C2414a.f5127e);
            if (C2414a.f5126d.contains(new C2407b("json"))) {
                return interfaceC2412g;
            }
        }
        return new C11091c();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(InterfaceC4573e interfaceC4573e) {
        return new FirebaseMessaging((C4542c) interfaceC4573e.mo6346a(C4542c.class), (FirebaseInstanceId) interfaceC4573e.mo6346a(FirebaseInstanceId.class), interfaceC4573e.mo6355b(InterfaceC4896h.class), interfaceC4573e.mo6355b(InterfaceC4803d.class), (InterfaceC4843g) interfaceC4573e.mo6346a(InterfaceC4843g.class), determineFactory((InterfaceC2412g) interfaceC4573e.mo6346a(InterfaceC2412g.class)), (InterfaceC4799d) interfaceC4573e.mo6346a(InterfaceC4799d.class));
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    @Keep
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(FirebaseMessaging.class);
        bVarM6348a.m6351a(new C4583o(C4542c.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(FirebaseInstanceId.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4896h.class, 0, 1));
        bVarM6348a.m6351a(new C4583o(InterfaceC4803d.class, 0, 1));
        bVarM6348a.m6351a(new C4583o(InterfaceC2412g.class, 0, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4843g.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4799d.class, 1, 0));
        bVarM6348a.m6353c(C4874l.f13029a);
        bVarM6348a.m6354d(1);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-fcm", "20.1.7_1p"));
    }
}
