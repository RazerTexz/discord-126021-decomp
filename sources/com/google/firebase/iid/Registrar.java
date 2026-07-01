package com.google.firebase.iid;

import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.s.r;
import b.i.c.s.s;
import b.i.c.u.g;
import b.i.c.x.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class Registrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a implements b.i.c.s.e0.a {
        public a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp2) componentContainer.a(FirebaseApp2.class), componentContainer.b(UserAgentPublisher.class), componentContainer.b(HeartBeatInfo.class), (g) componentContainer.a(g.class));
    }

    public static final /* synthetic */ b.i.c.s.e0.a lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        return new a((FirebaseInstanceId) componentContainer.a(FirebaseInstanceId.class));
    }

    @Override // b.i.c.l.ComponentRegistrar
    @Keep
    public final List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(FirebaseInstanceId.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarA.a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarA.a(new Dependency2(g.class, 1, 0));
        bVarA.c(r.a);
        bVarA.d(1);
        Component4 component4B = bVarA.b();
        Component4.b bVarA2 = Component4.a(b.i.c.s.e0.a.class);
        bVarA2.a(new Dependency2(FirebaseInstanceId.class, 1, 0));
        bVarA2.c(s.a);
        return Arrays.asList(component4B, bVarA2.b(), f.N("fire-iid", "21.0.0"));
    }
}
