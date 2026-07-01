package com.discord.utilities.receiver.spotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;

/* JADX INFO: compiled from: SpotifyMetadataReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyMetadataReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_ID)) == null) {
            return;
        }
        m.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"id\") ?: return");
        try {
            StoreStream.Companion.getSpotify().setCurrentTrackId((String) u.last(w.split$default((CharSequence) stringExtra, new String[]{":"}, false, 0, 6, (Object) null)));
        } catch (Exception unused) {
            Logger.e$default(AppLog.g, a.w("Error parsing spotify track id: ", stringExtra), null, null, 6, null);
        }
    }
}
