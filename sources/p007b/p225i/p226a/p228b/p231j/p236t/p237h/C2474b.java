package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.b */
/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2474b extends AbstractC2478f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2519a f5353a;

    /* JADX INFO: renamed from: b */
    public final Map<EnumC2409d, AbstractC2478f.a> f5354b;

    public C2474b(InterfaceC2519a interfaceC2519a, Map<EnumC2409d, AbstractC2478f.a> map) {
        Objects.requireNonNull(interfaceC2519a, "Null clock");
        this.f5353a = interfaceC2519a;
        Objects.requireNonNull(map, "Null values");
        this.f5354b = map;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f
    /* JADX INFO: renamed from: a */
    public InterfaceC2519a mo2374a() {
        return this.f5353a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f
    /* JADX INFO: renamed from: c */
    public Map<EnumC2409d, AbstractC2478f.a> mo2375c() {
        return this.f5354b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2478f)) {
            return false;
        }
        AbstractC2478f abstractC2478f = (AbstractC2478f) obj;
        return this.f5353a.equals(abstractC2478f.mo2374a()) && this.f5354b.equals(abstractC2478f.mo2375c());
    }

    public int hashCode() {
        return ((this.f5353a.hashCode() ^ 1000003) * 1000003) ^ this.f5354b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SchedulerConfig{clock=");
        sbM833U.append(this.f5353a);
        sbM833U.append(", values=");
        return C1643a.m825M(sbM833U, this.f5354b, "}");
    }
}
