package com.discord.utilities.search.suggestion;

import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchSuggestionEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchSuggestionEngine$setupMemberRequestSubscription$3 extends o implements Function1<String, Unit> {
    public static final SearchSuggestionEngine$setupMemberRequestSubscription$3 INSTANCE = new SearchSuggestionEngine$setupMemberRequestSubscription$3();

    public SearchSuggestionEngine$setupMemberRequestSubscription$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        StoreGatewayConnection gatewaySocket = StoreStream.Companion.getGatewaySocket();
        Long targetGuildId = SearchSuggestionEngine.INSTANCE.getTargetGuildId();
        if (targetGuildId != null) {
            StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, targetGuildId.longValue(), str, null, null, 12, null);
        }
    }
}
