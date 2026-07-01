package com.discord.rtcconnection.mediaengine;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngine$c {
    void onConnected();

    void onConnecting();

    void onNativeEngineInitialized();

    void onNewConnection(MediaEngineConnection mediaEngineConnection);
}
