package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import com.discord.models.domain.ModelApplicationStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream extends WidgetUserSheetViewModel$Event {
    private final ModelApplicationStream stream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream(ModelApplicationStream modelApplicationStream) {
        super(null);
        m.checkNotNullParameter(modelApplicationStream, "stream");
        this.stream = modelApplicationStream;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream copy$default(WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream widgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream, ModelApplicationStream modelApplicationStream, int i, Object obj) {
        if ((i & 1) != 0) {
            modelApplicationStream = widgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream.stream;
        }
        return widgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream.copy(modelApplicationStream);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public final WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream copy(ModelApplicationStream stream) {
        m.checkNotNullParameter(stream, "stream");
        return new WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream(stream);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream) && m.areEqual(this.stream, ((WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream) other).stream);
        }
        return true;
    }

    public final ModelApplicationStream getStream() {
        return this.stream;
    }

    public int hashCode() {
        ModelApplicationStream modelApplicationStream = this.stream;
        if (modelApplicationStream != null) {
            return modelApplicationStream.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("RequestPermissionsForSpectateStream(stream=");
        sbU.append(this.stream);
        sbU.append(")");
        return sbU.toString();
    }
}
