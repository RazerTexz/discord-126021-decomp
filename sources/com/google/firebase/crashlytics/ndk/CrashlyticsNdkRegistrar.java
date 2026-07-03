package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4591a;

/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsNdkRegistrar implements InterfaceC4575g {
    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(InterfaceC4591a.class);
        bVarM6348a.m6351a(new C4583o(Context.class, 1, 0));
        bVarM6348a.m6353c(new InterfaceC4574f(this) { // from class: b.i.c.m.e.b

            /* JADX INFO: renamed from: a */
            public final CrashlyticsNdkRegistrar f12788a;

            {
                this.f12788a = this;
            }

            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                Objects.requireNonNull(this.f12788a);
                Context context = (Context) interfaceC4573e.mo6346a(Context.class);
                return new C4760c(new C4758a(context, new JniNativeApi(context), new C4763f(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
            }
        });
        bVarM6348a.m6354d(2);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-cls-ndk", "17.3.0"));
    }
}
