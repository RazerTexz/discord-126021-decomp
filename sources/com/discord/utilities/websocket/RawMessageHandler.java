package com.discord.utilities.websocket;


/* JADX INFO: compiled from: RawMessageHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface RawMessageHandler {
    void onRawMessage(String rawMessage);

    void onRawMessageInflateFailed(Throwable throwable);
}
