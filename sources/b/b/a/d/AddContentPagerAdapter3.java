package b.b.a.d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.AddContentPagerAdapter4;
import com.lytefast.flexinput.fragment.CameraFragment;

/* JADX INFO: renamed from: b.b.a.d.c, reason: use source file name */
/* JADX INFO: compiled from: AddContentPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AddContentPagerAdapter3 extends AddContentPagerAdapter4.a {
    public AddContentPagerAdapter3(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public Fragment createFragment() {
        return new CameraFragment();
    }
}
