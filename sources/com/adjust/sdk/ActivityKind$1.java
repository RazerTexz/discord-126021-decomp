package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ActivityKind$1 {
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
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.INFO.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.GDPR.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.DISABLE_THIRD_PARTY_SHARING.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.AD_REVENUE.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.SUBSCRIPTION.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
