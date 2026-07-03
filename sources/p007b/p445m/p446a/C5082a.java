package p007b.p445m.p446a;

import android.content.Context;
import android.content.SharedPreferences;
import com.lyft.kronos.KronosClock;
import java.util.List;
import p007b.p445m.p446a.p447g.C5088a;
import p007b.p445m.p446a.p447g.C5089b;
import p007b.p445m.p446a.p447g.C5090c;
import p007b.p445m.p446a.p447g.p448d.C5092b;
import p007b.p445m.p446a.p447g.p448d.C5094d;
import p007b.p445m.p446a.p447g.p448d.C5095e;
import p007b.p445m.p446a.p447g.p448d.C5097g;
import p007b.p445m.p446a.p447g.p448d.C5099i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.a */
/* JADX INFO: compiled from: AndroidClockFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5082a {
    /* JADX INFO: renamed from: a */
    public static KronosClock m7127a(Context context, InterfaceC5086e interfaceC5086e, List list, long j, long j2, long j3, int i) {
        List<String> list2;
        long j4;
        long j5;
        long j6;
        int i2 = i & 2;
        if ((i & 4) != 0) {
            C5084c c5084c = C5084c.f13643e;
            list2 = C5084c.f13639a;
        } else {
            list2 = null;
        }
        List<String> list3 = list2;
        if ((i & 8) != 0) {
            C5084c c5084c2 = C5084c.f13643e;
            j4 = C5084c.f13642d;
        } else {
            j4 = j;
        }
        if ((i & 16) != 0) {
            C5084c c5084c3 = C5084c.f13643e;
            j5 = C5084c.f13641c;
        } else {
            j5 = j2;
        }
        if ((i & 32) != 0) {
            C5084c c5084c4 = C5084c.f13643e;
            j6 = C5084c.f13640b;
        } else {
            j6 = j3;
        }
        C12238m.checkParameterIsNotNull(context, "context");
        C12238m.checkParameterIsNotNull(list3, "ntpHosts");
        C5088a c5088a = new C5088a();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.lyft.kronos.shared_preferences", 0);
        C12238m.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        C5090c c5090c = new C5090c(sharedPreferences);
        C12238m.checkParameterIsNotNull(c5088a, "localClock");
        C12238m.checkParameterIsNotNull(c5090c, "syncResponseCache");
        C12238m.checkParameterIsNotNull(list3, "ntpHosts");
        if (c5088a instanceof KronosClock) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new C5089b(new C5099i(new C5095e(c5088a, new C5094d(), new C5092b()), c5088a, new C5097g(c5090c, c5088a), null, list3, j4, j5, j6), c5088a);
    }
}
