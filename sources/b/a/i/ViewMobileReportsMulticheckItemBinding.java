package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.r2, reason: use source file name */
/* JADX INFO: compiled from: ViewMobileReportsMulticheckItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewMobileReportsMulticheckItemBinding implements ViewBinding {

    @NonNull
    public final CheckedSetting a;

    public ViewMobileReportsMulticheckItemBinding(@NonNull CheckedSetting checkedSetting) {
        this.a = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
