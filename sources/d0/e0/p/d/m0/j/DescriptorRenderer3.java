package d0.e0.p.d.m0.j;

import d0.t._Arrays;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.g, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum DescriptorRenderer3 {
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

    public static final Set<DescriptorRenderer3> j;
    public static final Set<DescriptorRenderer3> k;
    private final boolean includeByDefault;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.j.g.a
        };
        DescriptorRenderer3[] descriptorRenderer3ArrValuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 14; i++) {
            DescriptorRenderer3 descriptorRenderer3 = descriptorRenderer3ArrValuesCustom[i];
            if (descriptorRenderer3.getIncludeByDefault()) {
                arrayList.add(descriptorRenderer3);
            }
        }
        j = _Collections.toSet(arrayList);
        k = _Arrays.toSet(valuesCustom());
    }

    DescriptorRenderer3(boolean z2) {
        this.includeByDefault = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DescriptorRenderer3[] valuesCustom() {
        DescriptorRenderer3[] descriptorRenderer3ArrValuesCustom = values();
        DescriptorRenderer3[] descriptorRenderer3Arr = new DescriptorRenderer3[descriptorRenderer3ArrValuesCustom.length];
        System.arraycopy(descriptorRenderer3ArrValuesCustom, 0, descriptorRenderer3Arr, 0, descriptorRenderer3ArrValuesCustom.length);
        return descriptorRenderer3Arr;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
