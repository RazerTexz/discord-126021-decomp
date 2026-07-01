package com.discord.widgets.media;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia7 extends Lambda implements Function0<WidgetMediaViewModel> {
    public static final WidgetMedia7 INSTANCE = new WidgetMedia7();

    public WidgetMedia7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetMediaViewModel invoke() {
        return new WidgetMediaViewModel();
    }
}
