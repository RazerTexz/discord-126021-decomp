package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p401u.C4842f;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseInstallationsRegistrar implements InterfaceC4575g {
    public static /* synthetic */ InterfaceC4843g lambda$getComponents$0(InterfaceC4573e interfaceC4573e) {
        return new C4842f((C4542c) interfaceC4573e.mo6346a(C4542c.class), interfaceC4573e.mo6355b(InterfaceC4896h.class), interfaceC4573e.mo6355b(InterfaceC4803d.class));
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(InterfaceC4843g.class);
        bVarM6348a.m6351a(new C4583o(C4542c.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4803d.class, 0, 1));
        bVarM6348a.m6351a(new C4583o(InterfaceC4896h.class, 0, 1));
        bVarM6348a.m6353c(new InterfaceC4574f() { // from class: b.i.c.u.h
            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(interfaceC4573e);
            }
        });
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-installations", "16.3.4"));
    }
}
