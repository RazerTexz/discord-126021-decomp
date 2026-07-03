package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* JADX INFO: renamed from: b.a.i.o0 */
/* JADX INFO: compiled from: LayoutContactSyncToggleInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1017o0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1094a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f1095b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f1096c;

    public C1017o0(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting) {
        this.f1094a = linearLayout;
        this.f1095b = linkifiedTextView;
        this.f1096c = checkedSetting;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C1017o0 m202a(@NonNull View view) {
        int i = C5419R.id.contact_sync_discovery_info_1;
        TextView textView = (TextView) view.findViewById(C5419R.id.contact_sync_discovery_info_1);
        if (textView != null) {
            i = C5419R.id.contact_sync_discovery_info_2;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.contact_sync_discovery_info_2);
            if (linkifiedTextView != null) {
                i = C5419R.id.contact_sync_discovery_toggle;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.contact_sync_discovery_toggle);
                if (checkedSetting != null) {
                    return new C1017o0((LinearLayout) view, textView, linkifiedTextView, checkedSetting);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1094a;
    }
}
