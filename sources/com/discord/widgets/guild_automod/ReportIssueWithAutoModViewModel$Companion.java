package com.discord.widgets.guild_automod;

import com.discord.stores.StoreMessages;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel$Companion {
    private ReportIssueWithAutoModViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(ReportIssueWithAutoModViewModel$Companion reportIssueWithAutoModViewModel$Companion, long j, long j2, StoreMessages storeMessages) {
        return reportIssueWithAutoModViewModel$Companion.observeStores(j, j2, storeMessages);
    }

    private final Observable<ReportIssueWithAutoModViewModel$StoreState> observeStores(long channelId, long messageId, StoreMessages messageStore) {
        Observable observableG = messageStore.observeMessagesForChannel(channelId, messageId).G(ReportIssueWithAutoModViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "messageStore.observeMess…te(clientMessage)\n      }");
        return observableG;
    }

    public /* synthetic */ ReportIssueWithAutoModViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
