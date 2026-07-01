package com.discord.widgets.guild_automod;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import j0.k.b;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel$Companion$observeStores$1<T, R> implements b<Message, ReportIssueWithAutoModViewModel$StoreState> {
    public static final ReportIssueWithAutoModViewModel$Companion$observeStores$1 INSTANCE = new ReportIssueWithAutoModViewModel$Companion$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ReportIssueWithAutoModViewModel$StoreState call(Message message) {
        return call2(message);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ReportIssueWithAutoModViewModel$StoreState call2(Message message) {
        return new ReportIssueWithAutoModViewModel$StoreState(message);
    }
}
