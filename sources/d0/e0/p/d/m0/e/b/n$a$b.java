package d0.e0.p.d.m0.e.b;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a$b extends n$a {
    public final p a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a$b(p pVar, byte[] bArr) {
        super(null);
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinJvmBinaryClass");
        this.a = pVar;
    }

    public final p getKotlinJvmBinaryClass() {
        return this.a;
    }

    public /* synthetic */ n$a$b(p pVar, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pVar, (i & 2) != 0 ? null : bArr);
    }
}
