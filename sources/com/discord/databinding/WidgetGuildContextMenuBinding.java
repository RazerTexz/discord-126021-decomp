package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildContextMenuBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f2411b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetGuildContextMenuBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = cardView;
        this.f2411b = cardView2;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    @NonNull
    public static WidgetGuildContextMenuBinding a(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i = R$id.guild_context_menu_header;
        TextView textView = (TextView) view.findViewById(R$id.guild_context_menu_header);
        if (textView != null) {
            i = R$id.guild_context_menu_header_divider;
            View viewFindViewById = view.findViewById(R$id.guild_context_menu_header_divider);
            if (viewFindViewById != null) {
                i = R$id.guild_context_menu_leave_guild;
                TextView textView2 = (TextView) view.findViewById(R$id.guild_context_menu_leave_guild);
                if (textView2 != null) {
                    i = R$id.guild_context_menu_mark_as_read;
                    TextView textView3 = (TextView) view.findViewById(R$id.guild_context_menu_mark_as_read);
                    if (textView3 != null) {
                        i = R$id.guild_context_menu_more_options;
                        TextView textView4 = (TextView) view.findViewById(R$id.guild_context_menu_more_options);
                        if (textView4 != null) {
                            i = R$id.guild_context_menu_notifications;
                            TextView textView5 = (TextView) view.findViewById(R$id.guild_context_menu_notifications);
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
        return this.a;
    }
}
