package b.m.a;

import android.content.Context;
import android.content.SharedPreferences;
import b.m.a.g.AndroidSystemClock;
import b.m.a.g.KronosClockImpl;
import b.m.a.g.SharedPreferenceSyncResponseCache;
import b.m.a.g.d.DatagramFactory2;
import b.m.a.g.d.DnsResolver2;
import b.m.a.g.d.SntpClient;
import b.m.a.g.d.SntpResponseCache2;
import b.m.a.g.d.SntpService2;
import com.lyft.kronos.Clock8;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: b.m.a.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidClockFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidClockFactory {
    public static Clock8 a(Context context, SyncListener syncListener, List list, long j, long j2, long j3, int i) {
        List<String> list2;
        long j4;
        long j5;
        long j6;
        int i2 = i & 2;
        if ((i & 4) != 0) {
            DefaultParam defaultParam = DefaultParam.e;
            list2 = DefaultParam.a;
        } else {
            list2 = null;
        }
        List<String> list3 = list2;
        if ((i & 8) != 0) {
            DefaultParam defaultParam2 = DefaultParam.e;
            j4 = DefaultParam.d;
        } else {
            j4 = j;
        }
        if ((i & 16) != 0) {
            DefaultParam defaultParam3 = DefaultParam.e;
            j5 = DefaultParam.c;
        } else {
            j5 = j2;
        }
        if ((i & 32) != 0) {
            DefaultParam defaultParam4 = DefaultParam.e;
            j6 = DefaultParam.f1903b;
        } else {
            j6 = j3;
        }
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(list3, "ntpHosts");
        AndroidSystemClock androidSystemClock = new AndroidSystemClock();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.lyft.kronos.shared_preferences", 0);
        Intrinsics3.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        SharedPreferenceSyncResponseCache sharedPreferenceSyncResponseCache = new SharedPreferenceSyncResponseCache(sharedPreferences);
        Intrinsics3.checkParameterIsNotNull(androidSystemClock, "localClock");
        Intrinsics3.checkParameterIsNotNull(sharedPreferenceSyncResponseCache, "syncResponseCache");
        Intrinsics3.checkParameterIsNotNull(list3, "ntpHosts");
        if (androidSystemClock instanceof Clock8) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new KronosClockImpl(new SntpService2(new SntpClient(androidSystemClock, new DnsResolver2(), new DatagramFactory2()), androidSystemClock, new SntpResponseCache2(sharedPreferenceSyncResponseCache, androidSystemClock), null, list3, j4, j5, j6), androidSystemClock);
    }
}
