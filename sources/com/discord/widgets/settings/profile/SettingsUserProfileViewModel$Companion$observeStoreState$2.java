package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.channel.GuildChannelsInfo$Companion;
import j0.k.b;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends MeUser, ? extends Guild>, Observable<? extends SettingsUserProfileViewModel$StoreState>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    public SettingsUserProfileViewModel$Companion$observeStoreState$2(StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, Long l) {
        this.$storeUserProfile = storeUserProfile;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends SettingsUserProfileViewModel$StoreState> call(Pair<? extends MeUser, ? extends Guild> pair) {
        return call2((Pair<MeUser, Guild>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsUserProfileViewModel$StoreState> call2(Pair<MeUser, Guild> pair) {
        MeUser meUserComponent1 = pair.component1();
        Guild guildComponent2 = pair.component2();
        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(meUserComponent1.getId());
        StoreGuilds storeGuilds = this.$storeGuilds;
        Long l = this.$guildId;
        Observable<GuildMember> observableObserveGuildMember = storeGuilds.observeGuildMember(l != null ? l.longValue() : -1L, meUserComponent1.getId());
        GuildChannelsInfo$Companion guildChannelsInfo$Companion = GuildChannelsInfo.Companion;
        Long l2 = this.$guildId;
        return Observable.i(observableObserveUserProfile, observableObserveGuildMember, guildChannelsInfo$Companion.get(l2 != null ? l2.longValue() : -1L), new SettingsUserProfileViewModel$Companion$observeStoreState$2$1(meUserComponent1, guildComponent2));
    }
}
