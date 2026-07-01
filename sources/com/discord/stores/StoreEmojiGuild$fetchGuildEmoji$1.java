package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild$fetchGuildEmoji$1 extends o implements Function1<List<? extends ModelEmojiGuild>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmojiGuild$fetchGuildEmoji$1(StoreEmojiGuild storeEmojiGuild, long j) {
        super(1);
        this.this$0 = storeEmojiGuild;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEmojiGuild> list) {
        invoke2((List<ModelEmojiGuild>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelEmojiGuild> list) {
        m.checkNotNullParameter(list, "emojis");
        StoreEmojiGuild.access$handleGuildEmojisLoaded(this.this$0, this.$guildId, list);
    }
}
