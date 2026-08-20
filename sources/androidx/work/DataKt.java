package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Pair;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        C12238m.checkParameterIsNotNull(data, "$this$hasKeyWithValueOfType");
        C12238m.checkParameterIsNotNull(str, "key");
        C12238m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(Pair<String, ? extends Object>... pairArr) throws Throwable {
        C12238m.checkParameterIsNotNull(pairArr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Pair<String, ? extends Object> pair : pairArr) {
            builder.put(pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder.build();
        C12238m.checkExpressionValueIsNotNull(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
