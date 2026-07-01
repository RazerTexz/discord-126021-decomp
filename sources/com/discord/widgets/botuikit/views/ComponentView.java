package com.discord.widgets.botuikit.views;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.ComponentProvider;

/* JADX INFO: compiled from: ComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ComponentView<T extends MessageComponent> {
    void configure(T component, ComponentProvider componentProvider, ComponentView2 componentActionListener);

    Component6 type();
}
