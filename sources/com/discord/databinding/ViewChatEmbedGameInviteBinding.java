package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewChatEmbedGameInviteBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15386a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15387b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15388c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15389d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f15390e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f15391f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15392g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final RecyclerView f15393h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f15394i;

    public ViewChatEmbedGameInviteBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView3, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull TextView textView3) {
        this.f15386a = view;
        this.f15387b = materialButton;
        this.f15388c = textView;
        this.f15389d = simpleDraweeView;
        this.f15390e = simpleDraweeView2;
        this.f15391f = simpleDraweeView3;
        this.f15392g = textView2;
        this.f15393h = recyclerView;
        this.f15394i = textView3;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewChatEmbedGameInviteBinding m8392a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_chat_embed_game_invite, viewGroup);
        int i = C5419R.id.item_game_invite_action_btn;
        MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(C5419R.id.item_game_invite_action_btn);
        if (materialButton != null) {
            i = C5419R.id.item_game_invite_application_name_tv;
            TextView textView = (TextView) viewGroup.findViewById(C5419R.id.item_game_invite_application_name_tv);
            if (textView != null) {
                i = C5419R.id.item_game_invite_avatar_iv;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.item_game_invite_avatar_iv);
                if (simpleDraweeView != null) {
                    i = C5419R.id.item_game_invite_avatar_status_iv;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.item_game_invite_avatar_status_iv);
                    if (simpleDraweeView2 != null) {
                        i = C5419R.id.item_game_invite_barrier;
                        Barrier barrier = (Barrier) viewGroup.findViewById(C5419R.id.item_game_invite_barrier);
                        if (barrier != null) {
                            i = C5419R.id.item_game_invite_cover_iv;
                            SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewGroup.findViewById(C5419R.id.item_game_invite_cover_iv);
                            if (simpleDraweeView3 != null) {
                                i = C5419R.id.item_game_invite_header;
                                TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.item_game_invite_header);
                                if (textView2 != null) {
                                    i = C5419R.id.item_game_invite_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(C5419R.id.item_game_invite_recycler);
                                    if (recyclerView != null) {
                                        i = C5419R.id.item_game_invite_subtext;
                                        TextView textView3 = (TextView) viewGroup.findViewById(C5419R.id.item_game_invite_subtext);
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
        return this.f15386a;
    }
}
