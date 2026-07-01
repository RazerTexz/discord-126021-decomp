package com.discord.models.user;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.g0.s;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CoreUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CoreUser implements User {
    public static final CoreUser$Companion Companion = new CoreUser$Companion(null);
    private final String avatar;
    private final String banner;
    private final String bannerColor;
    private final String bio;
    private final int discriminator;
    private final int flags;
    private final long id;
    private final boolean isBot;
    private final boolean isSystemUser;
    private final PremiumTier premiumTier;
    private final int publicFlags;
    private final String username;

    public CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5) {
        m.checkNotNullParameter(str, "username");
        m.checkNotNullParameter(premiumTier, "premiumTier");
        this.id = j;
        this.username = str;
        this.avatar = str2;
        this.banner = str3;
        this.isBot = z2;
        this.isSystemUser = z3;
        this.discriminator = i;
        this.premiumTier = premiumTier;
        this.flags = i2;
        this.publicFlags = i3;
        this.bio = str4;
        this.bannerColor = str5;
    }

    public static /* synthetic */ CoreUser copy$default(CoreUser coreUser, long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5, int i4, Object obj) {
        return coreUser.copy((i4 & 1) != 0 ? coreUser.getId() : j, (i4 & 2) != 0 ? coreUser.getUsername() : str, (i4 & 4) != 0 ? coreUser.getAvatar() : str2, (i4 & 8) != 0 ? coreUser.getBanner() : str3, (i4 & 16) != 0 ? coreUser.getIsBot() : z2, (i4 & 32) != 0 ? coreUser.getIsSystemUser() : z3, (i4 & 64) != 0 ? coreUser.getDiscriminator() : i, (i4 & 128) != 0 ? coreUser.getPremiumTier() : premiumTier, (i4 & 256) != 0 ? coreUser.getFlags() : i2, (i4 & 512) != 0 ? coreUser.getPublicFlags() : i3, (i4 & 1024) != 0 ? coreUser.getBio() : str4, (i4 & 2048) != 0 ? coreUser.getBannerColor() : str5);
    }

    public final long component1() {
        return getId();
    }

    public final int component10() {
        return getPublicFlags();
    }

    public final String component11() {
        return getBio();
    }

    public final String component12() {
        return getBannerColor();
    }

    public final String component2() {
        return getUsername();
    }

    public final String component3() {
        return getAvatar();
    }

    public final String component4() {
        return getBanner();
    }

    public final boolean component5() {
        return getIsBot();
    }

    public final boolean component6() {
        return getIsSystemUser();
    }

    public final int component7() {
        return getDiscriminator();
    }

    public final PremiumTier component8() {
        return getPremiumTier();
    }

    public final int component9() {
        return getFlags();
    }

    public final CoreUser copy(long id2, String username, String avatar, String banner, boolean isBot, boolean isSystemUser, int discriminator, PremiumTier premiumTier, int flags, int publicFlags, String bio, String bannerColor) {
        m.checkNotNullParameter(username, "username");
        m.checkNotNullParameter(premiumTier, "premiumTier");
        return new CoreUser(id2, username, avatar, banner, isBot, isSystemUser, discriminator, premiumTier, flags, publicFlags, bio, bannerColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreUser)) {
            return false;
        }
        CoreUser coreUser = (CoreUser) other;
        return getId() == coreUser.getId() && m.areEqual(getUsername(), coreUser.getUsername()) && m.areEqual(getAvatar(), coreUser.getAvatar()) && m.areEqual(getBanner(), coreUser.getBanner()) && getIsBot() == coreUser.getIsBot() && getIsSystemUser() == coreUser.getIsSystemUser() && getDiscriminator() == coreUser.getDiscriminator() && m.areEqual(getPremiumTier(), coreUser.getPremiumTier()) && getFlags() == coreUser.getFlags() && getPublicFlags() == coreUser.getPublicFlags() && m.areEqual(getBio(), coreUser.getBio()) && m.areEqual(getBannerColor(), coreUser.getBannerColor());
    }

    @Override // com.discord.models.user.User
    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.discord.models.user.User
    public String getBanner() {
        return this.banner;
    }

    @Override // com.discord.models.user.User
    public String getBannerColor() {
        return this.bannerColor;
    }

    @Override // com.discord.models.user.User
    public String getBio() {
        return this.bio;
    }

    @Override // com.discord.models.user.User
    public int getDiscriminator() {
        return this.discriminator;
    }

    @Override // com.discord.models.user.User
    public int getFlags() {
        return this.flags;
    }

    @Override // com.discord.models.user.User
    public long getId() {
        return this.id;
    }

    @Override // com.discord.models.user.User
    public PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    @Override // com.discord.models.user.User
    public int getPublicFlags() {
        return this.publicFlags;
    }

    @Override // com.discord.models.user.User
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iA = b.a(getId()) * 31;
        String username = getUsername();
        int iHashCode = (iA + (username != null ? username.hashCode() : 0)) * 31;
        String avatar = getAvatar();
        int iHashCode2 = (iHashCode + (avatar != null ? avatar.hashCode() : 0)) * 31;
        String banner = getBanner();
        int iHashCode3 = (iHashCode2 + (banner != null ? banner.hashCode() : 0)) * 31;
        boolean isBot = getIsBot();
        int i = isBot;
        if (isBot) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean isSystemUser = getIsSystemUser();
        int discriminator = (getDiscriminator() + ((i2 + (isSystemUser ? 1 : isSystemUser)) * 31)) * 31;
        PremiumTier premiumTier = getPremiumTier();
        int publicFlags = (getPublicFlags() + ((getFlags() + ((discriminator + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31)) * 31)) * 31;
        String bio = getBio();
        int iHashCode4 = (publicFlags + (bio != null ? bio.hashCode() : 0)) * 31;
        String bannerColor = getBannerColor();
        return iHashCode4 + (bannerColor != null ? bannerColor.hashCode() : 0);
    }

    @Override // com.discord.models.user.User
    /* JADX INFO: renamed from: isBot, reason: from getter */
    public boolean getIsBot() {
        return this.isBot;
    }

    @Override // com.discord.models.user.User
    /* JADX INFO: renamed from: isSystemUser, reason: from getter */
    public boolean getIsSystemUser() {
        return this.isSystemUser;
    }

    public String toString() {
        StringBuilder sbU = a.U("CoreUser(id=");
        sbU.append(getId());
        sbU.append(", username=");
        sbU.append(getUsername());
        sbU.append(", avatar=");
        sbU.append(getAvatar());
        sbU.append(", banner=");
        sbU.append(getBanner());
        sbU.append(", isBot=");
        sbU.append(getIsBot());
        sbU.append(", isSystemUser=");
        sbU.append(getIsSystemUser());
        sbU.append(", discriminator=");
        sbU.append(getDiscriminator());
        sbU.append(", premiumTier=");
        sbU.append(getPremiumTier());
        sbU.append(", flags=");
        sbU.append(getFlags());
        sbU.append(", publicFlags=");
        sbU.append(getPublicFlags());
        sbU.append(", bio=");
        sbU.append(getBio());
        sbU.append(", bannerColor=");
        sbU.append(getBannerColor());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? null : str4, (i4 & 2048) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CoreUser(com.discord.api.user.User user) {
        m.checkNotNullParameter(user, "user");
        long id2 = user.getId();
        String username = user.getUsername();
        NullSerializable<String> nullSerializableA = user.a();
        String strA = nullSerializableA != null ? nullSerializableA.a() : null;
        NullSerializable<String> nullSerializableB = user.b();
        String strA2 = nullSerializableB != null ? nullSerializableB.a() : null;
        Boolean bot = user.getBot();
        boolean zBooleanValue = bot != null ? bot.booleanValue() : false;
        Boolean system = user.getSystem();
        boolean zBooleanValue2 = system != null ? system.booleanValue() : false;
        Integer intOrNull = s.toIntOrNull(user.getDiscriminator());
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
        PremiumTier premiumType = user.getPremiumType();
        premiumType = premiumType == null ? PremiumTier.NONE : premiumType;
        Integer flags = user.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : 0;
        Integer publicFlags = user.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : 0;
        NullSerializable<String> nullSerializableD = user.d();
        String strA3 = nullSerializableD != null ? nullSerializableD.a() : null;
        NullSerializable<String> nullSerializableC = user.c();
        this(id2, username, strA, strA2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, strA3, nullSerializableC != null ? nullSerializableC.a() : null);
    }
}
