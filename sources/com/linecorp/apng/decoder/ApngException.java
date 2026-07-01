package com.linecorp.apng.decoder;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApngException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ApngException extends Exception {
    private final ErrorCode errorCode;

    /* JADX INFO: compiled from: ApngException.kt */
    public enum ErrorCode {
        ERR_STREAM_READ_FAIL(-100),
        ERR_UNEXPECTED_EOF(-101),
        ERR_INVALID_FILE_FORMAT(-102),
        ERR_NOT_EXIST_IMAGE(-103),
        ERR_FRAME_INDEX_OUT_OF_RANGE(-104),
        ERR_OUT_OF_MEMORY(-105),
        ERR_BITMAP_OPERATION(-106),
        ERR_UNSUPPORTED_TYPE(-107),
        ERR_WITH_CHILD_EXCEPTION(-200);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int errorCode;

        /* JADX INFO: compiled from: ApngException.kt */
        public static final class Companion {
            public Companion() {
            }

            public final ErrorCode fromErrorCode$apng_drawable_release(int errorCode) {
                ErrorCode[] errorCodeArrValues = ErrorCode.values();
                for (int i = 0; i < 9; i++) {
                    ErrorCode errorCode2 = errorCodeArrValues[i];
                    if (errorCode2.getErrorCode() == errorCode) {
                        return errorCode2;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        ErrorCode(int i) {
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ErrorCode.values();
            int[] iArr = new int[9];
            $EnumSwitchMapping$0 = iArr;
            iArr[ErrorCode.ERR_STREAM_READ_FAIL.ordinal()] = 1;
            iArr[ErrorCode.ERR_UNEXPECTED_EOF.ordinal()] = 2;
            iArr[ErrorCode.ERR_INVALID_FILE_FORMAT.ordinal()] = 3;
            iArr[ErrorCode.ERR_NOT_EXIST_IMAGE.ordinal()] = 4;
            iArr[ErrorCode.ERR_FRAME_INDEX_OUT_OF_RANGE.ordinal()] = 5;
            iArr[ErrorCode.ERR_OUT_OF_MEMORY.ordinal()] = 6;
            iArr[ErrorCode.ERR_BITMAP_OPERATION.ordinal()] = 7;
            iArr[ErrorCode.ERR_UNSUPPORTED_TYPE.ordinal()] = 8;
            iArr[ErrorCode.ERR_WITH_CHILD_EXCEPTION.ordinal()] = 9;
        }
    }

    public /* synthetic */ ApngException(ErrorCode errorCode, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorCode, (i & 2) != 0 ? null : th);
    }

    public final ErrorCode getErrorCode() {
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
                StringBuilder sbU = outline.U("Failed with sub exception : ");
                Throwable cause = getCause();
                sbU.append(cause != null ? cause.getMessage() : null);
                return sbU.toString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngException(ErrorCode errorCode, Throwable th) {
        super(th);
        Intrinsics3.checkNotNullParameter(errorCode, "errorCode");
        this.errorCode = errorCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApngException(Throwable th) {
        this(ErrorCode.ERR_WITH_CHILD_EXCEPTION, th);
        Intrinsics3.checkNotNullParameter(th, "throwable");
    }
}
