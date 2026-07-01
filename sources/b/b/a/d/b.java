package b.b.a.d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lytefast.flexinput.fragment.FilesFragment;

/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends d$a {
    public b(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // b.b.a.d.d$a
    public Fragment createFragment() {
        return new FilesFragment();
    }
}
