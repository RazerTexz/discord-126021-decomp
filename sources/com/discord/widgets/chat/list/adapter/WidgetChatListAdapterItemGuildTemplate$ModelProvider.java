package com.discord.widgets.chat.list.adapter;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$ModelProvider {
    public static final WidgetChatListAdapterItemGuildTemplate$ModelProvider INSTANCE = new WidgetChatListAdapterItemGuildTemplate$ModelProvider();

    private WidgetChatListAdapterItemGuildTemplate$ModelProvider() {
    }

    public final Observable<WidgetChatListAdapterItemGuildTemplate$Model> get(GuildTemplateEntry item) {
        m.checkNotNullParameter(item, "item");
        Observable observableY = StoreStream.Companion.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).v(new WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1(item)).Y(WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
        return observableY;
    }
}
