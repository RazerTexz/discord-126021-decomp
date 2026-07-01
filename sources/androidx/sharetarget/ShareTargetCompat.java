package androidx.sharetarget;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class ShareTargetCompat {
    public final String[] mCategories;
    public final String mTargetClass;
    public final ShareTargetCompat$TargetData[] mTargetData;

    public ShareTargetCompat(ShareTargetCompat$TargetData[] shareTargetCompat$TargetDataArr, String str, String[] strArr) {
        this.mTargetData = shareTargetCompat$TargetDataArr;
        this.mTargetClass = str;
        this.mCategories = strArr;
    }
}
