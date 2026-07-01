package androidx.core.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInput$Builder {
    private CharSequence[] mChoices;
    private CharSequence mLabel;
    private final String mResultKey;
    private final Set<String> mAllowedDataTypes = new HashSet();
    private final Bundle mExtras = new Bundle();
    private boolean mAllowFreeFormTextInput = true;
    private int mEditChoicesBeforeSending = 0;

    public RemoteInput$Builder(@NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Result key can't be null");
        }
        this.mResultKey = str;
    }

    @NonNull
    public RemoteInput$Builder addExtras(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        return this;
    }

    @NonNull
    public RemoteInput build() {
        return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @NonNull
    public RemoteInput$Builder setAllowDataType(@NonNull String str, boolean z2) {
        if (z2) {
            this.mAllowedDataTypes.add(str);
        } else {
            this.mAllowedDataTypes.remove(str);
        }
        return this;
    }

    @NonNull
    public RemoteInput$Builder setAllowFreeFormInput(boolean z2) {
        this.mAllowFreeFormTextInput = z2;
        return this;
    }

    @NonNull
    public RemoteInput$Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
        this.mChoices = charSequenceArr;
        return this;
    }

    @NonNull
    public RemoteInput$Builder setEditChoicesBeforeSending(int i) {
        this.mEditChoicesBeforeSending = i;
        return this;
    }

    @NonNull
    public RemoteInput$Builder setLabel(@Nullable CharSequence charSequence) {
        this.mLabel = charSequence;
        return this;
    }
}
