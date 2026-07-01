package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPickerViewHolder$CreateChannelViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onItemClickListener;

    public ChannelPickerViewHolder$CreateChannelViewHolder$1(Function0 function0) {
        this.$onItemClickListener = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onItemClickListener.invoke();
    }
}
