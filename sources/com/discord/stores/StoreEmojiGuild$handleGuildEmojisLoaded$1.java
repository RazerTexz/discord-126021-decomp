package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild$handleGuildEmojisLoaded$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $emojis;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmojiGuild$handleGuildEmojisLoaded$1(StoreEmojiGuild storeEmojiGuild, List list, long j) {
        super(0);
        this.this$0 = storeEmojiGuild;
        this.$emojis = list;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreEmojiGuild.access$getGuildEmoji$p(this.this$0).put(Long.valueOf(this.$guildId), this.$emojis);
        this.this$0.markChanged();
    }
}
