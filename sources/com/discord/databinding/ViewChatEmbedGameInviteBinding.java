package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewChatEmbedGameInviteBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2177b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final TextView i;

    public ViewChatEmbedGameInviteBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView3, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull TextView textView3) {
        this.a = view;
        this.f2177b = materialButton;
        this.c = textView;
        this.d = simpleDraweeView;
        this.e = simpleDraweeView2;
        this.f = simpleDraweeView3;
        this.g = textView2;
        this.h = recyclerView;
        this.i = textView3;
    }

    @NonNull
    public static ViewChatEmbedGameInviteBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R$layout.view_chat_embed_game_invite, viewGroup);
        int i = R$id.item_game_invite_action_btn;
        MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(R$id.item_game_invite_action_btn);
        if (materialButton != null) {
            i = R$id.item_game_invite_application_name_tv;
            TextView textView = (TextView) viewGroup.findViewById(R$id.item_game_invite_application_name_tv);
            if (textView != null) {
                i = R$id.item_game_invite_avatar_iv;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(R$id.item_game_invite_avatar_iv);
                if (simpleDraweeView != null) {
                    i = R$id.item_game_invite_avatar_status_iv;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewGroup.findViewById(R$id.item_game_invite_avatar_status_iv);
                    if (simpleDraweeView2 != null) {
                        i = R$id.item_game_invite_barrier;
                        Barrier barrier = (Barrier) viewGroup.findViewById(R$id.item_game_invite_barrier);
                        if (barrier != null) {
                            i = R$id.item_game_invite_cover_iv;
                            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewGroup.findViewById(R$id.item_game_invite_cover_iv);
                            if (simpleDraweeView3 != null) {
                                i = R$id.item_game_invite_header;
                                TextView textView2 = (TextView) viewGroup.findViewById(R$id.item_game_invite_header);
                                if (textView2 != null) {
                                    i = R$id.item_game_invite_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R$id.item_game_invite_recycler);
                                    if (recyclerView != null) {
                                        i = R$id.item_game_invite_subtext;
                                        TextView textView3 = (TextView) viewGroup.findViewById(R$id.item_game_invite_subtext);
                                        if (textView3 != null) {
                                            return new ViewChatEmbedGameInviteBinding(viewGroup, materialButton, textView, simpleDraweeView, simpleDraweeView2, barrier, simpleDraweeView3, textView2, recyclerView, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
