package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class SendException extends Exception {
    private final int errorCode;

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    public SendException(String str) {
        super(str);
        int i = 1;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            lowerCase.hashCode();
            switch (lowerCase) {
                case "service_not_available":
                    i = 3;
                    break;
                case "toomanymessages":
                    i = 4;
                    break;
                case "invalid_parameters":
                case "missing_to":
                    break;
                case "messagetoobig":
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
        } else {
            i = 0;
        }
        this.errorCode = i;
    }
}
