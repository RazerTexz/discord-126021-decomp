package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.k3 */
/* JADX INFO: compiled from: ViewServerSettingsNotificationsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0992k3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1001a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f1002b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f1003c;

    public C0992k3(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.f1001a = linearLayout;
        this.f1002b = checkedSetting;
        this.f1003c = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1001a;
    }
}
