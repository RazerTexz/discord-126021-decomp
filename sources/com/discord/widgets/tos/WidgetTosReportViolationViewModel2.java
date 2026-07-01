package com.discord.widgets.tos;

import com.discord.api.user.UserProfile;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$onFetchSuccess$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel2 extends Lambda implements Function1<UserProfile, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ int $reason;
    public final /* synthetic */ WidgetTosReportViolationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolationViewModel2(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, int i, long j, long j2) {
        super(1);
        this.this$0 = widgetTosReportViolationViewModel;
        this.$reason = i;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
        invoke2(userProfile);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
        List<UserProfile.GuildReference> listD = userProfile.d();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listD, 10));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((UserProfile.GuildReference) it.next()).getId()));
        }
        AnalyticsTracker.INSTANCE.reportTosViolation(this.$reason, this.$channelId, this.$messageId, arrayList);
    }
}
