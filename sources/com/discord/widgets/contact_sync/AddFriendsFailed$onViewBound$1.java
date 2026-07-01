package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AddFriendsFailed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddFriendsFailed$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ AddFriendsFailed this$0;

    public AddFriendsFailed$onViewBound$1(AddFriendsFailed addFriendsFailed) {
        this.this$0 = addFriendsFailed;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        Function0<Unit> onClose = this.this$0.getOnClose();
        if (onClose != null) {
            onClose.invoke();
        }
    }
}
