package b.m.a;

import android.content.Context;
import android.content.SharedPreferences;
import b.m.a.g.d.g;
import b.m.a.g.d.i;
import com.lyft.kronos.KronosClock;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: AndroidClockFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static KronosClock a(Context context, e eVar, List list, long j, long j2, long j3, int i) {
        List<String> list2;
        long j4;
        long j5;
        long j6;
        int i2 = i & 2;
        if ((i & 4) != 0) {
            c cVar = c.e;
            list2 = c.a;
        } else {
            list2 = null;
        }
        List<String> list3 = list2;
        if ((i & 8) != 0) {
            c cVar2 = c.e;
            j4 = c.d;
        } else {
            j4 = j;
        }
        if ((i & 16) != 0) {
            c cVar3 = c.e;
            j5 = c.c;
        } else {
            j5 = j2;
        }
        if ((i & 32) != 0) {
            c cVar4 = c.e;
            j6 = c.f1903b;
        } else {
            j6 = j3;
        }
        m.checkParameterIsNotNull(context, "context");
        m.checkParameterIsNotNull(list3, "ntpHosts");
        b.m.a.g.a aVar = new b.m.a.g.a();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.lyft.kronos.shared_preferences", 0);
        m.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        b.m.a.g.c cVar5 = new b.m.a.g.c(sharedPreferences);
        m.checkParameterIsNotNull(aVar, "localClock");
        m.checkParameterIsNotNull(cVar5, "syncResponseCache");
        m.checkParameterIsNotNull(list3, "ntpHosts");
        if (aVar instanceof KronosClock) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new b.m.a.g.b(new i(new b.m.a.g.d.e(aVar, new b.m.a.g.d.d(), new b.m.a.g.d.b()), aVar, new g(cVar5, aVar), null, list3, j4, j5, j6), aVar);
    }
}
