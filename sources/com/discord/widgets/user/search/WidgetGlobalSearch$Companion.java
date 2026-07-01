package com.discord.widgets.user.search;

import androidx.core.os.BundleKt;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.o;
import d0.t.n;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$Companion {
    private WidgetGlobalSearch$Companion() {
    }

    public static final /* synthetic */ Pair[] access$getFILTER_OPTIONS_LIST$p(WidgetGlobalSearch$Companion widgetGlobalSearch$Companion) {
        return widgetGlobalSearch$Companion.getFILTER_OPTIONS_LIST();
    }

    public static final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload access$toWidgetGlobalSearchModelItem(WidgetGlobalSearch$Companion widgetGlobalSearch$Companion, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        return widgetGlobalSearch$Companion.toWidgetGlobalSearchModelItem(widgetGlobalSearchGuildsModel$Item);
    }

    public static /* synthetic */ WidgetGlobalSearch create$default(WidgetGlobalSearch$Companion widgetGlobalSearch$Companion, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return widgetGlobalSearch$Companion.create(str);
    }

    private final Pair<Integer, Character>[] getFILTER_OPTIONS_LIST() {
        return new Pair[]{o.to(2131897013, Character.valueOf(MentionUtilsKt.MENTIONS_CHAR)), o.to(2131896304, Character.valueOf(MentionUtilsKt.CHANNELS_CHAR)), o.to(2131897174, '!'), o.to(2131895598, '*')};
    }

    private final WidgetGlobalSearchModel$ItemDataPayload toWidgetGlobalSearchModelItem(WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        Channel channel = widgetGlobalSearchGuildsModel$Item.getChannel();
        User userA = channel != null ? ChannelUtils.a(channel) : null;
        if (widgetGlobalSearchGuildsModel$Item.getGuild() != null) {
            return new WidgetGlobalSearchModel$ItemGuild(WidgetGlobalSearchModel.Companion.getEMPTY_MATCH_RESULT(), widgetGlobalSearchGuildsModel$Item.getGuild(), channel, 0, false, 24, null);
        }
        if (userA != null) {
            return new WidgetGlobalSearchModel$ItemUser(WidgetGlobalSearchModel.Companion.getEMPTY_MATCH_RESULT(), userA, n.emptyList(), false, null, channel, 0, false, Opcodes.CHECKCAST, null);
        }
        if (channel == null || !ChannelUtils.z(channel)) {
            return null;
        }
        return new WidgetGlobalSearchModel$ItemChannel(WidgetGlobalSearchModel.Companion.getEMPTY_MATCH_RESULT(), channel, null, null, 0, false, 48, null);
    }

    public final WidgetGlobalSearch create(String searchText) {
        WidgetGlobalSearch widgetGlobalSearch = new WidgetGlobalSearch();
        widgetGlobalSearch.setArguments(BundleKt.bundleOf(o.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
        return widgetGlobalSearch;
    }

    public /* synthetic */ WidgetGlobalSearch$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
