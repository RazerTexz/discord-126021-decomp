package com.discord.utilities.time;

import android.app.Application;
import b.m.a.AndroidClockFactory;
import b.m.a.g.KronosClockImpl;
import com.lyft.kronos.Clock8;
import d0.z.d.Intrinsics3;

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
            Intrinsics3.throwUninitializedPropertyAccessException("ntpClock");
        }
        return ntpClock2;
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Clock8 clock8A = AndroidClockFactory.a(application, null, null, 0L, 0L, 0L, 62);
        ((KronosClockImpl) clock8A).a.b();
        ntpClock = new NtpClock(clock8A);
    }
}
