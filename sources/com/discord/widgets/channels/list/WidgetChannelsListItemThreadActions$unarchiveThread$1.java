package com.discord.widgets.channels.list;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPIAbortMessages;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$unarchiveThread$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemThreadActions$unarchiveThread$1(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions) {
        super(1);
        this.this$0 = widgetChannelsListItemThreadActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        b.a.d.m.g(this.this$0.getContext(), abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : 2131893169, 0, null, 12);
    }
}
