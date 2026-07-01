package d0.e0.p.d.m0.c.k1.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.e.b.p;
import d0.e0.p.d.m0.e.b.p$c;
import d0.e0.p.d.m0.e.b.p$d;
import d0.g0.t;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements p {
    public static final f$a a = new f$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f3284b;
    public final d0.e0.p.d.m0.e.b.b0.a c;

    public f(Class cls, d0.e0.p.d.m0.e.b.b0.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3284b = cls;
        this.c = aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && d0.z.d.m.areEqual(this.f3284b, ((f) obj).f3284b);
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public d0.e0.p.d.m0.e.b.b0.a getClassHeader() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public d0.e0.p.d.m0.g.a getClassId() {
        return d0.e0.p.d.m0.c.k1.b.b.getClassId(this.f3284b);
    }

    public final Class<?> getKlass() {
        return this.f3284b;
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public String getLocation() {
        String name = this.f3284b.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "klass.name");
        return d0.z.d.m.stringPlus(t.replace$default(name, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.f3284b.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public void loadClassAnnotations(p$c p_c, byte[] bArr) {
        d0.z.d.m.checkNotNullParameter(p_c, "visitor");
        c.a.loadClassAnnotations(this.f3284b, p_c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(f.class, sb, ": ");
        sb.append(this.f3284b);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public void visitMembers(p$d p_d, byte[] bArr) {
        d0.z.d.m.checkNotNullParameter(p_d, "visitor");
        c.a.visitMembers(this.f3284b, p_d);
    }
}
