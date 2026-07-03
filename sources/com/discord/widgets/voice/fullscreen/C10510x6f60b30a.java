package com.discord.widgets.voice.fullscreen;

import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$ViewState$Valid$analyticsVideoLayout$2 */
/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10510x6f60b30a extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10510x6f60b30a(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        if (this.this$0.getDisplayMode() == WidgetCallFullscreenViewModel.DisplayMode.GRID) {
            return this.this$0.getFocusedParticipantKey() != null ? "focus" : "grid";
        }
        return null;
    }
}
