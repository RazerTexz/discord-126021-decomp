package androidx.work.impl.model;

import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkInfo$State;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class WorkTypeConverters$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$work$BackoffPolicy;
    public static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;
    public static final /* synthetic */ int[] $SwitchMap$androidx$work$WorkInfo$State;

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
        BackoffPolicy.values();
        int[] iArr2 = new int[2];
        $SwitchMap$androidx$work$BackoffPolicy = iArr2;
        try {
            iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$androidx$work$BackoffPolicy[BackoffPolicy.LINEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        WorkInfo$State.values();
        int[] iArr3 = new int[6];
        $SwitchMap$androidx$work$WorkInfo$State = iArr3;
        try {
            iArr3[WorkInfo$State.ENQUEUED.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo$State.RUNNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo$State.SUCCEEDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo$State.FAILED.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo$State.BLOCKED.ordinal()] = 5;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo$State.CANCELLED.ordinal()] = 6;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
