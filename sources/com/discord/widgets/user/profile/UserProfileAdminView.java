package com.discord.widgets.user.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.UserProfileAdminViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileAdminView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileAdminView extends LinearLayout {
    private final UserProfileAdminViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileAdminView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_profile_admin_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.user_profile_admin_ban;
        TextView textView = (TextView) viewInflate.findViewById(R$id.user_profile_admin_ban);
        if (textView != null) {
            i = R$id.user_profile_admin_disable_communication;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_disable_communication);
            if (textView2 != null) {
                i = R$id.user_profile_admin_edit_member;
                TextView textView3 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_edit_member);
                if (textView3 != null) {
                    i = R$id.user_profile_admin_kick;
                    TextView textView4 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_kick);
                    if (textView4 != null) {
                        i = R$id.user_profile_admin_server_deafen;
                        TextView textView5 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_server_deafen);
                        if (textView5 != null) {
                            i = R$id.user_profile_admin_server_disconnect;
                            TextView textView6 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_server_disconnect);
                            if (textView6 != null) {
                                i = R$id.user_profile_admin_server_move;
                                TextView textView7 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_server_move);
                                if (textView7 != null) {
                                    i = R$id.user_profile_admin_server_mute;
                                    TextView textView8 = (TextView) viewInflate.findViewById(R$id.user_profile_admin_server_mute);
                                    if (textView8 != null) {
                                        UserProfileAdminViewBinding userProfileAdminViewBinding = new UserProfileAdminViewBinding((LinearLayout) viewInflate, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                        m.checkNotNullExpressionValue(userProfileAdminViewBinding, "UserProfileAdminViewBind…rom(context), this, true)");
                                        this.binding = userProfileAdminViewBinding;
                                        return;
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

    public final void setOnBan(Function0<Unit> onBan) {
        m.checkNotNullParameter(onBan, "onBan");
        this.binding.f2163b.setOnClickListener(new UserProfileAdminView$setOnBan$1(onBan));
    }

    public final void setOnDisableCommunication(Function0<Unit> onDisableCommunication) {
        m.checkNotNullParameter(onDisableCommunication, "onDisableCommunication");
        this.binding.c.setOnClickListener(new UserProfileAdminView$setOnDisableCommunication$1(onDisableCommunication));
    }

    public final void setOnDisconnect(Function0<Unit> onDisconnect) {
        m.checkNotNullParameter(onDisconnect, "onDisconnect");
        this.binding.g.setOnClickListener(new UserProfileAdminView$setOnDisconnect$1(onDisconnect));
    }

    public final void setOnEditMember(Function0<Unit> onEditMember) {
        m.checkNotNullParameter(onEditMember, "onEditMember");
        this.binding.d.setOnClickListener(new UserProfileAdminView$setOnEditMember$1(onEditMember));
    }

    public final void setOnKick(Function0<Unit> onKick) {
        m.checkNotNullParameter(onKick, "onKick");
        this.binding.e.setOnClickListener(new UserProfileAdminView$setOnKick$1(onKick));
    }

    public final void setOnServerDeafen(Function0<Unit> onServerDeafen) {
        m.checkNotNullParameter(onServerDeafen, "onServerDeafen");
        this.binding.f.setOnClickListener(new UserProfileAdminView$setOnServerDeafen$1(onServerDeafen));
    }

    public final void setOnServerMove(Function0<Unit> onServerMove) {
        m.checkNotNullParameter(onServerMove, "onServerMove");
        this.binding.h.setOnClickListener(new UserProfileAdminView$setOnServerMove$1(onServerMove));
    }

    public final void setOnServerMute(Function0<Unit> onServerMute) {
        m.checkNotNullParameter(onServerMute, "onServerMute");
        this.binding.i.setOnClickListener(new UserProfileAdminView$setOnServerMute$1(onServerMute));
    }

    public final void updateView(UserProfileAdminView$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.userProfileAdminEditMember");
        textView.setVisibility(viewState.getShowEditMemberButton() ? 0 : 8);
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.userProfileAdminKick");
        textView2.setVisibility(viewState.getShowKickButton() ? 0 : 8);
        TextView textView3 = this.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.userProfileAdminDisableCommunication");
        textView3.setVisibility(viewState.getShowDisableCommunicationButton() ? 0 : 8);
        this.binding.e.setText(viewState.isMultiUserDM() ? 2131894748 : 2131892495);
        TextView textView4 = this.binding.f2163b;
        m.checkNotNullExpressionValue(textView4, "binding.userProfileAdminBan");
        textView4.setVisibility(viewState.getShowBanButton() ? 0 : 8);
        boolean zIsCommunicationDisabled = viewState.isCommunicationDisabled();
        int i = zIsCommunicationDisabled ? 2131894755 : 2131896401;
        Drawable drawable = zIsCommunicationDisabled ? ContextCompat.getDrawable(getContext(), 2131231748) : ContextCompat.getDrawable(getContext(), 2131231719);
        this.binding.c.setText(i);
        TextView textView5 = this.binding.c;
        m.checkNotNullExpressionValue(textView5, "binding.userProfileAdminDisableCommunication");
        DrawableCompat.setCompoundDrawablesCompat$default(textView5, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView6 = this.binding.i;
        m.checkNotNullExpressionValue(textView6, "binding.userProfileAdminServerMute");
        textView6.setVisibility(viewState.getShowServerMuteButton() ? 0 : 8);
        boolean zIsServerMuted = viewState.isServerMuted();
        boolean zIsMe = viewState.isMe();
        int themedDrawableRes$default = zIsServerMuted ? DrawableCompat.getThemedDrawableRes$default(this, 2130969512, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, 2130969510, 0, 2, (Object) null);
        int i2 = zIsServerMuted ? 2131895595 : 2131895584;
        TextView textView7 = this.binding.i;
        m.checkNotNullExpressionValue(textView7, "binding.userProfileAdminServerMute");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView7, themedDrawableRes$default, 0, 0, 0, 14, null);
        this.binding.i.setText(i2);
        TextView textView8 = this.binding.f;
        m.checkNotNullExpressionValue(textView8, "binding.userProfileAdminServerDeafen");
        textView8.setVisibility(viewState.getShowServerDeafenButton() ? 0 : 8);
        boolean zIsServerDeafened = viewState.isServerDeafened();
        int themedDrawableRes$default2 = zIsServerDeafened ? DrawableCompat.getThemedDrawableRes$default(this, 2130969502, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, 2130969502, 0, 2, (Object) null);
        int i3 = zIsServerDeafened ? 2131895594 : 2131895436;
        int i4 = zIsMe ? 2131888498 : 2131888497;
        TextView textView9 = this.binding.f;
        m.checkNotNullExpressionValue(textView9, "binding.userProfileAdminServerDeafen");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView9, themedDrawableRes$default2, 0, 0, 0, 14, null);
        this.binding.f.setText(i3);
        TextView textView10 = this.binding.h;
        m.checkNotNullExpressionValue(textView10, "binding.userProfileAdminServerMove");
        textView10.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
        this.binding.g.setText(i4);
        TextView textView11 = this.binding.g;
        m.checkNotNullExpressionValue(textView11, "binding.userProfileAdminServerDisconnect");
        textView11.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
    }
}
