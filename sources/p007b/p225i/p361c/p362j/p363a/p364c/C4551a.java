package p007b.p225i.p361c.p362j.p363a.p364c;

import android.content.Context;
import android.os.Bundle;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p361c.C4540a;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.C4550b;
import p007b.p225i.p361c.p362j.p363a.C4557d;
import p007b.p225i.p361c.p362j.p363a.ExecutorC4558e;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p396q.InterfaceC4799d;

/* JADX INFO: renamed from: b.i.c.j.a.c.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4551a implements InterfaceC4574f {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4574f f12144a = new C4551a();

    @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
    /* JADX INFO: renamed from: a */
    public final Object mo6341a(InterfaceC4573e interfaceC4573e) {
        C4542c c4542c = (C4542c) interfaceC4573e.mo6346a(C4542c.class);
        Context context = (Context) interfaceC4573e.mo6346a(Context.class);
        InterfaceC4799d interfaceC4799d = (InterfaceC4799d) interfaceC4573e.mo6346a(InterfaceC4799d.class);
        Objects.requireNonNull(c4542c, "null reference");
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(interfaceC4799d, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (C4550b.f12141a == null) {
            synchronized (C4550b.class) {
                if (C4550b.f12141a == null) {
                    Bundle bundle = new Bundle(1);
                    if (c4542c.m6334h()) {
                        interfaceC4799d.mo6360b(C4540a.class, ExecutorC4558e.f12161j, C4557d.f12160a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", c4542c.m6333g());
                    }
                    C4550b.f12141a = new C4550b(C3661g.m4882a(context, null, null, null, bundle).f9951f);
                }
            }
        }
        return C4550b.f12141a;
    }
}
