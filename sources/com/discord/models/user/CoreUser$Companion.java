package com.discord.models.user;

import com.discord.api.premium.PremiumTier;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import d0.g0.s;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CoreUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoreUser$Companion {
    private CoreUser$Companion() {
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
        Integer flags = newUser.getFlags();
        int iIntValue2 = flags != null ? flags.intValue() : oldUser.getFlags();
        Integer publicFlags = newUser.getPublicFlags();
        int iIntValue3 = publicFlags != null ? publicFlags.intValue() : oldUser.getPublicFlags();
        NullSerializable<String> nullSerializableD = newUser.d();
        if (!(nullSerializableD instanceof NullSerializable$b)) {
            if (nullSerializableD instanceof NullSerializable$a) {
                str = null;
            } else {
                if (nullSerializableD != null) {
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
            return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
        }
        bio = (String) ((NullSerializable$b) nullSerializableD).a();
        str = bio;
        nullSerializableC = newUser.c();
        if (!(nullSerializableC instanceof NullSerializable$b)) {
            strA = nullSerializableC.a();
        } else {
            if (nullSerializableC == null) {
                throw new NoWhenBranchMatchedException();
            }
            strA = oldUser.getBannerColor();
        }
        return new CoreUser(id2, username, avatar, banner, zBooleanValue, zBooleanValue2, iIntValue, premiumType, iIntValue2, iIntValue3, str, strA);
    }

    public /* synthetic */ CoreUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
