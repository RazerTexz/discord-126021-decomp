package com.adjust.sdk;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public class Util$4 extends AsyncTask<Object, Void, Void> {
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(Object[] objArr) {
        return doInBackground2(objArr);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Void doInBackground2(Object... objArr) {
        ((Runnable) objArr[0]).run();
        return null;
    }
}
