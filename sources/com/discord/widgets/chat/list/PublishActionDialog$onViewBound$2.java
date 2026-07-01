package com.discord.widgets.chat.list;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ PublishActionDialog this$0;

    public PublishActionDialog$onViewBound$2(PublishActionDialog publishActionDialog) {
        this.this$0 = publishActionDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PublishActionDialog.access$getViewModel$p(this.this$0).publishMessage();
        Function0 function0Access$getOnSuccess$p = PublishActionDialog.access$getOnSuccess$p(this.this$0);
        if (function0Access$getOnSuccess$p != null) {
            function0Access$getOnSuccess$p.invoke();
        }
    }
}
