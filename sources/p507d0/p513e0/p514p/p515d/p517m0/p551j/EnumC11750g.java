package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.util.ArrayList;
import java.util.Set;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.g */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11750g {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    /* JADX INFO: renamed from: j */
    public static final Set<EnumC11750g> f24244j;

    /* JADX INFO: renamed from: k */
    public static final Set<EnumC11750g> f24245k;
    private final boolean includeByDefault;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.j.g.a
        };
        EnumC11750g[] enumC11750gArrValuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 14; i++) {
            EnumC11750g enumC11750g = enumC11750gArrValuesCustom[i];
            if (enumC11750g.getIncludeByDefault()) {
                arrayList.add(enumC11750g);
            }
        }
        f24244j = C12163u.toSet(arrayList);
        f24245k = C12141k.toSet(valuesCustom());
    }

    EnumC11750g(boolean z2) {
        this.includeByDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11750g[] valuesCustom() {
        EnumC11750g[] enumC11750gArrValuesCustom = values();
        EnumC11750g[] enumC11750gArr = new EnumC11750g[enumC11750gArrValuesCustom.length];
        System.arraycopy(enumC11750gArrValuesCustom, 0, enumC11750gArr, 0, enumC11750gArrValuesCustom.length);
        return enumC11750gArr;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
