package com.discord.widgets.status;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$onUnarchiveTapped$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C10117x32a829cc extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetThreadStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10117x32a829cc(WidgetThreadStatusViewModel widgetThreadStatusViewModel) {
        super(1);
        this.this$0 = widgetThreadStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        C12238m.checkNotNullParameter(error, "error");
        WidgetThreadStatusViewModel widgetThreadStatusViewModel = this.this$0;
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        widgetThreadStatusViewModel.emitError(response.getCode());
    }
}
