package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.l3 */
/* JADX INFO: compiled from: ViewServerSettingsSystemChannelWrapBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0999l3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1025a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1026b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f1027c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f1028d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f1029e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f1030f;

    public C0999l3(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout2) {
        this.f1025a = linearLayout;
        this.f1026b = textView;
        this.f1027c = checkedSetting;
        this.f1028d = checkedSetting2;
        this.f1029e = checkedSetting3;
        this.f1030f = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1025a;
    }
}
