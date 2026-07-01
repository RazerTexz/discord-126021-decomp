package b.b.a.d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.AddContentPagerAdapter4;
import com.lytefast.flexinput.fragment.MediaFragment;

/* JADX INFO: renamed from: b.b.a.d.a, reason: use source file name */
/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AddContentPagerAdapter extends AddContentPagerAdapter4.a {
    public AddContentPagerAdapter(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public Fragment createFragment() {
        return new MediaFragment();
    }
}
