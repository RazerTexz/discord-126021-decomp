package androidx.loader.content;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ModernAsyncTask$4 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

    static {
        ModernAsyncTask$Status.values();
        int[] iArr = new int[3];
        $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = iArr;
        try {
            iArr[ModernAsyncTask$Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[ModernAsyncTask$Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
