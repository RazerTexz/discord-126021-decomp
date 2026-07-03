package com.discord.utilities.receiver.spotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SpotifyMetadataReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpotifyMetadataReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_ID)) == null) {
            return;
        }
        C12238m.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"id\") ?: return");
        try {
            StoreStream.INSTANCE.getSpotify().setCurrentTrackId((String) C12163u.last(C12106w.split$default((CharSequence) stringExtra, new String[]{":"}, false, 0, 6, (Object) null)));
        } catch (Exception unused) {
            Logger.e$default(AppLog.f14950g, C1643a.m883w("Error parsing spotify track id: ", stringExtra), null, null, 6, null);
        }
    }
}
