package com.discord.widgets.user;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet3 extends Lambda implements Function0<WidgetUserStatusSheetViewModel> {
    public static final WidgetUserStatusSheet3 INSTANCE = new WidgetUserStatusSheet3();

    public WidgetUserStatusSheet3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserStatusSheetViewModel invoke() {
        return new WidgetUserStatusSheetViewModel(null, null, null, null, 15, null);
    }
}
