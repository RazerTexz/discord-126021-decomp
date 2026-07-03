package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.C2435b;
import p007b.p225i.p226a.p228b.p231j.C2447n;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2484l;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.RunnableC2479g;
import p007b.p225i.p226a.p228b.p231j.p241w.C2524a;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f19692a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        C2447n.m2360b(context);
        AbstractC2442i.a aVarM2358a = AbstractC2442i.m2358a();
        aVarM2358a.mo2352b(queryParameter);
        aVarM2358a.mo2353c(C2524a.m2415b(iIntValue));
        if (queryParameter2 != null) {
            ((C2435b.b) aVarM2358a).f5262b = Base64.decode(queryParameter2, 0);
        }
        C2484l c2484l = C2447n.m2359a().f5294e;
        c2484l.f5389e.execute(new RunnableC2479g(c2484l, aVarM2358a.mo2351a(), i, new Runnable() { // from class: b.i.a.b.j.t.h.a
            @Override // java.lang.Runnable
            public void run() {
                int i2 = AlarmManagerSchedulerBroadcastReceiver.f19692a;
            }
        }));
    }
}
