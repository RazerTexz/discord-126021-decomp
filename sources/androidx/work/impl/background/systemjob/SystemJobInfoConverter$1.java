package androidx.work.impl.background.systemjob;

import androidx.work.NetworkType;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class SystemJobInfoConverter$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

    static {
        NetworkType.values();
        int[] iArr = new int[5];
        $SwitchMap$androidx$work$NetworkType = iArr;
        try {
            iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
