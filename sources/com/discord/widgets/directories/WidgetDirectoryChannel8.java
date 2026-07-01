package com.discord.widgets.directories;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel8 extends Lambda implements Function0<WidgetDirectoriesViewModel> {
    public static final WidgetDirectoryChannel8 INSTANCE = new WidgetDirectoryChannel8();

    public WidgetDirectoryChannel8() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoriesViewModel invoke() {
        return new WidgetDirectoriesViewModel(null, null, null, null, null, null, 63, null);
    }
}
