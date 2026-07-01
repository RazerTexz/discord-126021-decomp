package androidx.core.content;

import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: androidx.core.content.ContentValuesKt, reason: use source file name */
/* JADX INFO: compiled from: ContentValues.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContentValues {
    public static final android.content.ContentValues contentValuesOf(Tuples2<String, ? extends Object>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        android.content.ContentValues contentValues = new android.content.ContentValues(tuples2Arr.length);
        int length = tuples2Arr.length;
        int i = 0;
        while (i < length) {
            Tuples2<String, ? extends Object> tuples2 = tuples2Arr[i];
            i++;
            String strComponent1 = tuples2.component1();
            Object objComponent2 = tuples2.component2();
            if (objComponent2 == null) {
                contentValues.putNull(strComponent1);
            } else if (objComponent2 instanceof String) {
                contentValues.put(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof Integer) {
                contentValues.put(strComponent1, (Integer) objComponent2);
            } else if (objComponent2 instanceof Long) {
                contentValues.put(strComponent1, (Long) objComponent2);
            } else if (objComponent2 instanceof Boolean) {
                contentValues.put(strComponent1, (Boolean) objComponent2);
            } else if (objComponent2 instanceof Float) {
                contentValues.put(strComponent1, (Float) objComponent2);
            } else if (objComponent2 instanceof Double) {
                contentValues.put(strComponent1, (Double) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                contentValues.put(strComponent1, (byte[]) objComponent2);
            } else if (objComponent2 instanceof Byte) {
                contentValues.put(strComponent1, (Byte) objComponent2);
            } else {
                if (!(objComponent2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + ((Object) objComponent2.getClass().getCanonicalName()) + " for key \"" + strComponent1 + '\"');
                }
                contentValues.put(strComponent1, (Short) objComponent2);
            }
        }
        return contentValues;
    }
}
