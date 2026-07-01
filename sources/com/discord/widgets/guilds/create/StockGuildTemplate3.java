package com.discord.widgets.guilds.create;

import com.discord.restapi.RestAPIParams;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.StockGuildTemplateKt, reason: use source file name */
/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StockGuildTemplate3 {
    private static final long SYSTEM_CHANNEL_ID = 11;

    private static final List<RestAPIParams.CreateGuildChannel> createCategorySection(String str, long j, int i, StockGuildTemplate2... stockGuildTemplate2Arr) {
        List listListOf = CollectionsJVM.listOf(new RestAPIParams.CreateGuildChannel(4, Long.valueOf(j), str, null, null, null));
        ArrayList arrayList = new ArrayList(stockGuildTemplate2Arr.length);
        for (StockGuildTemplate2 stockGuildTemplate2 : stockGuildTemplate2Arr) {
            arrayList.add(new RestAPIParams.CreateGuildChannel(i, stockGuildTemplate2.getId(), stockGuildTemplate2.getName(), Long.valueOf(j), null, null));
        }
        return _Collections.plus((Collection) listListOf, (Iterable) arrayList);
    }
}
