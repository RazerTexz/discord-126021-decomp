package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$removeAllReactions$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListActions$Model $model;
    public final /* synthetic */ WidgetChatListActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$removeAllReactions$1(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        super(1);
        this.this$0 = widgetChatListActions;
        this.$model = widgetChatListActions$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().removeAllReactions(this.$model.getMessage().getChannelId(), this.$model.getMessage().getId()), false, 1, null), this.this$0, null, 2, null), view.getContext(), "REST: removeAllReactions", (Function1) null, new WidgetChatListActions$removeAllReactions$1$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }
}
