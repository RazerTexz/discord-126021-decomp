package com.discord.utilities.io;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtils$NetworkDownloadReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m.checkNotNullParameter(context, "context");
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == 1248865515 && action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            Function0 function0 = (Function0) NetworkUtils.access$getOnDownloadListeners$p(NetworkUtils.INSTANCE).get(Long.valueOf(intent.getLongExtra("extra_download_id", 0L)));
            if (function0 != null) {
            }
        }
    }
}
