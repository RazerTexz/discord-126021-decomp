package d0.e0.p.d.m0.e.b;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final s$a a = new s$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3382b;

    public s(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3382b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && d0.z.d.m.areEqual(this.f3382b, ((s) obj).f3382b);
    }

    public final String getSignature() {
        return this.f3382b;
    }

    public int hashCode() {
        return this.f3382b.hashCode();
    }

    public String toString() {
        return b.d.b.a.a.H(b.d.b.a.a.U("MemberSignature(signature="), this.f3382b, ')');
    }
}
