package com.discord.widgets.mobile_reports;

import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.ReportNode;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel$2 extends o implements Function1<Pair<? extends MobileReportsViewModel$StoreState, ? extends MenuAPIResponse>, Unit> {
    public final /* synthetic */ MobileReportsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$2(MobileReportsViewModel mobileReportsViewModel) {
        super(1);
        this.this$0 = mobileReportsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends MobileReportsViewModel$StoreState, ? extends MenuAPIResponse> pair) {
        invoke2((Pair<MobileReportsViewModel$StoreState, MenuAPIResponse>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<MobileReportsViewModel$StoreState, MenuAPIResponse> pair) {
        ReportNode reportNode;
        MobileReportsViewModel$StoreState mobileReportsViewModel$StoreStateComponent1 = pair.component1();
        MenuAPIResponse menuAPIResponseComponent2 = pair.component2();
        if (menuAPIResponseComponent2 != null) {
            reportNode = menuAPIResponseComponent2.c().get(Integer.valueOf(menuAPIResponseComponent2.getRoot_node_id()));
        } else {
            reportNode = null;
        }
        if (menuAPIResponseComponent2 == null || reportNode == null) {
            MobileReportsViewModel.access$updateViewState(this.this$0, MobileReportsViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        MobileReportsViewModel mobileReportsViewModel = this.this$0;
        m.checkNotNullExpressionValue(mobileReportsViewModel$StoreStateComponent1, "storeState");
        MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreviewAccess$parseMessagePreview = MobileReportsViewModel.access$parseMessagePreview(mobileReportsViewModel, mobileReportsViewModel$StoreStateComponent1);
        MobileReportsViewModel mobileReportsViewModel2 = this.this$0;
        MobileReportsViewModel$ViewState mobileReportsViewModel$ViewStateAccess$getViewState$p = MobileReportsViewModel.access$getViewState$p(mobileReportsViewModel2);
        if (mobileReportsViewModel$ViewStateAccess$getViewState$p == null) {
            mobileReportsViewModel$ViewStateAccess$getViewState$p = new MobileReportsViewModel$ViewState$Menu(menuAPIResponseComponent2, mobileReportsViewModel$MessagePreviewAccess$parseMessagePreview, MobileReportsViewModel.access$parseChannelPreview(this.this$0, mobileReportsViewModel$StoreStateComponent1), MobileReportsViewModel.access$parseDirectoryServerPreview(this.this$0, mobileReportsViewModel$StoreStateComponent1), MobileReportsViewModel.access$parseEventPreview(this.this$0, mobileReportsViewModel$StoreStateComponent1), new MobileReportsViewModel$NodeNavigationType$Initial(reportNode), null, n.emptyList(), mobileReportsViewModel$MessagePreviewAccess$parseMessagePreview != null ? new MobileReportsViewModel$BlockUserElement(mobileReportsViewModel$StoreStateComponent1.getBlockedUsers().containsKey(Long.valueOf(mobileReportsViewModel$MessagePreviewAccess$parseMessagePreview.getAuthor().getId())), mobileReportsViewModel$MessagePreviewAccess$parseMessagePreview.getAuthor()) : null, 64, null);
        }
        MobileReportsViewModel.access$updateViewState(mobileReportsViewModel2, mobileReportsViewModel$ViewStateAccess$getViewState$p);
    }
}
