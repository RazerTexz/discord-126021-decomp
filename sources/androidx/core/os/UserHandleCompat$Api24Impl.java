package androidx.core.os;

import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class UserHandleCompat$Api24Impl {
    private UserHandleCompat$Api24Impl() {
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i) {
        return UserHandle.getUserHandleForUid(i);
    }
}
