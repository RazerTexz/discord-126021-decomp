package com.discord.widgets.botuikit.views;

import com.discord.api.botuikit.SelectItem;
import java.util.List;

/* JADX INFO: compiled from: ComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ComponentActionListener {
    void onButtonComponentClick(int componentIndex, String customId);

    void onSelectComponentClick(int componentIndex, String customId, String placeholder, List<SelectItem> options, List<SelectItem> selectedItems, int minOptionsToSelect, int maxOptionsToSelect, boolean emojiAnimationsEnabled);
}
