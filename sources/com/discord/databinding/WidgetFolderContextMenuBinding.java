package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFolderContextMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f16628a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f16629b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16630c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16631d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16632e;

    public WidgetFolderContextMenuBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16628a = cardView;
        this.f16629b = cardView2;
        this.f16630c = textView;
        this.f16631d = textView2;
        this.f16632e = textView3;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetFolderContextMenuBinding m8414a(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i = C5419R.id.folder_context_menu_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.folder_context_menu_header);
        if (textView != null) {
            i = C5419R.id.folder_context_menu_header_divider;
            View viewFindViewById = view.findViewById(C5419R.id.folder_context_menu_header_divider);
            if (viewFindViewById != null) {
                i = C5419R.id.folder_context_menu_mark_as_read;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.folder_context_menu_mark_as_read);
                if (textView2 != null) {
                    i = C5419R.id.folder_context_menu_settings;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.folder_context_menu_settings);
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
        return this.f16628a;
    }
}
