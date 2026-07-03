package com.discord.widgets.guilds.profile;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BaseEmojiViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEmojiViewHolder(View view) {
        super(view);
        C12238m.checkNotNullParameter(view, "itemView");
    }

    public void bind(EmojiItem data) {
        C12238m.checkNotNullParameter(data, "data");
    }
}
