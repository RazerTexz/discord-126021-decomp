package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        m.checkParameterIsNotNull(data, "$this$hasKeyWithValueOfType");
        m.checkParameterIsNotNull(str, "key");
        m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(Pair<String, ? extends Object>... pairArr) throws Throwable {
        m.checkParameterIsNotNull(pairArr, "pairs");
        Data$Builder data$Builder = new Data$Builder();
        for (Pair<String, ? extends Object> pair : pairArr) {
            data$Builder.put(pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = data$Builder.build();
        m.checkExpressionValueIsNotNull(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
