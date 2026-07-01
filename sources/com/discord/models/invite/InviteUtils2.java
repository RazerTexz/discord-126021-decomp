package com.discord.models.invite;

import com.discord.models.domain.ModelInvite;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.invite.InviteUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: InviteUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InviteUtils2 {
    public static final boolean isValid(ModelInvite modelInvite, Clock clock) {
        Intrinsics3.checkNotNullParameter(modelInvite, "$this$isValid");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return modelInvite.getExpirationTime() < clock.currentTimeMillis() && !modelInvite.isRevoked();
    }

    public static /* synthetic */ boolean isValid$default(ModelInvite modelInvite, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return isValid(modelInvite, clock);
    }
}
