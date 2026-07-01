package com.discord.widgets.voice.controls;

import b.d.b.a.a;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$FeatureContext;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetScreenShareNfxSheet$VoiceBottomSheetParams implements Serializable {
    private final WidgetVoiceBottomSheet$FeatureContext featureContext;
    private final boolean forwardToFullscreenIfVideoActivated;

    public WidgetScreenShareNfxSheet$VoiceBottomSheetParams(boolean z2, WidgetVoiceBottomSheet$FeatureContext widgetVoiceBottomSheet$FeatureContext) {
        m.checkNotNullParameter(widgetVoiceBottomSheet$FeatureContext, "featureContext");
        this.forwardToFullscreenIfVideoActivated = z2;
        this.featureContext = widgetVoiceBottomSheet$FeatureContext;
    }

    public static /* synthetic */ WidgetScreenShareNfxSheet$VoiceBottomSheetParams copy$default(WidgetScreenShareNfxSheet$VoiceBottomSheetParams widgetScreenShareNfxSheet$VoiceBottomSheetParams, boolean z2, WidgetVoiceBottomSheet$FeatureContext widgetVoiceBottomSheet$FeatureContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetScreenShareNfxSheet$VoiceBottomSheetParams.forwardToFullscreenIfVideoActivated;
        }
        if ((i & 2) != 0) {
            widgetVoiceBottomSheet$FeatureContext = widgetScreenShareNfxSheet$VoiceBottomSheetParams.featureContext;
        }
        return widgetScreenShareNfxSheet$VoiceBottomSheetParams.copy(z2, widgetVoiceBottomSheet$FeatureContext);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getForwardToFullscreenIfVideoActivated() {
        return this.forwardToFullscreenIfVideoActivated;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetVoiceBottomSheet$FeatureContext getFeatureContext() {
        return this.featureContext;
    }

    public final WidgetScreenShareNfxSheet$VoiceBottomSheetParams copy(boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet$FeatureContext featureContext) {
        m.checkNotNullParameter(featureContext, "featureContext");
        return new WidgetScreenShareNfxSheet$VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated, featureContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetScreenShareNfxSheet$VoiceBottomSheetParams)) {
            return false;
        }
        WidgetScreenShareNfxSheet$VoiceBottomSheetParams widgetScreenShareNfxSheet$VoiceBottomSheetParams = (WidgetScreenShareNfxSheet$VoiceBottomSheetParams) other;
        return this.forwardToFullscreenIfVideoActivated == widgetScreenShareNfxSheet$VoiceBottomSheetParams.forwardToFullscreenIfVideoActivated && m.areEqual(this.featureContext, widgetScreenShareNfxSheet$VoiceBottomSheetParams.featureContext);
    }

    public final WidgetVoiceBottomSheet$FeatureContext getFeatureContext() {
        return this.featureContext;
    }

    public final boolean getForwardToFullscreenIfVideoActivated() {
        return this.forwardToFullscreenIfVideoActivated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.forwardToFullscreenIfVideoActivated;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        WidgetVoiceBottomSheet$FeatureContext widgetVoiceBottomSheet$FeatureContext = this.featureContext;
        return i + (widgetVoiceBottomSheet$FeatureContext != null ? widgetVoiceBottomSheet$FeatureContext.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated=");
        sbU.append(this.forwardToFullscreenIfVideoActivated);
        sbU.append(", featureContext=");
        sbU.append(this.featureContext);
        sbU.append(")");
        return sbU.toString();
    }
}
