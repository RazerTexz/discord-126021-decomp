package com.linecorp.apng.decoder;


/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ApngException$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ApngException$ErrorCode.values();
        int[] iArr = new int[9];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApngException$ErrorCode.ERR_STREAM_READ_FAIL.ordinal()] = 1;
        iArr[ApngException$ErrorCode.ERR_UNEXPECTED_EOF.ordinal()] = 2;
        iArr[ApngException$ErrorCode.ERR_INVALID_FILE_FORMAT.ordinal()] = 3;
        iArr[ApngException$ErrorCode.ERR_NOT_EXIST_IMAGE.ordinal()] = 4;
        iArr[ApngException$ErrorCode.ERR_FRAME_INDEX_OUT_OF_RANGE.ordinal()] = 5;
        iArr[ApngException$ErrorCode.ERR_OUT_OF_MEMORY.ordinal()] = 6;
        iArr[ApngException$ErrorCode.ERR_BITMAP_OPERATION.ordinal()] = 7;
        iArr[ApngException$ErrorCode.ERR_UNSUPPORTED_TYPE.ordinal()] = 8;
        iArr[ApngException$ErrorCode.ERR_WITH_CHILD_EXCEPTION.ordinal()] = 9;
    }
}
