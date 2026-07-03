package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e) {
            Logger.get().error(TAG, C1643a.m883w("Trouble instantiating + ", str), e);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
