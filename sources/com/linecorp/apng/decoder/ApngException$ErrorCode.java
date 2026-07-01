package com.linecorp.apng.decoder;


/* JADX INFO: compiled from: ApngException.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum ApngException$ErrorCode {
    ERR_STREAM_READ_FAIL(-100),
    ERR_UNEXPECTED_EOF(-101),
    ERR_INVALID_FILE_FORMAT(-102),
    ERR_NOT_EXIST_IMAGE(-103),
    ERR_FRAME_INDEX_OUT_OF_RANGE(-104),
    ERR_OUT_OF_MEMORY(-105),
    ERR_BITMAP_OPERATION(-106),
    ERR_UNSUPPORTED_TYPE(-107),
    ERR_WITH_CHILD_EXCEPTION(-200);

    public static final ApngException$ErrorCode$Companion Companion = new ApngException$ErrorCode$Companion(null);
    private final int errorCode;

    ApngException$ErrorCode(int i) {
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
