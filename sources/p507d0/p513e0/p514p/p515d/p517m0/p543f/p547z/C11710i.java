package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11697v;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i */
/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11710i {

    /* JADX INFO: renamed from: a */
    public static final a f24073a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final C11710i f24074b = new C11710i(C12147n.emptyList());

    /* JADX INFO: renamed from: c */
    public final List<C11697v> f24075c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i$a */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11710i create(C11698w c11698w) {
            C12238m.checkNotNullParameter(c11698w, "table");
            if (c11698w.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<C11697v> requirementList = c11698w.getRequirementList();
            C12238m.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new C11710i(requirementList, null);
        }

        public final C11710i getEMPTY() {
            return C11710i.f24074b;
        }
    }

    public C11710i(List<C11697v> list) {
        this.f24075c = list;
    }

    public final C11697v get(int i) {
        return (C11697v) C12163u.getOrNull(this.f24075c, i);
    }

    public C11710i(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24075c = list;
    }
}
