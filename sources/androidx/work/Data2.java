package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: androidx.work.DataKt, reason: use source file name */
/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Data2 {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        Intrinsics3.checkParameterIsNotNull(data, "$this$hasKeyWithValueOfType");
        Intrinsics3.checkParameterIsNotNull(str, "key");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(Tuples2<String, ? extends Object>... tuples2Arr) throws Throwable {
        Intrinsics3.checkParameterIsNotNull(tuples2Arr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Tuples2<String, ? extends Object> tuples2 : tuples2Arr) {
            builder.put(tuples2.getFirst(), tuples2.getSecond());
        }
        Data dataBuild = builder.build();
        Intrinsics3.checkExpressionValueIsNotNull(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
