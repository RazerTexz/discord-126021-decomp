package com.discord.widgets.media;

import b.a.d.d0;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetMediaViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMediaViewModel extends d0<Unit> {
    private long currentPlayerPositionMs;
    private boolean isPlaying;
    private boolean showCoverFrame;

    public WidgetMediaViewModel() {
        super(null, 1, null);
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
