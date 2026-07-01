package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.SelectComponent2;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.ComponentActionListener, reason: use source file name */
/* JADX INFO: compiled from: ComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ComponentView2 {
    void onButtonComponentClick(int componentIndex, String customId);

    void onSelectComponentClick(int componentIndex, String customId, String placeholder, List<SelectComponent2> options, List<SelectComponent2> selectedItems, int minOptionsToSelect, int maxOptionsToSelect, boolean emojiAnimationsEnabled);
}
