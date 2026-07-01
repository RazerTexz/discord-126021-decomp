package com.discord.utilities;

import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EmbeddedActivityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedActivityUtilsKt {
    public static final List<UserGuildMember> getActivityParticipants(EmbeddedActivity embeddedActivity, Map<Long, StoreVoiceParticipants$VoiceUser> map) {
        m.checkNotNullParameter(embeddedActivity, "$this$getActivityParticipants");
        m.checkNotNullParameter(map, "voiceParticipants");
        List<Long> userIds = embeddedActivity.getUserIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = map.get(Long.valueOf(((Number) it.next()).longValue()));
            UserGuildMember userGuildMember = null;
            User user = storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getUser() : null;
            GuildMember guildMember = storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getGuildMember() : null;
            if (user != null && guildMember != null) {
                userGuildMember = new UserGuildMember(user, guildMember);
            }
            if (userGuildMember != null) {
                arrayList.add(userGuildMember);
            }
        }
        return arrayList;
    }
}
