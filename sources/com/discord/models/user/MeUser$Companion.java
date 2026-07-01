package com.discord.models.user;

import com.discord.api.premium.PremiumTier;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.Phone;
import com.discord.api.user.Phone$NoPhoneNumber;
import com.discord.api.user.Phone$PhoneNumber;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import d0.g0.s;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MeUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MeUser$Companion {
    private MeUser$Companion() {
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
        m.checkNotNullParameter(oldUser, "oldUser");
        m.checkNotNullParameter(newUser, "newUser");
        long id2 = newUser.getId();
        String username = newUser.getUsername();
        NullSerializable<String> nullSerializableA = newUser.a();
        if (nullSerializableA instanceof NullSerializable$b) {
            avatar = (String) ((NullSerializable$b) nullSerializableA).a();
        } else if (nullSerializableA instanceof NullSerializable$a) {
            avatar = null;
        } else {
            if (nullSerializableA != null) {
                throw new NoWhenBranchMatchedException();
            }
            avatar = oldUser.getAvatar();
        }
        NullSerializable<String> nullSerializableB = newUser.b();
        if (nullSerializableB instanceof NullSerializable$b) {
            banner = (String) ((NullSerializable$b) nullSerializableB).a();
        } else if (nullSerializableB instanceof NullSerializable$a) {
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
        Integer intOrNull = s.toIntOrNull(newUser.getDiscriminator());
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
        if (!(phone instanceof Phone$PhoneNumber)) {
            if (m.areEqual(phone, Phone$NoPhoneNumber.INSTANCE)) {
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
            if (nullSerializableD instanceof NullSerializable$b) {
                if (nullSerializableD instanceof NullSerializable$a) {
                    str2 = null;
                } else {
                    if (nullSerializableD == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bio = oldUser.getBio();
                }
                nullSerializableC = newUser.c();
                if (!(nullSerializableC instanceof NullSerializable$b) || (nullSerializableC instanceof NullSerializable$a)) {
                    strA = nullSerializableC.a();
                } else {
                    if (nullSerializableC == null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strA = oldUser.getBannerColor();
                }
                return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance, str2, strA);
            }
            bio = (String) ((NullSerializable$b) nullSerializableD).a();
            str2 = bio;
            nullSerializableC = newUser.c();
            if (!(nullSerializableC instanceof NullSerializable$b)) {
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
        phoneNumber = ((Phone$PhoneNumber) phone2).getNumber();
        str = phoneNumber;
        nsfwAllowed = newUser.getNsfwAllowed();
        if (nsfwAllowed == null) {
            nsfwAllowed = oldUser.getNsfwAllowance();
        }
        NsfwAllowance nsfwAllowance2 = nsfwAllowed;
        nullSerializableD = newUser.d();
        if (nullSerializableD instanceof NullSerializable$b) {
            if (nullSerializableD instanceof NullSerializable$a) {
                str2 = null;
            } else {
                if (nullSerializableD == null) {
                    throw new NoWhenBranchMatchedException();
                }
                bio = oldUser.getBio();
            }
            nullSerializableC = newUser.c();
            if (!(nullSerializableC instanceof NullSerializable$b)) {
                strA = nullSerializableC.a();
            } else {
                if (nullSerializableC == null) {
                    throw new NoWhenBranchMatchedException();
                }
                strA = oldUser.getBannerColor();
            }
            return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strA);
        }
        bio = (String) ((NullSerializable$b) nullSerializableD).a();
        str2 = bio;
        nullSerializableC = newUser.c();
        if (!(nullSerializableC instanceof NullSerializable$b)) {
            strA = nullSerializableC.a();
        } else {
            if (nullSerializableC == null) {
                throw new NoWhenBranchMatchedException();
            }
            strA = oldUser.getBannerColor();
        }
        return new MeUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, email, zBooleanValue3, zBooleanValue4, token, iIntValue2, iIntValue3, str, nsfwAllowance2, str2, strA);
    }

    public /* synthetic */ MeUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
