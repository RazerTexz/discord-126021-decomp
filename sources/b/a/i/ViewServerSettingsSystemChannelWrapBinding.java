package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.l3, reason: use source file name */
/* JADX INFO: compiled from: ViewServerSettingsSystemChannelWrapBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsSystemChannelWrapBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f153b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final LinearLayout f;

    public ViewServerSettingsSystemChannelWrapBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f153b = textView;
        this.c = checkedSetting;
        this.d = checkedSetting2;
        this.e = checkedSetting3;
        this.f = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
