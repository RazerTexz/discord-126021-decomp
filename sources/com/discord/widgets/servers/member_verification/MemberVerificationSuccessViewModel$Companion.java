package com.discord.widgets.servers.member_verification;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel$Companion {
    private MemberVerificationSuccessViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(MemberVerificationSuccessViewModel$Companion memberVerificationSuccessViewModel$Companion, long j) {
        return memberVerificationSuccessViewModel$Companion.observeStores(j);
    }

    private final Observable<MemberVerificationSuccessViewModel$StoreState> observeStores(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<MemberVerificationSuccessViewModel$StoreState> observableJ = Observable.j(storeStream$Companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), MemberVerificationSuccessViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…?.name,\n        )\n      }");
        return observableJ;
    }

    public /* synthetic */ MemberVerificationSuccessViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
