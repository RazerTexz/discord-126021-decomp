package com.discord.utilities.time;

import android.app.Application;
import com.lyft.kronos.KronosClock;
import p007b.p445m.p446a.C5082a;
import p007b.p445m.p446a.p447g.C5089b;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.throwUninitializedPropertyAccessException("ntpClock");
        }
        return ntpClock2;
    }

    public final void init(Application application) {
        C12238m.checkNotNullParameter(application, "application");
        KronosClock kronosClockM7127a = C5082a.m7127a(application, null, null, 0L, 0L, 0L, 62);
        ((C5089b) kronosClockM7127a).f13646a.mo7151b();
        ntpClock = new NtpClock(kronosClockM7127a);
    }
}
