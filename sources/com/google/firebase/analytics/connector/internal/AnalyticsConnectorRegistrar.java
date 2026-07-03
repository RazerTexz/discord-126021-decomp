package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p362j.p363a.p364c.C4551a;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p396q.InterfaceC4799d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AnalyticsConnectorRegistrar implements InterfaceC4575g {
    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(InterfaceC4549a.class);
        bVarM6348a.m6351a(new C4583o(C4542c.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(Context.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4799d.class, 1, 0));
        bVarM6348a.m6353c(C4551a.f12144a);
        bVarM6348a.m6354d(2);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-analytics", "18.0.0"));
    }
}
