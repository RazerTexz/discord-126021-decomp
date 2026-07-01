package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.widgets.botuikit.views.ComponentActionListener;

/* JADX INFO: compiled from: SelectComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentView$configure$3 implements View$OnClickListener {
    public final /* synthetic */ SelectMessageComponent $component;
    public final /* synthetic */ ComponentActionListener $componentActionListener;
    public final /* synthetic */ String $placeholder;

    public SelectComponentView$configure$3(ComponentActionListener componentActionListener, SelectMessageComponent selectMessageComponent, String str) {
        this.$componentActionListener = componentActionListener;
        this.$component = selectMessageComponent;
        this.$placeholder = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$componentActionListener.onSelectComponentClick(this.$component.getIndex(), this.$component.getCustomId(), this.$placeholder, this.$component.getOptions(), this.$component.getSelectedOptions(), this.$component.getMinValues(), this.$component.getMaxValues(), this.$component.getEmojiAnimationsEnabled());
    }
}
