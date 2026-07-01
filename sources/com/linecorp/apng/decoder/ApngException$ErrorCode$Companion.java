package com.linecorp.apng.decoder;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApngException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ApngException$ErrorCode$Companion {
    public ApngException$ErrorCode$Companion() {
    }

    public final ApngException$ErrorCode fromErrorCode$apng_drawable_release(int errorCode) {
        ApngException$ErrorCode[] apngException$ErrorCodeArrValues = ApngException$ErrorCode.values();
        for (int i = 0; i < 9; i++) {
            ApngException$ErrorCode apngException$ErrorCode = apngException$ErrorCodeArrValues[i];
            if (apngException$ErrorCode.getErrorCode() == errorCode) {
                return apngException$ErrorCode;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public ApngException$ErrorCode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
