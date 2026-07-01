package com.discord.widgets.user.presence;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ViewHolderStreamRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderStreamRichPresence$setOnStreamPreviewClicked$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onStreamPreviewClicked;

    public ViewHolderStreamRichPresence$setOnStreamPreviewClicked$1(Function0 function0) {
        this.$onStreamPreviewClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onStreamPreviewClicked.invoke();
    }
}
