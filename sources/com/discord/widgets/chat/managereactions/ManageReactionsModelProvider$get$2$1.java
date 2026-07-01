package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.member.GuildMember;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import rx.functions.Func3;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2$1<T1, T2, T3, R> implements Func3<Boolean, List<? extends MessageReaction>, Map<Long, ? extends GuildMember>, Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>> {
    public static final ManageReactionsModelProvider$get$2$1 INSTANCE = new ManageReactionsModelProvider$get$2$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> call(Boolean bool, List<? extends MessageReaction> list, Map<Long, ? extends GuildMember> map) {
        return call2(bool, (List<MessageReaction>) list, (Map<Long, GuildMember>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Triple<Boolean, List<MessageReaction>, Map<Long, GuildMember>> call2(Boolean bool, List<MessageReaction> list, Map<Long, GuildMember> map) {
        return new Triple<>(bool, list, map);
    }
}
