package b.a.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: WidgetChannelSettingsDeleteBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class s4 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f199b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    public s4(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f199b = textView;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = textView2;
    }

    @NonNull
    public static s4 a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_channel_settings_delete, (ViewGroup) null, false);
        if (z2) {
            throw null;
        }
        int i = R$id.channel_settings_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(R$id.channel_settings_delete_body);
        if (textView != null) {
            i = R$id.channel_settings_delete_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.channel_settings_delete_cancel);
            if (materialButton != null) {
                i = R$id.channel_settings_delete_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.channel_settings_delete_confirm);
                if (materialButton2 != null) {
                    i = R$id.channel_settings_delete_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.channel_settings_delete_title);
                    if (textView2 != null) {
                        return new s4((LinearLayout) viewInflate, textView, materialButton, materialButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
