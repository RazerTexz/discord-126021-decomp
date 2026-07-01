package com.discord.widgets.chat.input.applicationcommands;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter$scroller$1 extends LinearSmoothScroller {
    public final /* synthetic */ SelectedApplicationCommandAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter$scroller$1(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, Context context) {
        super(context);
        this.this$0 = selectedApplicationCommandAdapter;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int getHorizontalSnapPreference() {
        return -1;
    }
}
