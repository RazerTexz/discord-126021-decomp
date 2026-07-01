package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$5(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Integer type = this.$data.getMessage().getType();
        if (type != null && type.intValue() == -4) {
            StoreStream.Companion.getInteractions().resendApplicationCommand(this.$data.getMessage());
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(StoreMessages.resendMessage$default(StoreStream.Companion.getMessages(), this.$data.getMessage(), false, null, 6, null)), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChatListActions$configureUI$5$1.INSTANCE, 62, (Object) null);
        }
        this.this$0.dismiss();
    }
}
