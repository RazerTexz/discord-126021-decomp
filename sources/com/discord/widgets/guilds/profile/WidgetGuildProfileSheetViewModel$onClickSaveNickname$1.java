package com.discord.widgets.guilds.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$onClickSaveNickname$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ Function0 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel$onClickSaveNickname$1(Function0 function0) {
        super(1);
        this.$onSuccess = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        this.$onSuccess.invoke();
    }
}
