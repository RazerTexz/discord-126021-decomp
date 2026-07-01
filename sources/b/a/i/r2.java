package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: compiled from: ViewMobileReportsMulticheckItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class r2 implements ViewBinding {

    @NonNull
    public final CheckedSetting a;

    public r2(@NonNull CheckedSetting checkedSetting) {
        this.a = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
