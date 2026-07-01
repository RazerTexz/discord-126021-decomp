package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild$observeGuildEmoji$1 extends o implements Function0<List<? extends ModelEmojiGuild>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmojiGuild$observeGuildEmoji$1(StoreEmojiGuild storeEmojiGuild, long j) {
        super(0);
        this.this$0 = storeEmojiGuild;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ModelEmojiGuild> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ModelEmojiGuild> invoke2() {
        return this.this$0.getGuildEmoji(this.$guildId);
    }
}
