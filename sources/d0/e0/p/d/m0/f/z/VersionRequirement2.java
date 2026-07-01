package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.w;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i, reason: use source file name */
/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VersionRequirement2 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VersionRequirement2 f3421b = new VersionRequirement2(Collections2.emptyList());
    public final List<v> c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i$a */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final VersionRequirement2 create(w wVar) {
            Intrinsics3.checkNotNullParameter(wVar, "table");
            if (wVar.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<v> requirementList = wVar.getRequirementList();
            Intrinsics3.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirement2(requirementList, null);
        }

        public final VersionRequirement2 getEMPTY() {
            return VersionRequirement2.f3421b;
        }
    }

    public VersionRequirement2(List<v> list) {
        this.c = list;
    }

    public final v get(int i) {
        return (v) _Collections.getOrNull(this.c, i);
    }

    public VersionRequirement2(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = list;
    }
}
