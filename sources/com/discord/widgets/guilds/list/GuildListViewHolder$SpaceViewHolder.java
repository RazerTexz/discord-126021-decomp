package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$SpaceViewHolder extends GuildListViewHolder {
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder$SpaceViewHolder(View view) {
        super(view, null);
        m.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final void configure(int height) {
        ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.height = height;
        this.view.setLayoutParams(layoutParams);
    }

    public final View getView() {
        return this.view;
    }
}
