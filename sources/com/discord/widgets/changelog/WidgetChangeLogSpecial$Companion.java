package com.discord.widgets.changelog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$Companion {
    private WidgetChangeLogSpecial$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetChangeLogSpecial$Companion widgetChangeLogSpecial$Companion, Context context, String str, String str2, String str3, String str4, WidgetChangeLogSpecial$Companion$ExitStyle widgetChangeLogSpecial$Companion$ExitStyle, boolean z2, int i, Object obj) {
        widgetChangeLogSpecial$Companion.launch(context, str, str2, str3, str4, (i & 32) != 0 ? WidgetChangeLogSpecial$Companion$ExitStyle.CLOSE : widgetChangeLogSpecial$Companion$ExitStyle, (i & 64) != 0 ? false : z2);
    }

    public final void launch(Context context, String version, String revision, String video, String body, WidgetChangeLogSpecial$Companion$ExitStyle exitStyle, boolean hideVideo) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(version, "version");
        m.checkNotNullParameter(revision, "revision");
        m.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
        m.checkNotNullParameter(body, "body");
        m.checkNotNullParameter(exitStyle, "exitStyle");
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_EXTRA_EXIT_STYLE", exitStyle);
        bundle.putString("INTENT_EXTRA_VERSION", version);
        bundle.putString("INTENT_EXTRA_REVISION", revision);
        bundle.putString("INTENT_EXTRA_VIDEO", video);
        bundle.putString("INTENT_EXTRA_BODY", body);
        bundle.putBoolean("INTENT_EXTRA_HIDE_VIDEO", hideVideo);
        j.d(context, WidgetChangeLogSpecial.class, new Intent().putExtras(bundle));
    }

    public /* synthetic */ WidgetChangeLogSpecial$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
