package com.discord.utilities;

import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.discord.utilities.EmbeddedActivityUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: EmbeddedActivityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedActivityUtils {
    public static final List<UserGuildMember> getActivityParticipants(EmbeddedActivity embeddedActivity, Map<Long, StoreVoiceParticipants.VoiceUser> map) {
        Intrinsics3.checkNotNullParameter(embeddedActivity, "$this$getActivityParticipants");
        Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
        List<Long> userIds = embeddedActivity.getUserIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            StoreVoiceParticipants.VoiceUser voiceUser = map.get(Long.valueOf(((Number) it.next()).longValue()));
            UserGuildMember userGuildMember = null;
            User user = voiceUser != null ? voiceUser.getUser() : null;
            GuildMember guildMember = voiceUser != null ? voiceUser.getGuildMember() : null;
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
