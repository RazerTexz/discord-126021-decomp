package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildWelcomeBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2324b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final ChatActionItem e;

    @NonNull
    public final ChatActionItem f;

    public WidgetChatListAdapterItemGuildWelcomeBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull ChatActionItem chatActionItem, @NonNull ChatActionItem chatActionItem2) {
        this.a = linearLayout;
        this.f2324b = textView;
        this.c = linkifiedTextView;
        this.d = linkifiedTextView2;
        this.e = chatActionItem;
        this.f = chatActionItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
