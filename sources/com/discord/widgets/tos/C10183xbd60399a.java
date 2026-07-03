package com.discord.widgets.tos;

import com.discord.api.user.UserProfile;
import com.discord.utilities.analytics.AnalyticsTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$onFetchSuccess$1 */
/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10183xbd60399a extends AbstractC12240o implements Function1<UserProfile, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ int $reason;
    public final /* synthetic */ WidgetTosReportViolationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10183xbd60399a(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, int i, long j, long j2) {
        super(1);
        this.this$0 = widgetTosReportViolationViewModel;
        this.$reason = i;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
        invoke2(userProfile);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfile userProfile) {
        C12238m.checkNotNullParameter(userProfile, "userProfile");
        List<UserProfile.GuildReference> listM8308d = userProfile.m8308d();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM8308d, 10));
        Iterator<T> it = listM8308d.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((UserProfile.GuildReference) it.next()).getId()));
        }
        AnalyticsTracker.INSTANCE.reportTosViolation(this.$reason, this.$channelId, this.$messageId, arrayList);
    }
}
