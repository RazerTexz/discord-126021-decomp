package androidx.room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker$ObserverWrapper {
    public final InvalidationTracker$Observer mObserver;
    private final Set<String> mSingleTableSet;
    public final int[] mTableIds;
    private final String[] mTableNames;

    public InvalidationTracker$ObserverWrapper(InvalidationTracker$Observer invalidationTracker$Observer, int[] iArr, String[] strArr) {
        this.mObserver = invalidationTracker$Observer;
        this.mTableIds = iArr;
        this.mTableNames = strArr;
        if (iArr.length != 1) {
            this.mSingleTableSet = null;
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(strArr[0]);
        this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
    }

    public void notifyByTableInvalidStatus(Set<Integer> set) {
        int length = this.mTableIds.length;
        Set<String> hashSet = null;
        for (int i = 0; i < length; i++) {
            if (set.contains(Integer.valueOf(this.mTableIds[i]))) {
                if (length == 1) {
                    hashSet = this.mSingleTableSet;
                } else {
                    if (hashSet == null) {
                        hashSet = new HashSet<>(length);
                    }
                    hashSet.add(this.mTableNames[i]);
                }
            }
        }
        if (hashSet != null) {
            this.mObserver.onInvalidated(hashSet);
        }
    }

    public void notifyByTableNames(String[] strArr) {
        Set<String> set = null;
        if (this.mTableNames.length == 1) {
            for (String str : strArr) {
                if (str.equalsIgnoreCase(this.mTableNames[0])) {
                    set = this.mSingleTableSet;
                    break;
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (String str2 : strArr) {
                for (String str3 : this.mTableNames) {
                    if (str3.equalsIgnoreCase(str2)) {
                        hashSet.add(str3);
                        break;
                    }
                }
            }
            if (hashSet.size() > 0) {
                set = hashSet;
            }
        }
        if (set != null) {
            this.mObserver.onInvalidated(set);
        }
    }
}
