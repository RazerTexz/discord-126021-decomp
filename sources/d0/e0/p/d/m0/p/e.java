package d0.e0.p.d.m0.p;

import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3563b;
    public final h c;
    public final h d;
    public final Map<String, h> e;
    public final boolean f;
    public final h g;
    public final Lazy h;
    public final boolean i;
    public final boolean j;

    static {
        new e$a(null);
        h hVar = h.WARN;
        a = hVar;
        new e(hVar, null, h0.emptyMap(), false, null, 24, null);
        h hVar2 = h.IGNORE;
        f3563b = new e(hVar2, hVar2, h0.emptyMap(), false, null, 24, null);
        h hVar3 = h.STRICT;
        new e(hVar3, hVar3, h0.emptyMap(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(h hVar, h hVar2, Map<String, ? extends h> map, boolean z2, h hVar3) {
        m.checkNotNullParameter(hVar, "globalJsr305Level");
        m.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        m.checkNotNullParameter(hVar3, "jspecifyReportLevel");
        this.c = hVar;
        this.d = hVar2;
        this.e = map;
        this.f = z2;
        this.g = hVar3;
        this.h = d0.g.lazy(new e$b(this));
        h hVar4 = h.IGNORE;
        boolean z3 = true;
        boolean z4 = hVar == hVar4 && hVar2 == hVar4 && map.isEmpty();
        this.i = z4;
        if (!z4 && hVar3 != hVar4) {
            z3 = false;
        }
        this.j = z3;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.j;
    }

    public final boolean getDisabledJsr305() {
        return this.i;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.f;
    }

    public final h getGlobalJsr305Level() {
        return this.c;
    }

    public final h getJspecifyReportLevel() {
        return this.g;
    }

    public final h getMigrationLevelForJsr305() {
        return this.d;
    }

    public final Map<String, h> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.e;
    }

    public /* synthetic */ e(h hVar, h hVar2, Map map, boolean z2, h hVar3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, hVar2, map, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? a : hVar3);
    }
}
