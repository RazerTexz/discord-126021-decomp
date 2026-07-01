package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.View;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;

/* JADX INFO: compiled from: StickyHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface StickyHeaderHolder {
    void bind(ApplicationPlaceholder item);

    View getItemView();
}
