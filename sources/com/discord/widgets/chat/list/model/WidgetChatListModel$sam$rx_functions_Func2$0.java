package com.discord.widgets.chat.list.model;

import kotlin.jvm.functions.Function2;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$sam$rx_functions_Func2$0 implements Func2 {
    private final /* synthetic */ Function2 function;

    public WidgetChatListModel$sam$rx_functions_Func2$0(Function2 function2) {
        this.function = function2;
    }

    @Override // rx.functions.Func2
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return this.function.invoke(obj, obj2);
    }
}
