package com.google.firebase.iid;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p398s.C4827r;
import p007b.p225i.p361c.p398s.C4828s;
import p007b.p225i.p361c.p398s.p399e0.InterfaceC4814a;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class Registrar implements InterfaceC4575g {

    /* JADX INFO: renamed from: com.google.firebase.iid.Registrar$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class C11079a implements InterfaceC4814a {
        public C11079a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(InterfaceC4573e interfaceC4573e) {
        return new FirebaseInstanceId((C4542c) interfaceC4573e.mo6346a(C4542c.class), interfaceC4573e.mo6355b(InterfaceC4896h.class), interfaceC4573e.mo6355b(InterfaceC4803d.class), (InterfaceC4843g) interfaceC4573e.mo6346a(InterfaceC4843g.class));
    }

    public static final /* synthetic */ InterfaceC4814a lambda$getComponents$1$Registrar(InterfaceC4573e interfaceC4573e) {
        return new C11079a((FirebaseInstanceId) interfaceC4573e.mo6346a(FirebaseInstanceId.class));
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    @Keep
    public final List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(FirebaseInstanceId.class);
        bVarM6348a.m6351a(new C4583o(C4542c.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4896h.class, 0, 1));
        bVarM6348a.m6351a(new C4583o(InterfaceC4803d.class, 0, 1));
        bVarM6348a.m6351a(new C4583o(InterfaceC4843g.class, 1, 0));
        bVarM6348a.m6353c(C4827r.f12890a);
        bVarM6348a.m6354d(1);
        C4572d c4572dM6352b = bVarM6348a.m6352b();
        C4572d.b bVarM6348a2 = C4572d.m6348a(InterfaceC4814a.class);
        bVarM6348a2.m6351a(new C4583o(FirebaseInstanceId.class, 1, 0));
        bVarM6348a2.m6353c(C4828s.f12891a);
        return Arrays.asList(c4572dM6352b, bVarM6348a2.m6352b(), C3404f.m4228N("fire-iid", "21.0.0"));
    }
}
