package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;
import rx.functions.Func8;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeStoreState$2$1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Map<Long, ? extends GuildMember>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, ModelRichPresence, StreamContext, UserProfile, Boolean, Boolean, Channel, UserProfileHeaderViewModel$StoreState> {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ User $targetUser;

    public UserProfileHeaderViewModel$Companion$observeStoreState$2$1(MeUser meUser, User user) {
        this.$meUser = meUser;
        this.$targetUser = user;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ UserProfileHeaderViewModel$StoreState call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends Map<Long, ? extends GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
        return call2((Map<Long, GuildMember>) map, (Map<Long, ? extends Map<Long, GuildMember>>) map2, modelRichPresence, streamContext, userProfile, bool, bool2, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final UserProfileHeaderViewModel$StoreState call2(Map<Long, GuildMember> map, Map<Long, ? extends Map<Long, GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
        MeUser meUser = this.$meUser;
        m.checkNotNullExpressionValue(meUser, "meUser");
        User user = this.$targetUser;
        m.checkNotNullExpressionValue(map, "userIdToGuildMembersMap");
        Collection<? extends Map<Long, GuildMember>> collectionValues = map2.values();
        m.checkNotNullExpressionValue(userProfile, "userProfile");
        m.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(bool2, "reducedMotionEnabled");
        return new UserProfileHeaderViewModel$StoreState(meUser, user, map, collectionValues, modelRichPresence, streamContext, userProfile, zBooleanValue, bool2.booleanValue(), channel);
    }
}
