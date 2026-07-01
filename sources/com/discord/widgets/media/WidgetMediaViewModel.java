package com.discord.widgets.media;

import b.a.d.AppViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMediaViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMediaViewModel extends AppViewModel<Unit> {
    private long currentPlayerPositionMs;
    private boolean isPlaying;
    private boolean showCoverFrame;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetMediaViewModel() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker, 1, defaultConstructorMarker);
        this.isPlaying = true;
        this.showCoverFrame = true;
    }

    public final long getCurrentPlayerPositionMs() {
        return this.currentPlayerPositionMs;
    }

    public final boolean getShowCoverFrame() {
        return this.showCoverFrame;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void setCurrentPlayerPositionMs(long j) {
        this.currentPlayerPositionMs = j;
    }

    public final void setPlaying(boolean z2) {
        this.isPlaying = z2;
    }

    public final void setShowCoverFrame(boolean z2) {
        this.showCoverFrame = z2;
    }
}
