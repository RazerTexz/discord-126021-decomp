package com.discord.widgets.mobile_reports;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel$handleSubmit$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ MobileReportsViewModel$ViewState$Menu $currentViewState;
    public final /* synthetic */ MobileReportsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$handleSubmit$2(MobileReportsViewModel mobileReportsViewModel, MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu) {
        super(1);
        this.this$0 = mobileReportsViewModel;
        this.$currentViewState = mobileReportsViewModel$ViewState$Menu;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        MobileReportsViewModel.access$updateViewState(this.this$0, MobileReportsViewModel$ViewState$Menu.copy$default(this.$currentViewState, null, null, null, null, null, null, MobileReportsViewModel$SubmitState$Error.INSTANCE, null, null, 447, null));
    }
}
