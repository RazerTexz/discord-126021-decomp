package androidx.room;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper$ValidationResult {

    @Nullable
    public final String expectedFoundMsg;
    public final boolean isValid;

    public RoomOpenHelper$ValidationResult(boolean z2, @Nullable String str) {
        this.isValid = z2;
        this.expectedFoundMsg = str;
    }
}
