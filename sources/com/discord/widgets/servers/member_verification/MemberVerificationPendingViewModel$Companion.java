package com.discord.widgets.servers.member_verification;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel$Companion {
    private MemberVerificationPendingViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(MemberVerificationPendingViewModel$Companion memberVerificationPendingViewModel$Companion, long j) {
        return memberVerificationPendingViewModel$Companion.observeStores(j);
    }

    private final Observable<MemberVerificationPendingViewModel$StoreState> observeStores(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<MemberVerificationPendingViewModel$StoreState> observableI = Observable.i(storeStream$Companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), MemberVerificationPendingViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…Reason,\n        )\n      }");
        return observableI;
    }

    public /* synthetic */ MemberVerificationPendingViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
