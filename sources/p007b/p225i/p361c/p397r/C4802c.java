package p007b.p225i.p361c.p397r;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p225i.p361c.p368l.C4586r;
import p007b.p225i.p361c.p400t.InterfaceC4836a;

/* JADX INFO: renamed from: b.i.c.r.c */
/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4802c implements InterfaceC4803d {

    /* JADX INFO: renamed from: a */
    public InterfaceC4836a<C4804e> f12835a;

    public C4802c(final Context context) {
        this.f12835a = new C4586r(new InterfaceC4836a(context) { // from class: b.i.c.r.a

            /* JADX INFO: renamed from: a */
            public final Context f12833a;

            {
                this.f12833a = context;
            }

            @Override // p007b.p225i.p361c.p400t.InterfaceC4836a
            public Object get() {
                C4804e c4804e;
                Context context2 = this.f12833a;
                synchronized (C4804e.class) {
                    if (C4804e.f12841a == null) {
                        C4804e.f12841a = new C4804e(context2);
                    }
                    c4804e = C4804e.f12841a;
                }
                return c4804e;
            }
        });
    }

    @Override // p007b.p225i.p361c.p397r.InterfaceC4803d
    @NonNull
    /* JADX INFO: renamed from: a */
    public InterfaceC4803d.a mo6716a(@NonNull String str) {
        boolean zM6718a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zM6718a2 = this.f12835a.get().m6718a(str, jCurrentTimeMillis);
        C4804e c4804e = this.f12835a.get();
        synchronized (c4804e) {
            zM6718a = c4804e.m6718a("fire-global", jCurrentTimeMillis);
        }
        if (zM6718a2 && zM6718a) {
            return InterfaceC4803d.a.COMBINED;
        }
        if (zM6718a) {
            return InterfaceC4803d.a.GLOBAL;
        }
        return zM6718a2 ? InterfaceC4803d.a.SDK : InterfaceC4803d.a.NONE;
    }
}
