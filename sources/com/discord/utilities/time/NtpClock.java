package com.discord.utilities.time;

import com.lyft.kronos.KronosClock;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NtpClock.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NtpClock implements Clock {
    private final KronosClock kronosClock;

    public NtpClock(KronosClock kronosClock) {
        C12238m.checkNotNullParameter(kronosClock, "kronosClock");
        this.kronosClock = kronosClock;
    }

    @Override // com.discord.utilities.time.Clock
    public long currentTimeMillis() {
        return this.kronosClock.mo7128a();
    }

    public final KronosClock getKronosClock() {
        return this.kronosClock;
    }
}
