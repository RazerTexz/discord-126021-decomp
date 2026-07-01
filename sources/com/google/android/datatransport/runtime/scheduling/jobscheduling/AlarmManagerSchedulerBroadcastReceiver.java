package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.TransportRuntime;
import b.i.a.b.j.t.h.Uploader;
import b.i.a.b.j.t.h.Uploader6;
import b.i.a.b.j.w.PriorityMapping;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.b(context);
        TransportContext.a aVarA = TransportContext.a();
        aVarA.b(queryParameter);
        aVarA.c(PriorityMapping.b(iIntValue));
        if (queryParameter2 != null) {
            ((AutoValue_TransportContext.b) aVarA).f764b = Base64.decode(queryParameter2, 0);
        }
        Uploader6 uploader6 = TransportRuntime.a().e;
        uploader6.e.execute(new Uploader(uploader6, aVarA.a(), i, new Runnable() { // from class: b.i.a.b.j.t.h.a
            @Override // java.lang.Runnable
            public void run() {
                int i2 = AlarmManagerSchedulerBroadcastReceiver.a;
            }
        }));
    }
}
