package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import b.i.a.b.b;
import b.i.a.b.i.a;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.l.d$b;
import b.i.c.l.e;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.r.d;
import b.i.c.w.l;
import b.i.c.x.h;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseMessagingRegistrar implements g {
    @VisibleForTesting
    public static b.i.a.b.g determineFactory(b.i.a.b.g gVar) {
        if (gVar != null) {
            Objects.requireNonNull(a.e);
            if (a.d.contains(new b("json"))) {
                return gVar;
            }
        }
        return new FirebaseMessagingRegistrar$c();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(e eVar) {
        return new FirebaseMessaging((c) eVar.a(c.class), (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class), eVar.b(h.class), eVar.b(d.class), (b.i.c.u.g) eVar.a(b.i.c.u.g.class), determineFactory((b.i.a.b.g) eVar.a(b.i.a.b.g.class)), (b.i.c.q.d) eVar.a(b.i.c.q.d.class));
    }

    @Override // b.i.c.l.g
    @Keep
    public List<b.i.c.l.d<?>> getComponents() {
        d$b d_bA = b.i.c.l.d.a(FirebaseMessaging.class);
        d_bA.a(new o(c.class, 1, 0));
        d_bA.a(new o(FirebaseInstanceId.class, 1, 0));
        d_bA.a(new o(h.class, 0, 1));
        d_bA.a(new o(d.class, 0, 1));
        d_bA.a(new o(b.i.a.b.g.class, 0, 0));
        d_bA.a(new o(b.i.c.u.g.class, 1, 0));
        d_bA.a(new o(b.i.c.q.d.class, 1, 0));
        d_bA.c(l.a);
        d_bA.d(1);
        return Arrays.asList(d_bA.b(), f.N("fire-fcm", "20.1.7_1p"));
    }
}
