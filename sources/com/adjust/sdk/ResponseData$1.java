package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ResponseData$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$adjust$sdk$ActivityKind;

    static {
        ActivityKind.values();
        int[] iArr = new int[12];
        $SwitchMap$com$adjust$sdk$ActivityKind = iArr;
        try {
            iArr[ActivityKind.SESSION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
