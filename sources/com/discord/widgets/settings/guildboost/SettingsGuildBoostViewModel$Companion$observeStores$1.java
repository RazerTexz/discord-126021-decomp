package com.discord.widgets.settings.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.PremiumTier;
import com.discord.models.user.MeUser;
import j0.k.b;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel$Companion$observeStores$1<T, R> implements b<MeUser, PremiumTier> {
    public static final SettingsGuildBoostViewModel$Companion$observeStores$1 INSTANCE = new SettingsGuildBoostViewModel$Companion$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ PremiumTier call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PremiumTier call2(MeUser meUser) {
        return meUser.getPremiumTier();
    }
}
