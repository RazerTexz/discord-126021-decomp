package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.t.n;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild$deleteEmoji$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $emojiId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmojiGuild$deleteEmoji$1(StoreEmojiGuild storeEmojiGuild, long j, long j2) {
        super(0);
        this.this$0 = storeEmojiGuild;
        this.$guildId = j;
        this.$emojiId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map mapAccess$getGuildEmoji$p = StoreEmojiGuild.access$getGuildEmoji$p(this.this$0);
        Long lValueOf = Long.valueOf(this.$guildId);
        List listEmptyList = (List) StoreEmojiGuild.access$getGuildEmoji$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            if (this.$emojiId != ((ModelEmojiGuild) obj).getId()) {
                arrayList.add(obj);
            }
        }
        mapAccess$getGuildEmoji$p.put(lValueOf, arrayList);
        this.this$0.markChanged();
    }
}
