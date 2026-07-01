package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient$a extends Thread {
    public WeakReference<AdvertisingIdClient> j;
    public long k;
    public CountDownLatch l = new CountDownLatch(1);
    public boolean m = false;

    public AdvertisingIdClient$a(AdvertisingIdClient advertisingIdClient, long j) {
        this.j = new WeakReference<>(advertisingIdClient);
        this.k = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AdvertisingIdClient advertisingIdClient;
        try {
            if (this.l.await(this.k, TimeUnit.MILLISECONDS) || (advertisingIdClient = this.j.get()) == null) {
                return;
            }
            advertisingIdClient.a();
            this.m = true;
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = this.j.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.a();
                this.m = true;
            }
        }
    }
}
