package androidx.sharetarget;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ShareTargetCompat {
    public final String[] mCategories;
    public final String mTargetClass;
    public final TargetData[] mTargetData;

    public static class TargetData {
        public final String mHost;
        public final String mMimeType;
        public final String mPath;
        public final String mPathPattern;
        public final String mPathPrefix;
        public final String mPort;
        public final String mScheme;

        public TargetData(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.mScheme = str;
            this.mHost = str2;
            this.mPort = str3;
            this.mPath = str4;
            this.mPathPattern = str5;
            this.mPathPrefix = str6;
            this.mMimeType = str7;
        }
    }

    public ShareTargetCompat(TargetData[] targetDataArr, String str, String[] strArr) {
        this.mTargetData = targetDataArr;
        this.mTargetClass = str;
        this.mCategories = strArr;
    }
}
