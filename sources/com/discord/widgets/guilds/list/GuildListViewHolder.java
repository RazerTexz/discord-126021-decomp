package com.discord.widgets.guilds.list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildListViewHolder extends RecyclerView$ViewHolder {
    public /* synthetic */ GuildListViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public final void configureMentionsCount(TextView textView, int count) {
        m.checkNotNullParameter(textView, "textView");
        if (count < 1) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
        }
    }

    public void onDragEnded(boolean wasMerge) {
    }

    public void onDragStarted() {
    }

    private GuildListViewHolder(View view) {
        super(view);
    }
}
