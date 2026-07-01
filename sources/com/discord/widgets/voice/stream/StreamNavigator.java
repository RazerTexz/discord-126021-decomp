package com.discord.widgets.voice.stream;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import androidx.fragment.app.Fragment;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StreamNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamNavigator {
    public static final StreamNavigator INSTANCE = new StreamNavigator();
    private static final int START_SCREENSHARE_REQUEST_CODE = 420;

    private StreamNavigator() {
    }

    public static final void handleActivityResult(int requestCode, int resultCode, Intent data, Function1<? super Intent, Unit> intentCallback) {
        Intrinsics3.checkNotNullParameter(intentCallback, "intentCallback");
        if (resultCode == -1 && requestCode == START_SCREENSHARE_REQUEST_CODE && data != null) {
            intentCallback.invoke(data);
        }
    }

    public static final void requestStartStream(Fragment fragment) {
        Context contextRequireContext;
        if (fragment == null || (contextRequireContext = fragment.requireContext()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment?.requireContext() ?: return");
        Object systemService = contextRequireContext.getSystemService("media_projection");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        fragment.startActivityForResult(((MediaProjectionManager) systemService).createScreenCaptureIntent(), START_SCREENSHARE_REQUEST_CODE);
    }
}
