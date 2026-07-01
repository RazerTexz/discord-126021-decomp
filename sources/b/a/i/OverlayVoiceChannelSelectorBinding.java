package b.a.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.b1, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceChannelSelectorBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayVoiceChannelSelectorBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f82b;

    @NonNull
    public final CardView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final RecyclerView f;

    public OverlayVoiceChannelSelectorBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView2) {
        this.a = cardView;
        this.f82b = imageView;
        this.c = cardView2;
        this.d = textView;
        this.e = textInputLayout;
        this.f = recyclerView;
    }

    @NonNull
    public static OverlayVoiceChannelSelectorBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.overlay_voice_channel_selector, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.close;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.close);
        if (imageView != null) {
            CardView cardView = (CardView) viewInflate;
            i = R.id.empty_results;
            TextView textView = (TextView) viewInflate.findViewById(R.id.empty_results);
            if (textView != null) {
                i = R.id.overlay_channel_search;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.overlay_channel_search);
                if (textInputLayout != null) {
                    i = R.id.results_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.results_rv);
                    if (recyclerView != null) {
                        i = R.id.test;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.test);
                        if (textView2 != null) {
                            return new OverlayVoiceChannelSelectorBinding(cardView, imageView, cardView, textView, textInputLayout, recyclerView, textView2);
                        }
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
