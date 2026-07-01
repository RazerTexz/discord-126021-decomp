package com.adjust.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesClient$GooglePlayServicesConnection implements ServiceConnection {
    public long timeoutMilliSec;
    public boolean retrieved = false;
    private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);

    public GooglePlayServicesClient$GooglePlayServicesConnection(long j) {
        this.timeoutMilliSec = j;
    }

    public IBinder getBinder() throws InterruptedException {
        if (this.retrieved) {
            throw new IllegalStateException();
        }
        this.retrieved = true;
        return this.queue.poll(this.timeoutMilliSec, TimeUnit.MILLISECONDS);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.queue.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
