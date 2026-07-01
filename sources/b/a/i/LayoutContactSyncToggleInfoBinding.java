package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.o0, reason: use source file name */
/* JADX INFO: compiled from: LayoutContactSyncToggleInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutContactSyncToggleInfoBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f171b;

    @NonNull
    public final CheckedSetting c;

    public LayoutContactSyncToggleInfoBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting) {
        this.a = linearLayout;
        this.f171b = linkifiedTextView;
        this.c = checkedSetting;
    }

    @NonNull
    public static LayoutContactSyncToggleInfoBinding a(@NonNull View view) {
        int i = R.id.contact_sync_discovery_info_1;
        TextView textView = (TextView) view.findViewById(R.id.contact_sync_discovery_info_1);
        if (textView != null) {
            i = R.id.contact_sync_discovery_info_2;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.contact_sync_discovery_info_2);
            if (linkifiedTextView != null) {
                i = R.id.contact_sync_discovery_toggle;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.contact_sync_discovery_toggle);
                if (checkedSetting != null) {
                    return new LayoutContactSyncToggleInfoBinding((LinearLayout) view, textView, linkifiedTextView, checkedSetting);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
