package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.i.a.b.j.b$b;
import b.i.a.b.j.i;
import b.i.a.b.j.i$a;
import b.i.a.b.j.n;
import b.i.a.b.j.t.h.g;
import b.i.a.b.j.t.h.l;
import b.i.a.b.j.w.a;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat$MessagingStyle$Message.KEY_EXTRAS_BUNDLE);
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        n.b(context);
        i$a i_aA = i.a();
        i_aA.b(queryParameter);
        i_aA.c(a.b(iIntValue));
        if (queryParameter2 != null) {
            ((b$b) i_aA).f764b = Base64.decode(queryParameter2, 0);
        }
        l lVar = n.a().e;
        lVar.e.execute(new g(lVar, i_aA.a(), i, b.i.a.b.j.t.h.a.j));
    }
}
