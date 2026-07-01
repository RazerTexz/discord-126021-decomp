package com.discord.stores;

import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments$Companion {
    private StoreExperiments$Companion() {
    }

    public final boolean isExperimentalAlpha(StoreGuilds storeGuilds, StoreUser storeUser) {
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUser");
        return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) || storeGuilds.getGuilds().get(197038439483310086L) != null;
    }

    public /* synthetic */ StoreExperiments$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
