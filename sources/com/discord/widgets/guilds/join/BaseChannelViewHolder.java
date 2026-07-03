package com.discord.widgets.guilds.join;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BaseChannelViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseChannelViewHolder(View view) {
        super(view);
        C12238m.checkNotNullParameter(view, "itemView");
    }

    public void bind(ChannelItem data) {
        C12238m.checkNotNullParameter(data, "data");
    }
}
