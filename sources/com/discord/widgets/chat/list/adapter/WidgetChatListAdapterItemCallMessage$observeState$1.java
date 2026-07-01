package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage$observeState$1<T, R> implements b<Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, WidgetChatListAdapterItemCallMessage$State> {
    public final /* synthetic */ MessageEntry $messageEntry;

    public WidgetChatListAdapterItemCallMessage$observeState$1(MessageEntry messageEntry) {
        this.$messageEntry = messageEntry;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemCallMessage$State call(Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map) {
        return call2((Map<Long, StoreVoiceParticipants$VoiceUser>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemCallMessage$State call2(Map<Long, StoreVoiceParticipants$VoiceUser> map) {
        m.checkNotNullExpressionValue(map, "voiceParticipants");
        return new WidgetChatListAdapterItemCallMessage$State(map, this.$messageEntry);
    }
}
