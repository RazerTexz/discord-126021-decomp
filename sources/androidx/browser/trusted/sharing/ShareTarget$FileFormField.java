package androidx.browser.trusted.sharing;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ShareTarget$FileFormField {
    public static final String KEY_ACCEPTED_TYPES = "androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES";
    public static final String KEY_NAME = "androidx.browser.trusted.sharing.KEY_FILE_NAME";

    @NonNull
    public final List<String> acceptedTypes;

    @NonNull
    public final String name;

    public ShareTarget$FileFormField(@NonNull String str, @NonNull List<String> list) {
        this.name = str;
        this.acceptedTypes = Collections.unmodifiableList(list);
    }

    @Nullable
    public static ShareTarget$FileFormField fromBundle(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(KEY_NAME);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_ACCEPTED_TYPES);
        if (string == null || stringArrayList == null) {
            return null;
        }
        return new ShareTarget$FileFormField(string, stringArrayList);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, this.name);
        bundle.putStringArrayList(KEY_ACCEPTED_TYPES, new ArrayList<>(this.acceptedTypes));
        return bundle;
    }
}
