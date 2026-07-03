package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.p */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11759p {
    PLAIN { // from class: d0.e0.p.d.m0.j.p.b
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.EnumC11759p
        public String escape(String str) {
            C12238m.checkNotNullParameter(str, "string");
            return str;
        }
    },
    HTML { // from class: d0.e0.p.d.m0.j.p.a
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.EnumC11759p
        public String escape(String str) {
            C12238m.checkNotNullParameter(str, "string");
            return C12103t.replace$default(C12103t.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    };

    EnumC11759p(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11759p[] valuesCustom() {
        EnumC11759p[] enumC11759pArrValuesCustom = values();
        EnumC11759p[] enumC11759pArr = new EnumC11759p[enumC11759pArrValuesCustom.length];
        System.arraycopy(enumC11759pArrValuesCustom, 0, enumC11759pArr, 0, enumC11759pArrValuesCustom.length);
        return enumC11759pArr;
    }

    public abstract String escape(String str);
}
