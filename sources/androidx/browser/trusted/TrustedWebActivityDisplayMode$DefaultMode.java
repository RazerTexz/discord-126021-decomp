package androidx.browser.trusted;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TrustedWebActivityDisplayMode$DefaultMode implements TrustedWebActivityDisplayMode {
    private static final int ID = 0;

    @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 0);
        return bundle;
    }
}
