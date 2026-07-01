package d0.e0.p.d.m0.e.a;

import java.util.EnumMap;

/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public final EnumMap<a, u> a;

    public y(EnumMap<a, u> enumMap) {
        d0.z.d.m.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    public final u get(a aVar) {
        return this.a.get(aVar);
    }

    public final EnumMap<a, u> getDefaultQualifiers() {
        return this.a;
    }
}
