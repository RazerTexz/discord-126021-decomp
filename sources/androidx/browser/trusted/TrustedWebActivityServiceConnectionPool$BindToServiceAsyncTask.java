package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityServiceConnectionPool$BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {
    private final Context mAppContext;
    private final ConnectionHolder mConnection;
    private final Intent mIntent;

    public TrustedWebActivityServiceConnectionPool$BindToServiceAsyncTask(Context context, Intent intent, ConnectionHolder connectionHolder) {
        this.mAppContext = context.getApplicationContext();
        this.mIntent = intent;
        this.mConnection = connectionHolder;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public /* bridge */ /* synthetic */ Exception doInBackground(Void[] voidArr) {
        return doInBackground2(voidArr);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Exception exc) {
        onPostExecute2(exc);
    }

    @Nullable
    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Exception doInBackground2(Void... voidArr) {
        try {
            if (this.mAppContext.bindService(this.mIntent, this.mConnection, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)) {
                return null;
            }
            this.mAppContext.unbindService(this.mConnection);
            return new IllegalStateException("Could not bind to the service");
        } catch (SecurityException e) {
            Log.w("TWAConnectionPool", "SecurityException while binding.", e);
            return e;
        }
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Exception exc) {
        if (exc != null) {
            this.mConnection.cancel(exc);
        }
    }
}
