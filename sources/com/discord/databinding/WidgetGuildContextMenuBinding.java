package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildContextMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f16761a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f16762b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16763c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16764d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16765e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16766f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16767g;

    public WidgetGuildContextMenuBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f16761a = cardView;
        this.f16762b = cardView2;
        this.f16763c = textView;
        this.f16764d = textView2;
        this.f16765e = textView3;
        this.f16766f = textView4;
        this.f16767g = textView5;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetGuildContextMenuBinding m8416a(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i = C5419R.id.guild_context_menu_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_context_menu_header);
        if (textView != null) {
            i = C5419R.id.guild_context_menu_header_divider;
            View viewFindViewById = view.findViewById(C5419R.id.guild_context_menu_header_divider);
            if (viewFindViewById != null) {
                i = C5419R.id.guild_context_menu_leave_guild;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_context_menu_leave_guild);
                if (textView2 != null) {
                    i = C5419R.id.guild_context_menu_mark_as_read;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_context_menu_mark_as_read);
                    if (textView3 != null) {
                        i = C5419R.id.guild_context_menu_more_options;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_context_menu_more_options);
                        if (textView4 != null) {
                            i = C5419R.id.guild_context_menu_notifications;
                            TextView textView5 = (TextView) view.findViewById(C5419R.id.guild_context_menu_notifications);
                            if (textView5 != null) {
                                return new WidgetGuildContextMenuBinding((CardView) view, cardView, textView, viewFindViewById, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16761a;
    }
}
