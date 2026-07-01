package com.discord.widgets.changelog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$Companion {
    private WidgetChangeLog$Companion() {
    }

    public final void launch(Context context, String version, String revision, String video, String body) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(version, "version");
        m.checkNotNullParameter(revision, "revision");
        m.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
        m.checkNotNullParameter(body, "body");
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_EXTRA_VERSION", version);
        bundle.putString("INTENT_EXTRA_REVISION", revision);
        bundle.putString("INTENT_EXTRA_VIDEO", video);
        bundle.putString("INTENT_EXTRA_BODY", body);
        j.d(context, WidgetChangeLog.class, new Intent().putExtras(bundle));
    }

    public /* synthetic */ WidgetChangeLog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
