package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.FqName;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.p, reason: use source file name */
/* JADX INFO: compiled from: javaLoading.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class javaLoading {
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    public static final boolean isObjectMethodInInterface(q qVar) {
        boolean zIsEmpty;
        FqName fqName;
        Intrinsics3.checkNotNullParameter(qVar, "<this>");
        if (qVar.getContainingClass().isInterface() && (qVar instanceof r)) {
            r rVar = (r) qVar;
            String strAsString = rVar.getName().asString();
            int iHashCode = strAsString.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && strAsString.equals("hashCode")) {
                        zIsEmpty = rVar.getValueParameters().isEmpty();
                    }
                } else if (strAsString.equals("equals")) {
                    a0 a0Var = (a0) _Collections.singleOrNull((List) rVar.getValueParameters());
                    javaTypes5 type = a0Var == null ? null : a0Var.getType();
                    javaTypes3 javatypes3 = type instanceof javaTypes3 ? (javaTypes3) type : null;
                    if (javatypes3 != null) {
                        i classifier = javatypes3.getClassifier();
                        if ((classifier instanceof g) && (fqName = ((g) classifier).getFqName()) != null && Intrinsics3.areEqual(fqName.asString(), "java.lang.Object")) {
                            zIsEmpty = true;
                        }
                    }
                }
                zIsEmpty = false;
            } else if (strAsString.equals("toString")) {
                zIsEmpty = rVar.getValueParameters().isEmpty();
            } else {
                zIsEmpty = false;
            }
            if (zIsEmpty) {
                return true;
            }
        }
        return false;
    }
}
