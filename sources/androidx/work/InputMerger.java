package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e) {
            Logger.get().error(TAG, outline.w("Trouble instantiating + ", str), e);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
