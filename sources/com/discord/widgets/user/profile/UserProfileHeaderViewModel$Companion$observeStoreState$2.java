package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.t.n0;
import j0.k.b;
import j0.l.a.c;
import j0.l.e.k;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends MeUser, ? extends User>, Observable<? extends UserProfileHeaderViewModel$StoreState>> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserPresence $storeUserPresence;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;
    public final /* synthetic */ StreamContextService $streamContextService;

    public UserProfileHeaderViewModel$Companion$observeStoreState$2(Long l, StoreChannels storeChannels, StoreGuilds storeGuilds, Long l2, StoreUserPresence storeUserPresence, StreamContextService streamContextService, StoreUserProfile storeUserProfile, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility) {
        this.$channelId = l;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l2;
        this.$storeUserPresence = storeUserPresence;
        this.$streamContextService = streamContextService;
        this.$storeUserProfile = storeUserProfile;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends UserProfileHeaderViewModel$StoreState> call2(Pair<MeUser, ? extends User> pair) {
        Observable<Channel> kVar;
        MeUser meUserComponent1 = pair.component1();
        User userComponent2 = pair.component2();
        if (userComponent2 == null) {
            return c.k;
        }
        Long l = this.$channelId;
        if (l != null) {
            l.longValue();
            kVar = this.$storeChannels.observeChannel(this.$channelId.longValue());
            if (kVar == null) {
                kVar = new k<>(null);
            }
        } else {
            kVar = new k<>(null);
        }
        return Observable.d(UserProfileHeaderViewModel$Companion.access$observeComputedMembers(UserProfileHeaderViewModel.Companion, this.$channelId, this.$guildId, n0.setOf((Object[]) new Long[]{Long.valueOf(meUserComponent1.getId()), Long.valueOf(userComponent2.getId())}), this.$storeChannels, this.$storeGuilds), this.$storeGuilds.observeComputed(), ModelRichPresence.Companion.get(userComponent2.getId(), this.$storeUserPresence), this.$streamContextService.getForUser(userComponent2.getId(), true), this.$storeUserProfile.observeUserProfile(userComponent2.getId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), kVar, new UserProfileHeaderViewModel$Companion$observeStoreState$2$1(meUserComponent1, userComponent2));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends UserProfileHeaderViewModel$StoreState> call(Pair<? extends MeUser, ? extends User> pair) {
        return call2((Pair<MeUser, ? extends User>) pair);
    }
}
