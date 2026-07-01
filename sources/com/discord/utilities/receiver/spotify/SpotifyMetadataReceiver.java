package com.discord.utilities.receiver.spotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: SpotifyMetadataReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyMetadataReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_ID)) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"id\") ?: return");
        try {
            StoreStream.INSTANCE.getSpotify().setCurrentTrackId((String) _Collections.last(Strings4.split$default((CharSequence) stringExtra, new String[]{":"}, false, 0, 6, (Object) null)));
        } catch (Exception unused) {
            Logger.e$default(AppLog.g, outline.w("Error parsing spotify track id: ", stringExtra), null, null, 6, null);
        }
    }
}
