package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k0.p */
/* JADX INFO: compiled from: javaLoading.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11583p {
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    public static final boolean isObjectMethodInInterface(InterfaceC11584q interfaceC11584q) {
        boolean zIsEmpty;
        C11713b fqName;
        C12238m.checkNotNullParameter(interfaceC11584q, "<this>");
        if (interfaceC11584q.getContainingClass().isInterface() && (interfaceC11584q instanceof InterfaceC11585r)) {
            InterfaceC11585r interfaceC11585r = (InterfaceC11585r) interfaceC11584q;
            String strAsString = interfaceC11585r.getName().asString();
            int iHashCode = strAsString.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && strAsString.equals("hashCode")) {
                        zIsEmpty = interfaceC11585r.getValueParameters().isEmpty();
                    }
                } else if (strAsString.equals("equals")) {
                    InterfaceC11565a0 interfaceC11565a0 = (InterfaceC11565a0) C12163u.singleOrNull((List) interfaceC11585r.getValueParameters());
                    InterfaceC11591x type = interfaceC11565a0 == null ? null : interfaceC11565a0.getType();
                    InterfaceC11577j interfaceC11577j = type instanceof InterfaceC11577j ? (InterfaceC11577j) type : null;
                    if (interfaceC11577j != null) {
                        InterfaceC11576i classifier = interfaceC11577j.getClassifier();
                        if ((classifier instanceof InterfaceC11574g) && (fqName = ((InterfaceC11574g) classifier).getFqName()) != null && C12238m.areEqual(fqName.asString(), "java.lang.Object")) {
                            zIsEmpty = true;
                        }
                    }
                }
                zIsEmpty = false;
            } else if (strAsString.equals("toString")) {
                zIsEmpty = interfaceC11585r.getValueParameters().isEmpty();
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
