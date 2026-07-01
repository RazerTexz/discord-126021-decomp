package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v;
import d0.t.n;
import d0.t.u;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final i$a a = new i$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f3421b = new i(n.emptyList());
    public final List<v> c;

    public i(List<v> list) {
        this.c = list;
    }

    public static final /* synthetic */ i access$getEMPTY$cp() {
        return f3421b;
    }

    public final v get(int i) {
        return (v) u.getOrNull(this.c, i);
    }

    public i(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = list;
    }
}
