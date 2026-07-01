package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ Function0 $cancel;

    public WidgetChatListAdapterItemUploadProgress$onConfigure$3(Function0 function0) {
        this.$cancel = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$cancel.invoke();
    }
}
