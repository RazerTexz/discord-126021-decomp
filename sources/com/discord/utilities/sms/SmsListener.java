package com.discord.utilities.sms;

import android.content.BroadcastReceiver;

/* JADX INFO: compiled from: SmsListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SmsListener {
    public static final SmsListener$Companion Companion = new SmsListener$Companion(null);
    private static BroadcastReceiver broadcastReceiver;

    public static final /* synthetic */ BroadcastReceiver access$getBroadcastReceiver$cp() {
        return broadcastReceiver;
    }

    public static final /* synthetic */ void access$setBroadcastReceiver$cp(BroadcastReceiver broadcastReceiver2) {
        broadcastReceiver = broadcastReceiver2;
    }
}
