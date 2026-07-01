package androidx.browser.trusted.sharing;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShareTarget$Params {
    public static final String KEY_FILES = "androidx.browser.trusted.sharing.KEY_FILES";
    public static final String KEY_TEXT = "androidx.browser.trusted.sharing.KEY_TEXT";
    public static final String KEY_TITLE = "androidx.browser.trusted.sharing.KEY_TITLE";

    @Nullable
    public final List<ShareTarget$FileFormField> files;

    @Nullable
    public final String text;

    @Nullable
    public final String title;

    public ShareTarget$Params(@Nullable String str, @Nullable String str2, @Nullable List<ShareTarget$FileFormField> list) {
        this.title = str;
        this.text = str2;
        this.files = list;
    }

    @Nullable
    public static ShareTarget$Params fromBundle(@Nullable Bundle bundle) {
        ArrayList arrayList = null;
        if (bundle == null) {
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_FILES);
        if (parcelableArrayList != null) {
            arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(ShareTarget$FileFormField.fromBundle((Bundle) it.next()));
            }
        }
        return new ShareTarget$Params(bundle.getString("androidx.browser.trusted.sharing.KEY_TITLE"), bundle.getString("androidx.browser.trusted.sharing.KEY_TEXT"), arrayList);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("androidx.browser.trusted.sharing.KEY_TITLE", this.title);
        bundle.putString("androidx.browser.trusted.sharing.KEY_TEXT", this.text);
        if (this.files != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<ShareTarget$FileFormField> it = this.files.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList(KEY_FILES, arrayList);
        }
        return bundle;
    }
}
