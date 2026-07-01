package com.discord.utilities.error;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class Error$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$discord$utilities$error$Error$Type;

    static {
        Error$Type.values();
        int[] iArr = new int[18];
        $SwitchMap$com$discord$utilities$error$Error$Type = iArr;
        try {
            iArr[Error$Type.DISCORD_REQUEST_ERROR_UNKNOWN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.OTHER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.INTERMITTENT_CLOUD_FLARE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.FORBIDDEN_CLOUD_FLARE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.RATE_LIMITED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.FORBIDDEN_DISCORD.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.DISCORD_REQUEST_ERROR.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.DISCORD_BAD_REQUEST.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.NETWORK.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.SSL.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.TIMEOUT.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.REQUEST_TOO_LARGE.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.UNAUTHORIZED.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            $SwitchMap$com$discord$utilities$error$Error$Type[Error$Type.INTERNAL_SERVER_ERROR.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
