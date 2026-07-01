package com.discord.models.user;

import a0.a.a.b;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.Phone;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MeUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MeUser implements User {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final String banner;
    private final String bannerColor;
    private final String bio;
    private final int discriminator;
    private final String email;
    private final int flags;
    private final boolean hasBirthday;
    private final long id;
    private final boolean isBot;
    private final boolean isSystemUser;
    private final boolean isVerified;
    private final boolean mfaEnabled;
    private final NsfwAllowance nsfwAllowance;
    private final String phoneNumber;
    private final PremiumTier premiumTier;
    private final int publicFlags;
    private final String token;
    private final String username;

    /* JADX INFO: compiled from: MeUser.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:70:0x0116  */
        /* JADX WARN: Code duplicated, block: B:73:0x0124  */
        /* JADX WARN: Code duplicated, block: B:75:0x012f  */
        /* JADX WARN: Code duplicated, block: B:77:0x0133  */
        /* JADX WARN: Code duplicated, block: B:78:0x0136 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:79:0x0138  */
        /* JADX WARN: Code duplicated, block: B:83:0x0146  */
        /* JADX WARN: Code duplicated, block: B:85:0x014a  */
        /* JADX WARN: Code duplicated, block: B:88:0x0155  */
        /* JADX WARN: Code duplicated, block: B:91:0x0176  */
        /* JADX WARN: Code duplicated, block: B:93:0x017c  */
        public final MeUser merge(MeUser oldUser, com.discord.api.user.User newUser) {
            String avatar;
            String banner;
            String phoneNumber;
            String str;
            NsfwAllowance nsfwAllowed;
            NullSerializable<String> nullSerializableD;
            String bio;
            String str2;
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
            String email = newUser.getEmail();
            if (email == null) {
                email = oldUser.getEmail();
            }
            Boolean mfaEnabled = newUser.getMfaEnabled();
            boolean zBooleanValue3 = mfaEnabled != null ? mfaEnabled.booleanValue() : oldUser.getMfaEnabled();
            Boolean verified = newUser.getVerified();
            boolean zBooleanValue4 = verified != null ? verified.booleanValue() : oldUser.isVerified();
            String token = newUser.getToken();
            if (token == null) {
                token = oldUser.getToken();
            }
            Integer flags = newUser.getFlags();
            int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
            Integer publicFlags = newUser.getPublicFlags();
            int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
            Phone phone = newUser.getPhone();
            if (!(phone instanceof Phone.PhoneNumber)) {
                if (Intrinsics3.areEqual(phone, Phone.NoPhoneNumber.INSTANCE)) {
                    str = null;
                } else {
                    if (phone != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    phoneNumber = oldUser.getPhoneNumber();
                }
                nsfwAllowed = newUser.getNsfwAllowed();
                if (nsfwAllowed == null) {
                    nsfwAllowed = oldUser.getNsfwAllowance();
                }
                NsfwAllowance nsfwAllowance = nsfwAllowed;
                nullSerializableD = newUser.d();
                if (nullSerializableD instanceof NullSerializable.b) {
                    if (nullSerializableD instanceof NullSerializable.a) {
                        str2 = null;
                    } else {
                        if (nullSerializableD == null) {
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
                    return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strA);
                }
                bio = (String) ((NullSerializable.b) nullSerializableD).a();
                str2 = bio;
                nullSerializableC = newUser.c();
                if (!(nullSerializableC instanceof NullSerializable.b)) {
                    strA = nullSerializableC.a();
                } else {
                    if (nullSerializableC == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strA = oldUser.getBannerColor();
                }
                return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strA);
            }
            Phone phone2 = newUser.getPhone();
            Objects.requireNonNull(phone2, "null cannot be cast to non-null type com.discord.api.user.Phone.PhoneNumber");
            phoneNumber = ((Phone.PhoneNumber) phone2).getNumber();
            str = phoneNumber;
            nsfwAllowed = newUser.getNsfwAllowed();
            if (nsfwAllowed == null) {
                nsfwAllowed = oldUser.getNsfwAllowance();
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowed;
            nullSerializableD = newUser.d();
            if (nullSerializableD instanceof NullSerializable.b) {
                if (nullSerializableD instanceof NullSerializable.a) {
                    str2 = null;
                } else {
                    if (nullSerializableD == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bio = oldUser.getBio();
                }
                nullSerializableC = newUser.c();
                if (!(nullSerializableC instanceof NullSerializable.b)) {
                    strA = nullSerializableC.a();
                } else {
                    if (nullSerializableC == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strA = oldUser.getBannerColor();
                }
                return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strA);
            }
            bio = (String) ((NullSerializable.b) nullSerializableD).a();
            str2 = bio;
            nullSerializableC = newUser.c();
            if (!(nullSerializableC instanceof NullSerializable.b)) {
                strA = nullSerializableC.a();
            } else {
                if (nullSerializableC == null) {
                    throw new NoWhenBranchMatchedException();
                }
                strA = oldUser.getBannerColor();
            }
            return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strA);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8) {
        Intrinsics3.checkNotNullParameter(str, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
        this.id = j;
        this.username = str;
        this.avatar = str2;
        this.banner = str3;
        this.isBot = z2;
        this.isSystemUser = z3;
        this.discriminator = i;
        this.premiumTier = premiumTier;
        this.email = str4;
        this.mfaEnabled = z4;
        this.isVerified = z5;
        this.token = str5;
        this.flags = i2;
        this.publicFlags = i3;
        this.phoneNumber = str6;
        this.nsfwAllowance = nsfwAllowance;
        this.bio = str7;
        this.bannerColor = str8;
        this.hasBirthday = nsfwAllowance != NsfwAllowance.UNKNOWN;
    }

    public final long component1() {
        return getId();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getMfaEnabled() {
        return this.mfaEnabled;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsVerified() {
        return this.isVerified;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final int component13() {
        return getFlags();
    }

    public final int component14() {
        return getPublicFlags();
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final NsfwAllowance getNsfwAllowance() {
        return this.nsfwAllowance;
    }

    public final String component17() {
        return getBio();
    }

    public final String component18() {
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

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final MeUser copy(long id2, String username, String avatar, String banner, boolean isBot, boolean isSystemUser, int discriminator, PremiumTier premiumTier, String email, boolean mfaEnabled, boolean isVerified, String token, int flags, int publicFlags, String phoneNumber, NsfwAllowance nsfwAllowance, String bio, String bannerColor) {
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(premiumTier, "premiumTier");
        Intrinsics3.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
        return new MeUser(id2, username, avatar, banner, isBot, isSystemUser, discriminator, premiumTier, email, mfaEnabled, isVerified, token, flags, publicFlags, phoneNumber, nsfwAllowance, bio, bannerColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeUser)) {
            return false;
        }
        MeUser meUser = (MeUser) other;
        return getId() == meUser.getId() && Intrinsics3.areEqual(getUsername(), meUser.getUsername()) && Intrinsics3.areEqual(getAvatar(), meUser.getAvatar()) && Intrinsics3.areEqual(getBanner(), meUser.getBanner()) && getIsBot() == meUser.getIsBot() && getIsSystemUser() == meUser.getIsSystemUser() && getDiscriminator() == meUser.getDiscriminator() && Intrinsics3.areEqual(getPremiumTier(), meUser.getPremiumTier()) && Intrinsics3.areEqual(this.email, meUser.email) && this.mfaEnabled == meUser.mfaEnabled && this.isVerified == meUser.isVerified && Intrinsics3.areEqual(this.token, meUser.token) && getFlags() == meUser.getFlags() && getPublicFlags() == meUser.getPublicFlags() && Intrinsics3.areEqual(this.phoneNumber, meUser.phoneNumber) && Intrinsics3.areEqual(this.nsfwAllowance, meUser.nsfwAllowance) && Intrinsics3.areEqual(getBio(), meUser.getBio()) && Intrinsics3.areEqual(getBannerColor(), meUser.getBannerColor());
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

    public final String getEmail() {
        return this.email;
    }

    @Override // com.discord.models.user.User
    public int getFlags() {
        return this.flags;
    }

    public final boolean getHasBirthday() {
        return this.hasBirthday;
    }

    @Override // com.discord.models.user.User
    public long getId() {
        return this.id;
    }

    public final boolean getMfaEnabled() {
        return this.mfaEnabled;
    }

    public final NsfwAllowance getNsfwAllowance() {
        return this.nsfwAllowance;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // com.discord.models.user.User
    public PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    @Override // com.discord.models.user.User
    public int getPublicFlags() {
        return this.publicFlags;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.discord.models.user.User
    public String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        int i3 = isSystemUser;
        if (isSystemUser) {
            i3 = 1;
        }
        int discriminator = (getDiscriminator() + ((i2 + i3) * 31)) * 31;
        PremiumTier premiumTier = getPremiumTier();
        int iHashCode4 = (discriminator + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
        String str = this.email;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.mfaEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i4 = (iHashCode5 + r0) * 31;
        boolean z3 = this.isVerified;
        int i5 = (i4 + (z3 ? 1 : z3)) * 31;
        String str2 = this.token;
        int publicFlags = (getPublicFlags() + ((getFlags() + ((i5 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31;
        String str3 = this.phoneNumber;
        int iHashCode6 = (publicFlags + (str3 != null ? str3.hashCode() : 0)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowance;
        int iHashCode7 = (iHashCode6 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
        String bio = getBio();
        int iHashCode8 = (iHashCode7 + (bio != null ? bio.hashCode() : 0)) * 31;
        String bannerColor = getBannerColor();
        return iHashCode8 + (bannerColor != null ? bannerColor.hashCode() : 0);
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

    public final boolean isVerified() {
        return this.isVerified;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MeUser(id=");
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
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", mfaEnabled=");
        sbU.append(this.mfaEnabled);
        sbU.append(", isVerified=");
        sbU.append(this.isVerified);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", flags=");
        sbU.append(getFlags());
        sbU.append(", publicFlags=");
        sbU.append(getPublicFlags());
        sbU.append(", phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", nsfwAllowance=");
        sbU.append(this.nsfwAllowance);
        sbU.append(", bio=");
        sbU.append(getBio());
        sbU.append(", bannerColor=");
        sbU.append(getBannerColor());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? false : z4, (i4 & 1024) != 0 ? false : z5, (i4 & 2048) != 0 ? null : str5, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? 0 : i3, (i4 & 16384) != 0 ? null : str6, (32768 & i4) != 0 ? NsfwAllowance.UNKNOWN : nsfwAllowance, (65536 & i4) != 0 ? null : str7, (i4 & 131072) != 0 ? null : str8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MeUser(com.discord.api.user.User user) {
        String number;
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
        String email = user.getEmail();
        Boolean mfaEnabled = user.getMfaEnabled();
        boolean zBooleanValue3 = mfaEnabled != null ? mfaEnabled.booleanValue() : false;
        Boolean verified = user.getVerified();
        boolean zBooleanValue4 = verified != null ? verified.booleanValue() : false;
        String token = user.getToken();
        Integer flags = user.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : 0;
        Integer publicFlags = user.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : 0;
        Phone phone = user.getPhone();
        if (phone instanceof Phone.PhoneNumber) {
            Phone phone2 = user.getPhone();
            Objects.requireNonNull(phone2, "null cannot be cast to non-null type com.discord.api.user.Phone.PhoneNumber");
            number = ((Phone.PhoneNumber) phone2).getNumber();
        } else {
            if (!Intrinsics3.areEqual(phone, Phone.NoPhoneNumber.INSTANCE) && phone != null) {
                throw new NoWhenBranchMatchedException();
            }
            number = null;
        }
        NsfwAllowance nsfwAllowed = user.getNsfwAllowed();
        NsfwAllowance nsfwAllowance = nsfwAllowed == null ? NsfwAllowance.UNKNOWN : nsfwAllowed;
        NullSerializable<String> nullSerializableD = user.d();
        String strA3 = nullSerializableD != null ? nullSerializableD.a() : null;
        NullSerializable<String> nullSerializableC = user.c();
        this(id2, username, strA, strA2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, number, nsfwAllowance, strA3, nullSerializableC != null ? nullSerializableC.a() : null);
    }
}
