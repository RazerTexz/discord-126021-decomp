package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzij;

/* JADX INFO: renamed from: b.i.a.f.h.l.h5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3681h5 {

    /* JADX INFO: renamed from: a */
    public volatile InterfaceC3612c6 f9990a;

    /* JADX INFO: renamed from: b */
    public volatile AbstractC3837t3 f9991b;

    static {
        C3680h4.m4933a();
    }

    /* JADX INFO: renamed from: a */
    public final int m4934a() {
        if (this.f9991b != null) {
            return this.f9991b.mo5282d();
        }
        if (this.f9990a != null) {
            return this.f9990a.mo4606g();
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public final InterfaceC3612c6 m4935b(InterfaceC3612c6 interfaceC3612c6) {
        if (this.f9990a == null) {
            synchronized (this) {
                if (this.f9990a == null) {
                    try {
                        this.f9990a = interfaceC3612c6;
                        this.f9991b = AbstractC3837t3.f10322j;
                    } catch (zzij unused) {
                        this.f9990a = interfaceC3612c6;
                        this.f9991b = AbstractC3837t3.f10322j;
                    }
                }
            }
        }
        return this.f9990a;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC3837t3 m4936c() {
        if (this.f9991b != null) {
            return this.f9991b;
        }
        synchronized (this) {
            if (this.f9991b != null) {
                return this.f9991b;
            }
            if (this.f9990a == null) {
                this.f9991b = AbstractC3837t3.f10322j;
            } else {
                this.f9991b = this.f9990a.mo4604b();
            }
            return this.f9991b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3681h5)) {
            return false;
        }
        C3681h5 c3681h5 = (C3681h5) obj;
        InterfaceC3612c6 interfaceC3612c6 = this.f9990a;
        InterfaceC3612c6 interfaceC3612c7 = c3681h5.f9990a;
        if (interfaceC3612c6 == null && interfaceC3612c7 == null) {
            return m4936c().equals(c3681h5.m4936c());
        }
        if (interfaceC3612c6 == null || interfaceC3612c7 == null) {
            return interfaceC3612c6 != null ? interfaceC3612c6.equals(c3681h5.m4935b(interfaceC3612c6.mo4633k())) : m4935b(interfaceC3612c7.mo4633k()).equals(interfaceC3612c7);
        }
        return interfaceC3612c6.equals(interfaceC3612c7);
    }

    public int hashCode() {
        return 1;
    }
}
