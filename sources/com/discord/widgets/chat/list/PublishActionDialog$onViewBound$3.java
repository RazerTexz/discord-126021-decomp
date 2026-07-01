package com.discord.widgets.chat.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ PublishActionDialog this$0;

    public PublishActionDialog$onViewBound$3(PublishActionDialog publishActionDialog) {
        this.this$0 = publishActionDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
