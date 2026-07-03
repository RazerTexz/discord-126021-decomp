package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;

/* JADX INFO: renamed from: b.i.a.b.j.q.c */
/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2452c extends AbstractC2457h {

    /* JADX INFO: renamed from: a */
    public final Context f5304a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2519a f5305b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2519a f5306c;

    /* JADX INFO: renamed from: d */
    public final String f5307d;

    public C2452c(Context context, InterfaceC2519a interfaceC2519a, InterfaceC2519a interfaceC2519a2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f5304a = context;
        Objects.requireNonNull(interfaceC2519a, "Null wallClock");
        this.f5305b = interfaceC2519a;
        Objects.requireNonNull(interfaceC2519a2, "Null monotonicClock");
        this.f5306c = interfaceC2519a2;
        Objects.requireNonNull(str, "Null backendName");
        this.f5307d = str;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2457h
    /* JADX INFO: renamed from: a */
    public Context mo2366a() {
        return this.f5304a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2457h
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo2367b() {
        return this.f5307d;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2457h
    /* JADX INFO: renamed from: c */
    public InterfaceC2519a mo2368c() {
        return this.f5306c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2457h
    /* JADX INFO: renamed from: d */
    public InterfaceC2519a mo2369d() {
        return this.f5305b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2457h)) {
            return false;
        }
        AbstractC2457h abstractC2457h = (AbstractC2457h) obj;
        return this.f5304a.equals(abstractC2457h.mo2366a()) && this.f5305b.equals(abstractC2457h.mo2369d()) && this.f5306c.equals(abstractC2457h.mo2368c()) && this.f5307d.equals(abstractC2457h.mo2367b());
    }

    public int hashCode() {
        return ((((((this.f5304a.hashCode() ^ 1000003) * 1000003) ^ this.f5305b.hashCode()) * 1000003) ^ this.f5306c.hashCode()) * 1000003) ^ this.f5307d.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CreationContext{applicationContext=");
        sbM833U.append(this.f5304a);
        sbM833U.append(", wallClock=");
        sbM833U.append(this.f5305b);
        sbM833U.append(", monotonicClock=");
        sbM833U.append(this.f5306c);
        sbM833U.append(", backendName=");
        return C1643a.m822J(sbM833U, this.f5307d, "}");
    }
}
