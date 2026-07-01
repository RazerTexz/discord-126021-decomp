package com.discord.widgets.voice.sheet;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheet$BottomContent$Connect extends WidgetVoiceBottomSheet$BottomContent {
    private final boolean isConnectEnabled;

    public WidgetVoiceBottomSheet$BottomContent$Connect(boolean z2) {
        super(null);
        this.isConnectEnabled = z2;
    }

    public static /* synthetic */ WidgetVoiceBottomSheet$BottomContent$Connect copy$default(WidgetVoiceBottomSheet$BottomContent$Connect widgetVoiceBottomSheet$BottomContent$Connect, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetVoiceBottomSheet$BottomContent$Connect.isConnectEnabled;
        }
        return widgetVoiceBottomSheet$BottomContent$Connect.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsConnectEnabled() {
        return this.isConnectEnabled;
    }

    public final WidgetVoiceBottomSheet$BottomContent$Connect copy(boolean isConnectEnabled) {
        return new WidgetVoiceBottomSheet$BottomContent$Connect(isConnectEnabled);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheet$BottomContent$Connect) && this.isConnectEnabled == ((WidgetVoiceBottomSheet$BottomContent$Connect) other).isConnectEnabled;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isConnectEnabled;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isConnectEnabled() {
        return this.isConnectEnabled;
    }

    public String toString() {
        return a.O(a.U("Connect(isConnectEnabled="), this.isConnectEnabled, ")");
    }
}
