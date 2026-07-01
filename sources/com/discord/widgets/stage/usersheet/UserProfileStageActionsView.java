package com.discord.widgets.stage.usersheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$drawable;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.UserProfileStageActionsViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileStageActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserProfileStageActionsView extends LinearLayout {
    private final UserProfileStageActionsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileStageActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_profile_stage_actions_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.user_profile_stage_invite_to_speak;
        TextView textView = (TextView) viewInflate.findViewById(R$id.user_profile_stage_invite_to_speak);
        if (textView != null) {
            i = R$id.user_profile_stage_move_to_audience;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.user_profile_stage_move_to_audience);
            if (textView2 != null) {
                UserProfileStageActionsViewBinding userProfileStageActionsViewBinding = new UserProfileStageActionsViewBinding((LinearLayout) viewInflate, textView, textView2);
                m.checkNotNullExpressionValue(userProfileStageActionsViewBinding, "UserProfileStageActionsV…rom(context), this, true)");
                this.binding = userProfileStageActionsViewBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnInviteToSpeak(Function0<Unit> onInviteToSpeak) {
        m.checkNotNullParameter(onInviteToSpeak, "onInviteToSpeak");
        this.binding.f2167b.setOnClickListener(new UserProfileStageActionsView$setOnInviteToSpeak$1(onInviteToSpeak));
    }

    public final void setOnMoveToAudience(Function0<Unit> onMoveToAudience) {
        m.checkNotNullParameter(onMoveToAudience, "onMoveToAudience");
        this.binding.c.setOnClickListener(new UserProfileStageActionsView$setOnMoveToAudience$1(onMoveToAudience));
    }

    public final void updateView(UserProfileStageActionsView$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (!viewState.getUserInSameVoiceChannel() || !viewState.getCanMuteMembers()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        TextView textView = this.binding.f2167b;
        textView.setVisibility(viewState.getUserRequestToSpeakState().getCanBeInvitedToSpeak() ? 0 : 8);
        textView.setEnabled(!viewState.isInvitingToSpeak());
        textView.setText(viewState.isMe() ? 2131893066 : 2131895802);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, viewState.isMe() ? 2131232152 : R$drawable.ic_stage_invite_speak, 0, 0, 0, 14, (Object) null);
        TextView textView2 = this.binding.c;
        StageRoles stageRolesM54getUserStageRoletwRsX0 = viewState.m54getUserStageRoletwRsX0();
        textView2.setVisibility(stageRolesM54getUserStageRoletwRsX0 != null && StageRoles.m33isSpeakerimpl(stageRolesM54getUserStageRoletwRsX0.m35unboximpl()) ? 0 : 8);
        textView2.setEnabled(!viewState.isUpdatingSuppressed());
    }
}
