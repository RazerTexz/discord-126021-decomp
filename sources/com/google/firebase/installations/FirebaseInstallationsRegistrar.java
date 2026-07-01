package com.google.firebase.installations;

import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.u.FirebaseInstallations4;
import b.i.c.u.g;
import b.i.c.x.UserAgentPublisher;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ g lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations4((FirebaseApp2) componentContainer.a(FirebaseApp2.class), componentContainer.b(UserAgentPublisher.class), componentContainer.b(HeartBeatInfo.class));
    }

    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(g.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarA.a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarA.c(new ComponentFactory() { // from class: b.i.c.u.h
            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            }
        });
        return Arrays.asList(bVarA.b(), f.N("fire-installations", "16.3.4"));
    }
}
