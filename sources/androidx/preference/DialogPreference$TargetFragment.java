package androidx.preference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface DialogPreference$TargetFragment {
    @Nullable
    <T extends Preference> T findPreference(@NonNull CharSequence charSequence);
}
