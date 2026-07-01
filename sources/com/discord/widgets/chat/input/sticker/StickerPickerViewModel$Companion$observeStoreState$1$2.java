package com.discord.widgets.chat.input.sticker;

import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function11;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerViewModel$Companion$observeStoreState$1$2 extends o implements Function11<LinkedHashMap<Long, Guild>, Map<Long, ? extends Map<Long, ? extends Sticker>>, List<? extends ModelStickerPack>, List<? extends Long>, String, Integer, Long, MeUser, ExpressionTrayTab, Map<Long, ? extends Long>, Integer, StickerPickerViewModel$StoreState$Loaded> {
    public final /* synthetic */ Channel $channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerViewModel$Companion$observeStoreState$1$2(Channel channel) {
        super(11);
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function11
    public /* bridge */ /* synthetic */ StickerPickerViewModel$StoreState$Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, ? extends Sticker>> map, List<? extends ModelStickerPack> list, List<? extends Long> list2, String str, Integer num, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, ? extends Long> map2, Integer num2) {
        return invoke(linkedHashMap, (Map<Long, ? extends Map<Long, Sticker>>) map, (List<ModelStickerPack>) list, (List<Long>) list2, str, num.intValue(), l, meUser, expressionTrayTab, (Map<Long, Long>) map2, num2.intValue());
    }

    public final StickerPickerViewModel$StoreState$Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, Sticker>> map, List<ModelStickerPack> list, List<Long> list2, String str, int i, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, Long> map2, int i2) {
        m.checkNotNullParameter(map, "guildStickers");
        m.checkNotNullParameter(list, "enabledStickerPacks");
        m.checkNotNullParameter(list2, "frequentlyUsedStickerIds");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(expressionTrayTab, "selectedExpressionPickerTab");
        m.checkNotNullParameter(map2, "allChannelPermissions");
        m.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
        m.checkNotNullExpressionValue(str, "searchInputString");
        boolean z2 = expressionTrayTab == ExpressionTrayTab.STICKER;
        Channel channel = this.$channel;
        Long l2 = map2.get(Long.valueOf(channel != null ? channel.getId() : 0L));
        return new StickerPickerViewModel$StoreState$Loaded(linkedHashMap, map, list, list2, str, i, l, meUser, z2, channel, l2 != null ? l2.longValue() : 0L, i2 > 0);
    }
}
