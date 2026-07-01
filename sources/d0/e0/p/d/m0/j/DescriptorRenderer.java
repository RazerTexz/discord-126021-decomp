package d0.e0.p.d.m0.j;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.a, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum DescriptorRenderer {
    NO_ARGUMENTS(false, false, 3),
    UNLESS_EMPTY(true, false, 2),
    ALWAYS_PARENTHESIZED(true, true);

    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    DescriptorRenderer(boolean z2, boolean z3) {
        this.includeAnnotationArguments = z2;
        this.includeEmptyAnnotationArguments = z3;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DescriptorRenderer[] valuesCustom() {
        DescriptorRenderer[] descriptorRendererArrValuesCustom = values();
        DescriptorRenderer[] descriptorRendererArr = new DescriptorRenderer[descriptorRendererArrValuesCustom.length];
        System.arraycopy(descriptorRendererArrValuesCustom, 0, descriptorRendererArr, 0, descriptorRendererArrValuesCustom.length);
        return descriptorRendererArr;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    DescriptorRenderer(boolean z2, boolean z3, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        z3 = (i & 2) != 0 ? false : z3;
        this.includeAnnotationArguments = z2;
        this.includeEmptyAnnotationArguments = z3;
    }
}
