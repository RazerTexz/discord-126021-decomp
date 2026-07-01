package com.discord.models.user;

import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;

/* JADX INFO: compiled from: User.kt */
/* JADX INFO: loaded from: classes.dex */
public interface User extends Serializable {
    String getAvatar();

    String getBanner();

    String getBannerColor();

    String getBio();

    int getDiscriminator();

    int getFlags();

    long getId();

    PremiumTier getPremiumTier();

    int getPublicFlags();

    String getUsername();

    boolean isBot();

    boolean isSystemUser();
}
