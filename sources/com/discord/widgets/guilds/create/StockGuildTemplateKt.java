package com.discord.widgets.guilds.create;

import com.discord.restapi.RestAPIParams$CreateGuildChannel;
import d0.t.m;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StockGuildTemplateKt {
    private static final long SYSTEM_CHANNEL_ID = 11;

    public static final /* synthetic */ List access$createCategorySection(String str, long j, int i, ChannelTemplate... channelTemplateArr) {
        return createCategorySection(str, j, i, channelTemplateArr);
    }

    private static final List<RestAPIParams$CreateGuildChannel> createCategorySection(String str, long j, int i, ChannelTemplate... channelTemplateArr) {
        List listListOf = m.listOf(new RestAPIParams$CreateGuildChannel(4, Long.valueOf(j), str, null, null, null));
        ArrayList arrayList = new ArrayList(channelTemplateArr.length);
        for (ChannelTemplate channelTemplate : channelTemplateArr) {
            arrayList.add(new RestAPIParams$CreateGuildChannel(i, channelTemplate.getId(), channelTemplate.getName(), Long.valueOf(j), null, null));
        }
        return u.plus((Collection) listListOf, (Iterable) arrayList);
    }
}
