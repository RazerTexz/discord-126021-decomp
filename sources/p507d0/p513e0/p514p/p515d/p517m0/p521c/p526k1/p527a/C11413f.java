package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11637b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.f */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11413f implements InterfaceC11655p {

    /* JADX INFO: renamed from: a */
    public static final a f23015a = new a(null);

    /* JADX INFO: renamed from: b */
    public final Class<?> f23016b;

    /* JADX INFO: renamed from: c */
    public final C11636a f23017c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.f$a */
    /* JADX INFO: compiled from: ReflectKotlinClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11413f create(Class<?> cls) {
            C12238m.checkNotNullParameter(cls, "klass");
            C11637b c11637b = new C11637b();
            C11410c.f23013a.loadClassAnnotations(cls, c11637b);
            C11636a c11636aCreateHeader = c11637b.createHeader();
            if (c11636aCreateHeader == null) {
                return null;
            }
            return new C11413f(cls, c11636aCreateHeader, null);
        }
    }

    public C11413f(Class cls, C11636a c11636a, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23016b = cls;
        this.f23017c = c11636a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11413f) && C12238m.areEqual(this.f23016b, ((C11413f) obj).f23016b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p
    public C11636a getClassHeader() {
        return this.f23017c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p
    public C11712a getClassId() {
        return C11423b.getClassId(this.f23016b);
    }

    public final Class<?> getKlass() {
        return this.f23016b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p
    public String getLocation() {
        String name = this.f23016b.getName();
        C12238m.checkNotNullExpressionValue(name, "klass.name");
        return C12238m.stringPlus(C12103t.replace$default(name, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.f23016b.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p
    public void loadClassAnnotations(InterfaceC11655p.c cVar, byte[] bArr) {
        C12238m.checkNotNullParameter(cVar, "visitor");
        C11410c.f23013a.loadClassAnnotations(this.f23016b, cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        C1643a.m860k0(C11413f.class, sb, ": ");
        sb.append(this.f23016b);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p
    public void visitMembers(InterfaceC11655p.d dVar, byte[] bArr) {
        C12238m.checkNotNullParameter(dVar, "visitor");
        C11410c.f23013a.visitMembers(this.f23016b, dVar);
    }
}
