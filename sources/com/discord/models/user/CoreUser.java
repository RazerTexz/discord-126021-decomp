package com.discord.models.user;

import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12102s;
import p507d0.p592z.p594d.C12238m;

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
            NullSerializable<String> nullSerializableM8290c;
            String strMo8429a;
            C12238m.checkNotNullParameter(oldUser, "oldUser");
            C12238m.checkNotNullParameter(newUser, "newUser");
            long id2 = newUser.getId();
            String username = newUser.getUsername();
            NullSerializable<String> nullSerializableM8288a = newUser.m8288a();
            if (nullSerializableM8288a instanceof NullSerializable.C5566b) {
                avatar = (String) ((NullSerializable.C5566b) nullSerializableM8288a).mo8429a();
            } else if (nullSerializableM8288a instanceof NullSerializable.C5565a) {
                avatar = null;
            } else {
                if (nullSerializableM8288a != null) {
                    throw new NoWhenBranchMatchedException();
                }
                avatar = oldUser.getAvatar();
            }
            NullSerializable<String> nullSerializableM8289b = newUser.m8289b();
            if (nullSerializableM8289b instanceof NullSerializable.C5566b) {
                banner = (String) ((NullSerializable.C5566b) nullSerializableM8289b).mo8429a();
            } else if (nullSerializableM8289b instanceof NullSerializable.C5565a) {
                banner = null;
            } else {
                if (nullSerializableM8289b != null) {
                    throw new NoWhenBranchMatchedException();
                }
                banner = oldUser.getBanner();
            }
            Boolean bot = newUser.getBot();
            boolean zBooleanValue = bot != null ? bot.booleanValue() : oldUser.getIsBot();
            Boolean system = newUser.getSystem();
            boolean zBooleanValue2 = system != null ? system.booleanValue() : oldUser.getIsSystemUser();
            Integer intOrNull = C12102s.toIntOrNull(newUser.getDiscriminator());
            int iIntValue = intOrNull != null ? intOrNull.intValue() : oldUser.getDiscriminator();
            PremiumTier premiumType = newUser.getPremiumType();
            if (premiumType == null) {
                premiumType = oldUser.getPremiumTier();
            }
            Integer flags = newUser.getFlags();
            int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
            Integer publicFlags = newUser.getPublicFlags();
            int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
            NullSerializable<String> nullSerializableM8291d = newUser.m8291d();
            if (!(nullSerializableM8291d instanceof NullSerializable.C5566b)) {
                if (nullSerializableM8291d instanceof NullSerializable.C5565a) {
                    str = null;
                } else {
                    if (nullSerializableM8291d != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bio = oldUser.getBio();
                }
                nullSerializableM8290c = newUser.m8290c();
                if (!(nullSerializableM8290c instanceof NullSerializable.C5566b) || (nullSerializableM8290c instanceof NullSerializable.C5565a)) {
                    strMo8429a = nullSerializableM8290c.mo8429a();
                } else {
                    if (nullSerializableM8290c == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strMo8429a = oldUser.getBannerColor();
                }
                return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strMo8429a);
            }
            bio = (String) ((NullSerializable.C5566b) nullSerializableM8291d).mo8429a();
            str = bio;
            nullSerializableM8290c = newUser.m8290c();
            if (!(nullSerializableM8290c instanceof NullSerializable.C5566b)) {
                strMo8429a = nullSerializableM8290c.mo8429a();
            } else {
                if (nullSerializableM8290c == null) {
                    throw new NoWhenBranchMatchedException();
                }
                strMo8429a = oldUser.getBannerColor();
            }
            return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strMo8429a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5) {
        C12238m.checkNotNullParameter(str, "username");
        C12238m.checkNotNullParameter(premiumTier, "premiumTier");
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
        C12238m.checkNotNullParameter(username, "username");
        C12238m.checkNotNullParameter(premiumTier, "premiumTier");
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
        return getId() == coreUser.getId() && C12238m.areEqual(getUsername(), coreUser.getUsername()) && C12238m.areEqual(getAvatar(), coreUser.getAvatar()) && C12238m.areEqual(getBanner(), coreUser.getBanner()) && getIsBot() == coreUser.getIsBot() && getIsSystemUser() == coreUser.getIsSystemUser() && getDiscriminator() == coreUser.getDiscriminator() && C12238m.areEqual(getPremiumTier(), coreUser.getPremiumTier()) && getFlags() == coreUser.getFlags() && getPublicFlags() == coreUser.getPublicFlags() && C12238m.areEqual(getBio(), coreUser.getBio()) && C12238m.areEqual(getBannerColor(), coreUser.getBannerColor());
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
        int iM3a = C0002b.m3a(getId()) * 31;
        String username = getUsername();
        int iHashCode = (iM3a + (username != null ? username.hashCode() : 0)) * 31;
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
        StringBuilder sbM833U = C1643a.m833U("CoreUser(id=");
        sbM833U.append(getId());
        sbM833U.append(", username=");
        sbM833U.append(getUsername());
        sbM833U.append(", avatar=");
        sbM833U.append(getAvatar());
        sbM833U.append(", banner=");
        sbM833U.append(getBanner());
        sbM833U.append(", isBot=");
        sbM833U.append(getIsBot());
        sbM833U.append(", isSystemUser=");
        sbM833U.append(getIsSystemUser());
        sbM833U.append(", discriminator=");
        sbM833U.append(getDiscriminator());
        sbM833U.append(", premiumTier=");
        sbM833U.append(getPremiumTier());
        sbM833U.append(", flags=");
        sbM833U.append(getFlags());
        sbM833U.append(", publicFlags=");
        sbM833U.append(getPublicFlags());
        sbM833U.append(", bio=");
        sbM833U.append(getBio());
        sbM833U.append(", bannerColor=");
        sbM833U.append(getBannerColor());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ CoreUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, int i2, int i3, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? null : str4, (i4 & 2048) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CoreUser(com.discord.api.user.User user) {
        C12238m.checkNotNullParameter(user, "user");
        long id2 = user.getId();
        String username = user.getUsername();
        NullSerializable<String> nullSerializableM8288a = user.m8288a();
        String strMo8429a = nullSerializableM8288a != null ? nullSerializableM8288a.mo8429a() : null;
        NullSerializable<String> nullSerializableM8289b = user.m8289b();
        String strMo8429a2 = nullSerializableM8289b != null ? nullSerializableM8289b.mo8429a() : null;
        Boolean bot = user.getBot();
        boolean zBooleanValue = bot != null ? bot.booleanValue() : false;
        Boolean system = user.getSystem();
        boolean zBooleanValue2 = system != null ? system.booleanValue() : false;
        Integer intOrNull = C12102s.toIntOrNull(user.getDiscriminator());
        int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
        PremiumTier premiumType = user.getPremiumType();
        premiumType = premiumType == null ? PremiumTier.NONE : premiumType;
        Integer flags = user.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : 0;
        Integer publicFlags = user.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : 0;
        NullSerializable<String> nullSerializableM8291d = user.m8291d();
        String strMo8429a3 = nullSerializableM8291d != null ? nullSerializableM8291d.mo8429a() : null;
        NullSerializable<String> nullSerializableM8290c = user.m8290c();
        this(id2, username, strMo8429a, strMo8429a2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, strMo8429a3, nullSerializableM8290c != null ? nullSerializableM8290c.mo8429a() : null);
    }
}
