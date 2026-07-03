package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.EnumMap;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.y */
/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11631y {

    /* JADX INFO: renamed from: a */
    public final EnumMap<EnumC11485a, C11627u> f23530a;

    public C11631y(EnumMap<EnumC11485a, C11627u> enumMap) {
        C12238m.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.f23530a = enumMap;
    }

    public final C11627u get(EnumC11485a enumC11485a) {
        return this.f23530a.get(enumC11485a);
    }

    public final EnumMap<EnumC11485a, C11627u> getDefaultQualifiers() {
        return this.f23530a;
    }
}
