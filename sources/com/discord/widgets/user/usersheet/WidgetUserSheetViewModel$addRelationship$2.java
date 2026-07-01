package com.discord.widgets.user.usersheet;

import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPIAbortMessages;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$addRelationship$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ int $successMessageStringRes;
    public final /* synthetic */ Integer $type;
    public final /* synthetic */ String $username;
    public final /* synthetic */ WidgetUserSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$addRelationship$2(WidgetUserSheetViewModel widgetUserSheetViewModel, Integer num, String str, int i) {
        super(1);
        this.this$0 = widgetUserSheetViewModel;
        this.$type = num;
        this.$username = str;
        this.$successMessageStringRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new WidgetUserSheetViewModel$addRelationship$2$1(this, error), new WidgetUserSheetViewModel$addRelationship$2$2(this));
    }
}
