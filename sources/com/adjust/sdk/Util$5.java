package com.adjust.sdk;

import android.content.Context;
import android.os.AsyncTask;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Util$5 extends AsyncTask<Context, Void, String> {
    public final /* synthetic */ OnDeviceIdsRead val$onDeviceIdRead;

    public Util$5(OnDeviceIdsRead onDeviceIdsRead) {
        this.val$onDeviceIdRead = onDeviceIdsRead;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ String doInBackground(Context[] contextArr) {
        return doInBackground2(contextArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(String str) {
        onPostExecute2(str);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public String doInBackground2(Context... contextArr) {
        ILogger logger = AdjustFactory.getLogger();
        String strAccess$000 = Util.access$000(contextArr[0]);
        logger.debug(a.w("GoogleAdId read ", strAccess$000), new Object[0]);
        return strAccess$000;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(String str) {
        AdjustFactory.getLogger();
        this.val$onDeviceIdRead.onGoogleAdIdRead(str);
    }
}
