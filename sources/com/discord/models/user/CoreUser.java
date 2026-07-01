package com.discord.models.user;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CoreUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CoreUser implements User {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: CoreUser.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:56:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:62:0x00fd  */
        public final CoreUser merge(CoreUser oldUser, com.discord.api.user.User newUser) {
            String avatar;
            String banner;
            String bio;
            String str;
            NullSerializable<String> nullSerializableC;
            String strA;
            Intrinsics3.checkNotNullParameter(oldUser, "oldUser");
            Intrinsics3.checkNotNullParameter(newUser, "newUser");
            long id2 = newUser.getId();
            String username = newUser.getUsername();
            NullSerializable<String> nullSerializableA = newUser.a();
            if (nullSerializableA instanceof NullSerializable.b) {
                avatar = (String) ((NullSerializable.b) nullSerializableA).a();
            } else if (nullSerializableA instanceof NullSerializable.a) {
                avatar = null;
            } else {
                if (nullSerializableA != null) {
                    throw new NoWhenBranchMatchedException();
                }
                avatar = oldUser.getAvatar();
            }
            NullSerializable<String> nullSerializableB = newUser.b();
            if (nullSerializableB instanceof NullSerializable.b) {
                banner = (String) ((NullSerializable.b) nullSerializableB).a();
            } else if (nullSerializableB instanceof NullSerializable.a) {
                banner = null;
            } else {
                if (nullSerializableB != null) {
                    throw new NoWhenBranchMatchedException();
                }
                banner = oldUser.getBanner();
            }
            Boolean bot = newUser.getBot();
            boolean zBooleanValue = bot != null ? bot.booleanValue() : oldUser.getIsBot();
            Boolean system = newUser.getSystem();
            boolean zBooleanValue2 = system != null ? system.booleanValue() : oldUser.getIsSystemUser();
            Integer intOrNull = StringNumberConversions.toIntOrNull(newUser.getDiscriminator());
            int iIntValue = intOrNull != null ? intOrNull.intValue() : oldUser.getDiscriminator();
            PremiumTier premiumType = newUser.getPremiumType();
            if (premiumType == null) {
                premiumType = oldUser.getPremiumTier();
            }
            Integer flags = newUser.getFlags();
            int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
            Integer publicFlags = newUser.getPublicFlags();
            int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
            NullSerializable<String> nullSerializableD = newUser.d();
            if (!(nullSerializableD instanceof NullSerializable.b)) {
                if (nullSerializableD instanceof NullSerializable.a) {
                    str = null;
                } else {
                    if (nullSerializableD != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bio = oldUser.getBio();
                }
                nullSerializableC = newUser.c();
                if (!(nullSerializableC instanceof NullSerializable.b) || (nullSerializableC instanceof NullSerializable.a)) {
                    strA = nullSerializableC.a();
                } else {
                    if (nullSerializableC == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strA = oldUser.getBannerColor();
                }
                return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
            }
            bio = (String) ((NullSerializable.b) nullSerializableD).a();
            str = bio;
            nullSerializableC = newUser.c();
            if (!(nullSerializableC instanceof NullSerializable.b)) {
                strA = nullSerializableC.a();
            } else {
                if (nullSerializableC == null) {
                    throw new NoWhenBranchMatchedException();
                }
                strA = oldUser.getBannerColor();
            }
            return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5) {
        Intrinsics3.checkNotNullParameter(str, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
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
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
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
        return getId() == coreUser.getId() && Intrinsics3.areEqual(getUsername(), coreUser.getUsername()) && Intrinsics3.areEqual(getAvatar(), coreUser.getAvatar()) && Intrinsics3.areEqual(getBanner(), coreUser.getBanner()) && getIsBot() == coreUser.getIsBot() && getIsSystemUser() == coreUser.getIsSystemUser() && getDiscriminator() == coreUser.getDiscriminator() && Intrinsics3.areEqual(getPremiumTier(), coreUser.getPremiumTier()) && getFlags() == coreUser.getFlags() && getPublicFlags() == coreUser.getPublicFlags() && Intrinsics3.areEqual(getBio(), coreUser.getBio()) && Intrinsics3.areEqual(getBannerColor(), coreUser.getBannerColor());
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
        StringBuilder sbU = outline.U("CoreUser(id=");
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
        Intrinsics3.checkNotNullParameter(user, "user");
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
        Integer intOrNull = StringNumberConversions.toIntOrNull(user.getDiscriminator());
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
