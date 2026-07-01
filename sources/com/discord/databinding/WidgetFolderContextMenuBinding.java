package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFolderContextMenuBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f2386b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WidgetFolderContextMenuBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = cardView;
        this.f2386b = cardView2;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    @NonNull
    public static WidgetFolderContextMenuBinding a(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i = R$id.folder_context_menu_header;
        TextView textView = (TextView) view.findViewById(R$id.folder_context_menu_header);
        if (textView != null) {
            i = R$id.folder_context_menu_header_divider;
            View viewFindViewById = view.findViewById(R$id.folder_context_menu_header_divider);
            if (viewFindViewById != null) {
                i = R$id.folder_context_menu_mark_as_read;
                TextView textView2 = (TextView) view.findViewById(R$id.folder_context_menu_mark_as_read);
                if (textView2 != null) {
                    i = R$id.folder_context_menu_settings;
                    TextView textView3 = (TextView) view.findViewById(R$id.folder_context_menu_settings);
                    if (textView3 != null) {
                        return new WidgetFolderContextMenuBinding((CardView) view, cardView, textView, viewFindViewById, textView2, textView3);
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
