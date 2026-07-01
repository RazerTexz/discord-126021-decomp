package b.b.a.d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lytefast.flexinput.fragment.CameraFragment;

/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d$a {
    public c(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // b.b.a.d.d$a
    public Fragment createFragment() {
        return new CameraFragment();
    }
}
