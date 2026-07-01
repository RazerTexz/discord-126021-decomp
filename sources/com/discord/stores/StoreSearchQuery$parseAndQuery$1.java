package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreSearchQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchQuery$parseAndQuery$1<T, R> implements b<String, List<QueryNode>> {
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    public StoreSearchQuery$parseAndQuery$1(SearchStringProvider searchStringProvider) {
        this.$searchStringProvider = searchStringProvider;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<QueryNode> call2(String str) {
        QueryParser queryParser = new QueryParser(this.$searchStringProvider);
        m.checkNotNullExpressionValue(str, "it");
        return Parser.parse$default(queryParser, str, null, null, 4, null);
    }
}
