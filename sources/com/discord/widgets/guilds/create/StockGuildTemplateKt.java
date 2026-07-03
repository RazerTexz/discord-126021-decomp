package com.discord.widgets.guilds.create;

import com.discord.restapi.RestAPIParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;

/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StockGuildTemplateKt {
    private static final long SYSTEM_CHANNEL_ID = 11;

    private static final List<RestAPIParams.CreateGuildChannel> createCategorySection(String str, long j, int i, ChannelTemplate... channelTemplateArr) {
        List listListOf = C12145m.listOf(new RestAPIParams.CreateGuildChannel(4, Long.valueOf(j), str, null, null, null));
        ArrayList arrayList = new ArrayList(channelTemplateArr.length);
        for (ChannelTemplate channelTemplate : channelTemplateArr) {
            arrayList.add(new RestAPIParams.CreateGuildChannel(i, channelTemplate.getId(), channelTemplate.getName(), Long.valueOf(j), null, null));
        }
        return C12163u.plus((Collection) listListOf, (Iterable) arrayList);
    }
}
