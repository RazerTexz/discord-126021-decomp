package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker3 extends Lambda implements Function0<GifPickerViewModel> {
    public static final WidgetGifPicker3 INSTANCE = new WidgetGifPicker3();

    public WidgetGifPicker3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GifPickerViewModel invoke() {
        return new GifPickerViewModel(null, 1, null);
    }
}
