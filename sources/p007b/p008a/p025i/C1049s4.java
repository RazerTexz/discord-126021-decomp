package p007b.p008a.p025i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.s4 */
/* JADX INFO: compiled from: WidgetChannelSettingsDeleteBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1049s4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1214a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1215b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1216c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1217d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1218e;

    public C1049s4(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f1214a = linearLayout;
        this.f1215b = textView;
        this.f1216c = materialButton;
        this.f1217d = materialButton2;
        this.f1218e = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C1049s4 m206a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_channel_settings_delete, (ViewGroup) null, false);
        if (z2) {
            throw null;
        }
        int i = C5419R.id.channel_settings_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_delete_body);
        if (textView != null) {
            i = C5419R.id.channel_settings_delete_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_delete_cancel);
            if (materialButton != null) {
                i = C5419R.id.channel_settings_delete_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_delete_confirm);
                if (materialButton2 != null) {
                    i = C5419R.id.channel_settings_delete_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_delete_title);
                    if (textView2 != null) {
                        return new C1049s4((LinearLayout) viewInflate, textView, materialButton, materialButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1214a;
    }
}
