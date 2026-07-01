package d0.e0.p.d.m0.j;

import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.p, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum DescriptorRenderer9 {
    PLAIN { // from class: d0.e0.p.d.m0.j.p.b
        @Override // d0.e0.p.d.m0.j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return str;
        }
    },
    HTML { // from class: d0.e0.p.d.m0.j.p.a
        @Override // d0.e0.p.d.m0.j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return StringsJVM.replace$default(StringsJVM.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    };

    DescriptorRenderer9(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DescriptorRenderer9[] valuesCustom() {
        DescriptorRenderer9[] descriptorRenderer9ArrValuesCustom = values();
        DescriptorRenderer9[] descriptorRenderer9Arr = new DescriptorRenderer9[descriptorRenderer9ArrValuesCustom.length];
        System.arraycopy(descriptorRenderer9ArrValuesCustom, 0, descriptorRenderer9Arr, 0, descriptorRenderer9ArrValuesCustom.length);
        return descriptorRenderer9Arr;
    }

    public abstract String escape(String str);
}
