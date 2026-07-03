package com.discord.models.user;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.PremiumTier;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.Phone;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12102s;
import p507d0.p592z.p594d.C12238m;

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
            NullSerializable<String> nullSerializableM8291d;
            String bio;
            String str2;
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
                if (C12238m.areEqual(phone, Phone.NoPhoneNumber.INSTANCE)) {
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
                nullSerializableM8291d = newUser.m8291d();
                if (nullSerializableM8291d instanceof NullSerializable.C5566b) {
                    if (nullSerializableM8291d instanceof NullSerializable.C5565a) {
                        str2 = null;
                    } else {
                        if (nullSerializableM8291d == null) {
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
                    return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strMo8429a);
                }
                bio = (String) ((NullSerializable.C5566b) nullSerializableM8291d).mo8429a();
                str2 = bio;
                nullSerializableM8290c = newUser.m8290c();
                if (!(nullSerializableM8290c instanceof NullSerializable.C5566b)) {
                    strMo8429a = nullSerializableM8290c.mo8429a();
                } else {
                    if (nullSerializableM8290c == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strMo8429a = oldUser.getBannerColor();
                }
                return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strMo8429a);
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
            nullSerializableM8291d = newUser.m8291d();
            if (nullSerializableM8291d instanceof NullSerializable.C5566b) {
                if (nullSerializableM8291d instanceof NullSerializable.C5565a) {
                    str2 = null;
                } else {
                    if (nullSerializableM8291d == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bio = oldUser.getBio();
                }
                nullSerializableM8290c = newUser.m8290c();
                if (!(nullSerializableM8290c instanceof NullSerializable.C5566b)) {
                    strMo8429a = nullSerializableM8290c.mo8429a();
                } else {
                    if (nullSerializableM8290c == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strMo8429a = oldUser.getBannerColor();
                }
                return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strMo8429a);
            }
            bio = (String) ((NullSerializable.C5566b) nullSerializableM8291d).mo8429a();
            str2 = bio;
            nullSerializableM8290c = newUser.m8290c();
            if (!(nullSerializableM8290c instanceof NullSerializable.C5566b)) {
                strMo8429a = nullSerializableM8290c.mo8429a();
            } else {
                if (nullSerializableM8290c == null) {
                    throw new NoWhenBranchMatchedException();
                }
                strMo8429a = oldUser.getBannerColor();
            }
            return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strMo8429a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8) {
        C12238m.checkNotNullParameter(str, "username");
        C12238m.checkNotNullParameter(premiumTier, "premiumTier");
        C12238m.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
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
        C12238m.checkNotNullParameter(username, "username");
        C12238m.checkNotNullParameter(premiumTier, "premiumTier");
        C12238m.checkNotNullParameter(nsfwAllowance, "nsfwAllowance");
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
        return getId() == meUser.getId() && C12238m.areEqual(getUsername(), meUser.getUsername()) && C12238m.areEqual(getAvatar(), meUser.getAvatar()) && C12238m.areEqual(getBanner(), meUser.getBanner()) && getIsBot() == meUser.getIsBot() && getIsSystemUser() == meUser.getIsSystemUser() && getDiscriminator() == meUser.getDiscriminator() && C12238m.areEqual(getPremiumTier(), meUser.getPremiumTier()) && C12238m.areEqual(this.email, meUser.email) && this.mfaEnabled == meUser.mfaEnabled && this.isVerified == meUser.isVerified && C12238m.areEqual(this.token, meUser.token) && getFlags() == meUser.getFlags() && getPublicFlags() == meUser.getPublicFlags() && C12238m.areEqual(this.phoneNumber, meUser.phoneNumber) && C12238m.areEqual(this.nsfwAllowance, meUser.nsfwAllowance) && C12238m.areEqual(getBio(), meUser.getBio()) && C12238m.areEqual(getBannerColor(), meUser.getBannerColor());
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
        StringBuilder sbM833U = C1643a.m833U("MeUser(id=");
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
        sbM833U.append(", email=");
        sbM833U.append(this.email);
        sbM833U.append(", mfaEnabled=");
        sbM833U.append(this.mfaEnabled);
        sbM833U.append(", isVerified=");
        sbM833U.append(this.isVerified);
        sbM833U.append(", token=");
        sbM833U.append(this.token);
        sbM833U.append(", flags=");
        sbM833U.append(getFlags());
        sbM833U.append(", publicFlags=");
        sbM833U.append(getPublicFlags());
        sbM833U.append(", phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", nsfwAllowance=");
        sbM833U.append(this.nsfwAllowance);
        sbM833U.append(", bio=");
        sbM833U.append(getBio());
        sbM833U.append(", bannerColor=");
        sbM833U.append(getBannerColor());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ MeUser(long j, String str, String str2, String str3, boolean z2, boolean z3, int i, PremiumTier premiumTier, String str4, boolean z4, boolean z5, String str5, int i2, int i3, String str6, NsfwAllowance nsfwAllowance, String str7, String str8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? PremiumTier.NONE : premiumTier, (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? false : z4, (i4 & 1024) != 0 ? false : z5, (i4 & 2048) != 0 ? null : str5, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? 0 : i3, (i4 & 16384) != 0 ? null : str6, (32768 & i4) != 0 ? NsfwAllowance.UNKNOWN : nsfwAllowance, (65536 & i4) != 0 ? null : str7, (i4 & 131072) != 0 ? null : str8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MeUser(com.discord.api.user.User user) {
        String number;
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
            if (!C12238m.areEqual(phone, Phone.NoPhoneNumber.INSTANCE) && phone != null) {
                throw new NoWhenBranchMatchedException();
            }
            number = null;
        }
        NsfwAllowance nsfwAllowed = user.getNsfwAllowed();
        NsfwAllowance nsfwAllowance = nsfwAllowed == null ? NsfwAllowance.UNKNOWN : nsfwAllowed;
        NullSerializable<String> nullSerializableM8291d = user.m8291d();
        String strMo8429a3 = nullSerializableM8291d != null ? nullSerializableM8291d.mo8429a() : null;
        NullSerializable<String> nullSerializableM8290c = user.m8290c();
        this(id2, username, strMo8429a, strMo8429a2, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, number, nsfwAllowance, strMo8429a3, nullSerializableM8290c != null ? nullSerializableM8290c.mo8429a() : null);
    }
}
