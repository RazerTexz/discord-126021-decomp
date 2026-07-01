package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.GuildView;

/* JADX INFO: renamed from: b.a.i.p2, reason: use source file name */
/* JADX INFO: compiled from: ViewMobileReportsChannelPreviewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewMobileReportsChannelPreviewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildView f179b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinkifiedTextView d;

    public ViewMobileReportsChannelPreviewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull GuildView guildView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = constraintLayout;
        this.f179b = guildView;
        this.c = textView;
        this.d = linkifiedTextView;
    }

    @NonNull
    public static ViewMobileReportsChannelPreviewBinding a(@NonNull View view) {
        int i = R.id.image;
        GuildView guildView = (GuildView) view.findViewById(R.id.image);
        if (guildView != null) {
            i = R.id.kicker;
            TextView textView = (TextView) view.findViewById(R.id.kicker);
            if (textView != null) {
                i = R.id.text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.text);
                if (linkifiedTextView != null) {
                    return new ViewMobileReportsChannelPreviewBinding((ConstraintLayout) view, guildView, textView, linkifiedTextView);
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
