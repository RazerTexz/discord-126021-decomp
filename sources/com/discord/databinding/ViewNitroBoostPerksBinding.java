package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewNitroBoostPerksBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f15520a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15521b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f15522c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RelativeLayout f15523d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15524e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15525f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CardView f15526g;

    public ViewNitroBoostPerksBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull TextView textView3, @NonNull CardView cardView2) {
        this.f15520a = cardView;
        this.f15521b = textView;
        this.f15522c = recyclerView;
        this.f15523d = relativeLayout;
        this.f15524e = textView2;
        this.f15525f = textView3;
        this.f15526g = cardView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewNitroBoostPerksBinding m8400a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.view_nitro_boost_perks, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.container;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.container);
        if (linearLayout != null) {
            i = C5419R.id.perks_level_contents_header;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.perks_level_contents_header);
            if (textView != null) {
                i = C5419R.id.perks_level_contents_recycler;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.perks_level_contents_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.perks_level_header;
                    RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(C5419R.id.perks_level_header);
                    if (relativeLayout != null) {
                        i = C5419R.id.perks_level_header_boosts;
                        TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.perks_level_header_boosts);
                        if (textView2 != null) {
                            i = C5419R.id.perks_level_header_boosts_container;
                            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C5419R.id.perks_level_header_boosts_container);
                            if (frameLayout != null) {
                                i = C5419R.id.perks_level_header_text;
                                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.perks_level_header_text);
                                if (textView3 != null) {
                                    i = C5419R.id.perks_level_header_unlocked;
                                    CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.perks_level_header_unlocked);
                                    if (cardView != null) {
                                        return new ViewNitroBoostPerksBinding((CardView) viewInflate, linearLayout, textView, recyclerView, relativeLayout, textView2, frameLayout, textView3, cardView);
                                    }
                                }
                            }
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
        return this.f15520a;
    }
}
