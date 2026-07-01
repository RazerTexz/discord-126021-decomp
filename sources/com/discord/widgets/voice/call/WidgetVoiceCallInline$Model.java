package com.discord.widgets.voice.call;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceCallInline$Model {
    public static final WidgetVoiceCallInline$Model$Companion Companion = new WidgetVoiceCallInline$Model$Companion(null);
    private final WidgetVoiceCallInline$Model$VoiceConnected voiceConnected;

    public WidgetVoiceCallInline$Model(WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected) {
        this.voiceConnected = widgetVoiceCallInline$Model$VoiceConnected;
    }

    public static /* synthetic */ WidgetVoiceCallInline$Model copy$default(WidgetVoiceCallInline$Model widgetVoiceCallInline$Model, WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetVoiceCallInline$Model$VoiceConnected = widgetVoiceCallInline$Model.voiceConnected;
        }
        return widgetVoiceCallInline$Model.copy(widgetVoiceCallInline$Model$VoiceConnected);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetVoiceCallInline$Model$VoiceConnected getVoiceConnected() {
        return this.voiceConnected;
    }

    public final WidgetVoiceCallInline$Model copy(WidgetVoiceCallInline$Model$VoiceConnected voiceConnected) {
        return new WidgetVoiceCallInline$Model(voiceConnected);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceCallInline$Model) && m.areEqual(this.voiceConnected, ((WidgetVoiceCallInline$Model) other).voiceConnected);
        }
        return true;
    }

    public final WidgetVoiceCallInline$Model$VoiceConnected getVoiceConnected() {
        return this.voiceConnected;
    }

    public int hashCode() {
        WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected = this.voiceConnected;
        if (widgetVoiceCallInline$Model$VoiceConnected != null) {
            return widgetVoiceCallInline$Model$VoiceConnected.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(voiceConnected=");
        sbU.append(this.voiceConnected);
        sbU.append(")");
        return sbU.toString();
    }
}
