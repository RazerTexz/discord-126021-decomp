package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFatalCrash.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFatalCrash$Companion {
    private WidgetFatalCrash$Companion() {
    }

    @SuppressLint({"SimpleDateFormat"})
    private final Intent createIntent(String source) {
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_EXTRA_CRASH_SOURCE", source);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        bundle.putString("INTENT_EXTRA_CRASH_TIME", simpleDateFormat.format(new Date()) + " GMT");
        Intent intentPutExtras = new Intent().putExtras(bundle);
        m.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
        return intentPutExtras;
    }

    public final void launch(Context context, Throwable throwable, String crashSource) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(throwable, "throwable");
        m.checkNotNullParameter(crashSource, "crashSource");
        AppLog appLog = AppLog.g;
        String simpleName = WidgetFatalCrash.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
        Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
        j.d(context, WidgetFatalCrash.class, createIntent(crashSource));
    }

    public /* synthetic */ WidgetFatalCrash$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
