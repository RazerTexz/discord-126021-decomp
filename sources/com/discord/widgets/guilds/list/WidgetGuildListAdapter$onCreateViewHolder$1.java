package com.discord.widgets.guilds.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter$onCreateViewHolder$1 extends o implements Function1<Integer, View> {
    public final /* synthetic */ ViewGroup $parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildListAdapter$onCreateViewHolder$1(ViewGroup viewGroup) {
        super(1);
        this.$parent = viewGroup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final View invoke(int i) {
        return LayoutInflater.from(this.$parent.getContext()).inflate(i, this.$parent, false);
    }
}
