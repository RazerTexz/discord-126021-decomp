package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.datatransport.TransportRegistrar;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p228b.p229i.C2414a;
import p007b.p225i.p226a.p228b.p231j.C2447n;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p368l.InterfaceC4575g;

/* JADX INFO: compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TransportRegistrar implements InterfaceC4575g {
    public static /* synthetic */ InterfaceC2412g lambda$getComponents$0(InterfaceC4573e interfaceC4573e) {
        C2447n.m2360b((Context) interfaceC4573e.mo6346a(Context.class));
        return C2447n.m2359a().m2361c(C2414a.f5127e);
    }

    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(InterfaceC2412g.class);
        bVarM6348a.m6351a(new C4583o(Context.class, 1, 0));
        bVarM6348a.m6353c(new InterfaceC4574f() { // from class: b.i.c.n.a
            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                return TransportRegistrar.lambda$getComponents$0(interfaceC4573e);
            }
        });
        return Collections.singletonList(bVarM6348a.m6352b());
    }
}
