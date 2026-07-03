package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.GuildView;

/* JADX INFO: renamed from: b.a.i.p2 */
/* JADX INFO: compiled from: ViewMobileReportsChannelPreviewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1026p2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1130a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildView f1131b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1132c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f1133d;

    public C1026p2(@NonNull ConstraintLayout constraintLayout, @NonNull GuildView guildView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f1130a = constraintLayout;
        this.f1131b = guildView;
        this.f1132c = textView;
        this.f1133d = linkifiedTextView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C1026p2 m203a(@NonNull View view) {
        int i = C5419R.id.image;
        GuildView guildView = (GuildView) view.findViewById(C5419R.id.image);
        if (guildView != null) {
            i = C5419R.id.kicker;
            TextView textView = (TextView) view.findViewById(C5419R.id.kicker);
            if (textView != null) {
                i = C5419R.id.text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.text);
                if (linkifiedTextView != null) {
                    return new C1026p2((ConstraintLayout) view, guildView, textView, linkifiedTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1130a;
    }
}
