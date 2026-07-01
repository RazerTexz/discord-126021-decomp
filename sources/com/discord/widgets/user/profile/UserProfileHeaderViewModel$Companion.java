package com.discord.widgets.user.profile;

import androidx.annotation.VisibleForTesting;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.streams.StreamContextService;
import d0.t.h0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion {
    private UserProfileHeaderViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeComputedMembers(UserProfileHeaderViewModel$Companion userProfileHeaderViewModel$Companion, Long l, Long l2, Collection collection, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        return userProfileHeaderViewModel$Companion.observeComputedMembers(l, l2, collection, storeChannels, storeGuilds);
    }

    private final Observable<Map<Long, GuildMember>> observeComputedMembers(Long channelId, Long guildId, Collection<Long> users, StoreChannels storeChannels, StoreGuilds storeGuilds) {
        if (channelId != null && channelId.longValue() > 0) {
            Observable observableY = storeChannels.observeChannel(channelId.longValue()).Y(new UserProfileHeaderViewModel$Companion$observeComputedMembers$1(storeGuilds, users));
            m.checkNotNullExpressionValue(observableY, "storeChannels\n          …emptyMap())\n            }");
            return observableY;
        }
        if (guildId != null && guildId.longValue() > 0) {
            return storeGuilds.observeComputed(guildId.longValue(), users);
        }
        k kVar = new k(h0.emptyMap());
        m.checkNotNullExpressionValue(kVar, "Observable.just(emptyMap())");
        return kVar;
    }

    public static /* synthetic */ Observable observeStoreState$default(UserProfileHeaderViewModel$Companion userProfileHeaderViewModel$Companion, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility, int i, Object obj) {
        return userProfileHeaderViewModel$Companion.observeStoreState(j, l, l2, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence, (i & 128) != 0 ? StoreStream.Companion.getUserProfile() : storeUserProfile, (i & 256) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 512) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings, (i & 1024) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService, (i & 2048) != 0 ? StoreStream.Companion.getAccessibility() : storeAccessibility);
    }

    @VisibleForTesting
    public final Observable<UserProfileHeaderViewModel$StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(streamContextService, "streamContextService");
        m.checkNotNullParameter(storeAccessibility, "storeAccessibility");
        Observable<UserProfileHeaderViewModel$StoreState> observableY = StoreUser.observeMe$default(storeUser, false, 1, null).Y(new UserProfileHeaderViewModel$Companion$observeStoreState$1(userId, storeUser)).Y(new UserProfileHeaderViewModel$Companion$observeStoreState$2(channelId, storeChannels, storeGuilds, guildId, storeUserPresence, streamContextService, storeUserProfile, storeUserSettings, storeAccessibility));
        m.checkNotNullExpressionValue(observableY, "storeUser.observeMe()\n  …            }\n          }");
        return observableY;
    }

    public /* synthetic */ UserProfileHeaderViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
