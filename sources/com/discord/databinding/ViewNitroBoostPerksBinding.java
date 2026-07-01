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
import com.discord.R$id;
import com.discord.R$layout;

/* JADX INFO: loaded from: classes.dex */
public final class ViewNitroBoostPerksBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2204b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final CardView g;

    public ViewNitroBoostPerksBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull TextView textView3, @NonNull CardView cardView2) {
        this.a = cardView;
        this.f2204b = textView;
        this.c = recyclerView;
        this.d = relativeLayout;
        this.e = textView2;
        this.f = textView3;
        this.g = cardView2;
    }

    @NonNull
    public static ViewNitroBoostPerksBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.view_nitro_boost_perks, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = 2131362883;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(2131362883);
        if (linearLayout != null) {
            i = R$id.perks_level_contents_header;
            TextView textView = (TextView) viewInflate.findViewById(R$id.perks_level_contents_header);
            if (textView != null) {
                i = R$id.perks_level_contents_recycler;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.perks_level_contents_recycler);
                if (recyclerView != null) {
                    i = R$id.perks_level_header;
                    RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R$id.perks_level_header);
                    if (relativeLayout != null) {
                        i = R$id.perks_level_header_boosts;
                        TextView textView2 = (TextView) viewInflate.findViewById(R$id.perks_level_header_boosts);
                        if (textView2 != null) {
                            i = R$id.perks_level_header_boosts_container;
                            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.perks_level_header_boosts_container);
                            if (frameLayout != null) {
                                i = R$id.perks_level_header_text;
                                TextView textView3 = (TextView) viewInflate.findViewById(R$id.perks_level_header_text);
                                if (textView3 != null) {
                                    i = R$id.perks_level_header_unlocked;
                                    CardView cardView = (CardView) viewInflate.findViewById(R$id.perks_level_header_unlocked);
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
        return this.a;
    }
}
