package com.linecorp.apng.decoder;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApngException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ApngException extends Exception {
    private final ApngException$ErrorCode errorCode;

    public /* synthetic */ ApngException(ApngException$ErrorCode apngException$ErrorCode, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(apngException$ErrorCode, (i & 2) != 0 ? null : th);
    }

    public final ApngException$ErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        switch (this.errorCode) {
            case ERR_STREAM_READ_FAIL:
                return "Can't read the stream.";
            case ERR_UNEXPECTED_EOF:
                return "Unexpected end of file.";
            case ERR_INVALID_FILE_FORMAT:
                return "Invalid file format.";
            case ERR_NOT_EXIST_IMAGE:
                return "Not exist native image.";
            case ERR_FRAME_INDEX_OUT_OF_RANGE:
                return "Frame index is out of range.";
            case ERR_OUT_OF_MEMORY:
                return "Out of memory";
            case ERR_BITMAP_OPERATION:
                return "Error in the native bitmap operation.";
            case ERR_UNSUPPORTED_TYPE:
                return "Unsupported image type.";
            case ERR_WITH_CHILD_EXCEPTION:
                StringBuilder sbU = a.U("Failed with sub exception : ");
                Throwable cause = getCause();
                sbU.append(cause != null ? cause.getMessage() : null);
                return sbU.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngException(ApngException$ErrorCode apngException$ErrorCode, Throwable th) {
        super(th);
        m.checkNotNullParameter(apngException$ErrorCode, "errorCode");
        this.errorCode = apngException$ErrorCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApngException(Throwable th) {
        this(ApngException$ErrorCode.ERR_WITH_CHILD_EXCEPTION, th);
        m.checkNotNullParameter(th, "throwable");
    }
}
