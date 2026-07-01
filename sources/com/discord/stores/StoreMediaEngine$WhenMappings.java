package com.discord.stores;

import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$Type;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        KrispOveruseDetector$Status.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[KrispOveruseDetector$Status.FAILED.ordinal()] = 1;
        iArr[KrispOveruseDetector$Status.CPU_OVERUSE.ordinal()] = 2;
        iArr[KrispOveruseDetector$Status.VAD_CPU_OVERUSE.ordinal()] = 3;
        MediaEngineConnection$Type.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[MediaEngineConnection$Type.DEFAULT.ordinal()] = 1;
        iArr2[MediaEngineConnection$Type.STREAM.ordinal()] = 2;
    }
}
