package com.discord.utilities.time;

import android.app.Application;
import b.m.a.a;
import b.m.a.g.b;
import com.lyft.kronos.KronosClock;
import d0.z.d.m;

/* JADX INFO: compiled from: ClockFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClockFactory {
    public static final ClockFactory INSTANCE = new ClockFactory();
    private static NtpClock ntpClock;

    private ClockFactory() {
    }

    public static final Clock get() {
        NtpClock ntpClock2 = ntpClock;
        if (ntpClock2 == null) {
            m.throwUninitializedPropertyAccessException("ntpClock");
        }
        return ntpClock2;
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        KronosClock kronosClockA = a.a(application, null, null, 0L, 0L, 0L, 62);
        ((b) kronosClockA).a.b();
        ntpClock = new NtpClock(kronosClockA);
    }
}
