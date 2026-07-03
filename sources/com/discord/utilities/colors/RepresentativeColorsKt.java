package com.discord.utilities.colors;

import com.discord.models.user.User;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepresentativeColorsKt {
    private static final RepresentativeColors<String> UserRepresentativeColors = new RepresentativeColors<>();
    private static final RepresentativeColors<String> GuildMemberRepresentativeColors = new RepresentativeColors<>();
    private static final RepresentativeColors<Long> GuildRepresentativeColors = new RepresentativeColors<>();

    public static final String getColorId(User user) {
        C12238m.checkNotNullParameter(user, "$this$getColorId");
        String avatar = user.getAvatar();
        return avatar != null ? avatar : String.valueOf(user.getDiscriminator());
    }

    public static final RepresentativeColors<String> getGuildMemberRepresentativeColors() {
        return GuildMemberRepresentativeColors;
    }

    public static final RepresentativeColors<Long> getGuildRepresentativeColors() {
        return GuildRepresentativeColors;
    }

    public static final RepresentativeColors<String> getUserRepresentativeColors() {
        return UserRepresentativeColors;
    }
}
