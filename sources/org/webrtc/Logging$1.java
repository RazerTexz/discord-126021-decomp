package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class Logging$1 {
    public static final /* synthetic */ int[] $SwitchMap$org$webrtc$Logging$Severity;

    static {
        Logging$Severity.values();
        int[] iArr = new int[5];
        $SwitchMap$org$webrtc$Logging$Severity = iArr;
        try {
            iArr[Logging$Severity.LS_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$org$webrtc$Logging$Severity[Logging$Severity.LS_WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$org$webrtc$Logging$Severity[Logging$Severity.LS_INFO.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
