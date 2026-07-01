package androidx.room;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class InvalidationTracker$Observer {
    public final String[] mTables;

    public InvalidationTracker$Observer(@NonNull String str, String... strArr) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        this.mTables = strArr2;
        strArr2[strArr.length] = str;
    }

    public boolean isRemote() {
        return false;
    }

    public abstract void onInvalidated(@NonNull Set<String> set);

    public InvalidationTracker$Observer(@NonNull String[] strArr) {
        this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
    }
}
