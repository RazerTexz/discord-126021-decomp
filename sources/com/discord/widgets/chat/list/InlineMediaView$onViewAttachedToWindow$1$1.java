package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$c;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView$onViewAttachedToWindow$1$1<T1, T2, R> implements Func2<PanelState, PanelState, Boolean> {
    public static final InlineMediaView$onViewAttachedToWindow$1$1 INSTANCE = new InlineMediaView$onViewAttachedToWindow$1$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState, PanelState panelState2) {
        return call2(panelState, panelState2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState, PanelState panelState2) {
        PanelState$c panelState$c = PanelState$c.a;
        return Boolean.valueOf(m.areEqual(panelState, panelState$c) || m.areEqual(panelState2, panelState$c));
    }
}
