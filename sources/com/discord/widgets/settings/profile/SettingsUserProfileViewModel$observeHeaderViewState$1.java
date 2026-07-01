package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.nullserializable.NullSerializable$a;
import com.discord.nullserializable.NullSerializable$b;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState$Loaded;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState$Uninitialized;
import j0.k.b;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$observeHeaderViewState$1<T, R> implements b<SettingsUserProfileViewModel$ViewState, UserProfileHeaderViewModel$ViewState> {
    public static final SettingsUserProfileViewModel$observeHeaderViewState$1 INSTANCE = new SettingsUserProfileViewModel$observeHeaderViewState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ UserProfileHeaderViewModel$ViewState call(SettingsUserProfileViewModel$ViewState settingsUserProfileViewModel$ViewState) {
        return call2(settingsUserProfileViewModel$ViewState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final UserProfileHeaderViewModel$ViewState call2(SettingsUserProfileViewModel$ViewState settingsUserProfileViewModel$ViewState) {
        String banner;
        GuildMember meMember;
        if (settingsUserProfileViewModel$ViewState == null) {
            return UserProfileHeaderViewModel$ViewState$Uninitialized.INSTANCE;
        }
        if (!(settingsUserProfileViewModel$ViewState instanceof SettingsUserProfileViewModel$ViewState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded = (SettingsUserProfileViewModel$ViewState$Loaded) settingsUserProfileViewModel$ViewState;
        MeUser user = (settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar() == null || settingsUserProfileViewModel$ViewState$Loaded.getMeMember() != null) ? settingsUserProfileViewModel$ViewState$Loaded.getUser() : MeUser.copy$default(settingsUserProfileViewModel$ViewState$Loaded.getUser(), 0L, null, settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar().a(), null, false, false, 0, null, null, false, false, null, 0, 0, null, null, null, null, 262139, null);
        UserProfile userProfile = settingsUserProfileViewModel$ViewState$Loaded.getUserProfile();
        if (settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage() == null) {
            GuildMember meMember2 = settingsUserProfileViewModel$ViewState$Loaded.getMeMember();
            if (meMember2 == null || (banner = meMember2.getBannerHash()) == null) {
                banner = settingsUserProfileViewModel$ViewState$Loaded.getUser().getBanner();
            }
        } else if (settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage() instanceof NullSerializable$a) {
            banner = settingsUserProfileViewModel$ViewState$Loaded.getMeMember() != null ? settingsUserProfileViewModel$ViewState$Loaded.getUser().getBanner() : null;
        } else {
            banner = settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage().a();
        }
        String str = banner;
        NullSerializable<String> currentBannerColorHex = settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerColorHex();
        String strA = ((currentBannerColorHex instanceof NullSerializable$b) || (currentBannerColorHex instanceof NullSerializable$a)) ? currentBannerColorHex.a() : settingsUserProfileViewModel$ViewState$Loaded.getUser().getBannerColor();
        boolean zIsPremium = UserUtils.INSTANCE.isPremium(settingsUserProfileViewModel$ViewState$Loaded.getUser());
        boolean zIsVerified = settingsUserProfileViewModel$ViewState$Loaded.getUser().isVerified();
        if (settingsUserProfileViewModel$ViewState$Loaded.getMeMember() != null) {
            GuildMember meMember3 = settingsUserProfileViewModel$ViewState$Loaded.getMeMember();
            if (settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar() != null) {
                meMember3 = GuildMember.copy$default(meMember3, 0, 0L, null, null, null, false, null, 0L, 0L, settingsUserProfileViewModel$ViewState$Loaded.getCurrentAvatar().a(), null, null, null, 7679, null);
            }
            GuildMember guildMemberCopy$default = meMember3;
            if (settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage() != null) {
                guildMemberCopy$default = GuildMember.copy$default(guildMemberCopy$default, 0, 0L, null, null, null, false, null, 0L, 0L, null, settingsUserProfileViewModel$ViewState$Loaded.getCurrentBannerImage().a(), null, null, 7167, null);
            }
            meMember = guildMemberCopy$default;
        } else {
            meMember = settingsUserProfileViewModel$ViewState$Loaded.getMeMember();
        }
        return new UserProfileHeaderViewModel$ViewState$Loaded(user, str, strA, meMember, null, null, null, userProfile, zIsPremium, zIsVerified, false, false, true, false, false, false, 58480, null);
    }
}
