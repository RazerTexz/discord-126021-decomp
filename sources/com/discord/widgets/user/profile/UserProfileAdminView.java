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
import com.discord.C5419R;
import com.discord.databinding.UserProfileAdminViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserProfileAdminView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileAdminView extends LinearLayout {
    private final UserProfileAdminViewBinding binding;

    /* JADX INFO: compiled from: UserProfileAdminView.kt */
    public static final /* data */ class ViewState {
        private final boolean isAdminSectionEnabled;
        private final boolean isCommunicationDisabled;
        private final boolean isMe;
        private final boolean isMultiUserDM;
        private final boolean isServerDeafened;
        private final boolean isServerMuted;
        private final boolean showBanButton;
        private final boolean showDisableCommunicationButton;
        private final boolean showEditMemberButton;
        private final boolean showKickButton;
        private final boolean showServerDeafenButton;
        private final boolean showServerMoveAndDisconnectButtons;
        private final boolean showServerMuteButton;

        public ViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.showEditMemberButton = z2;
            this.showKickButton = z3;
            this.showDisableCommunicationButton = z4;
            this.isMultiUserDM = z5;
            this.showBanButton = z6;
            this.showServerMuteButton = z7;
            this.isServerMuted = z8;
            this.showServerDeafenButton = z9;
            this.isServerDeafened = z10;
            this.showServerMoveAndDisconnectButtons = z11;
            this.isAdminSectionEnabled = z12;
            this.isMe = z13;
            this.isCommunicationDisabled = z14;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getIsCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMultiUserDM() {
            return this.isMultiUserDM;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsServerMuted() {
            return this.isServerMuted;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsServerDeafened() {
            return this.isServerDeafened;
        }

        public final ViewState copy(boolean showEditMemberButton, boolean showKickButton, boolean showDisableCommunicationButton, boolean isMultiUserDM, boolean showBanButton, boolean showServerMuteButton, boolean isServerMuted, boolean showServerDeafenButton, boolean isServerDeafened, boolean showServerMoveAndDisconnectButtons, boolean isAdminSectionEnabled, boolean isMe, boolean isCommunicationDisabled) {
            return new ViewState(showEditMemberButton, showKickButton, showDisableCommunicationButton, isMultiUserDM, showBanButton, showServerMuteButton, isServerMuted, showServerDeafenButton, isServerDeafened, showServerMoveAndDisconnectButtons, isAdminSectionEnabled, isMe, isCommunicationDisabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showEditMemberButton == viewState.showEditMemberButton && this.showKickButton == viewState.showKickButton && this.showDisableCommunicationButton == viewState.showDisableCommunicationButton && this.isMultiUserDM == viewState.isMultiUserDM && this.showBanButton == viewState.showBanButton && this.showServerMuteButton == viewState.showServerMuteButton && this.isServerMuted == viewState.isServerMuted && this.showServerDeafenButton == viewState.showServerDeafenButton && this.isServerDeafened == viewState.isServerDeafened && this.showServerMoveAndDisconnectButtons == viewState.showServerMoveAndDisconnectButtons && this.isAdminSectionEnabled == viewState.isAdminSectionEnabled && this.isMe == viewState.isMe && this.isCommunicationDisabled == viewState.isCommunicationDisabled;
        }

        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r0v25, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v17, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21, types: [int] */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v33 */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r2v41 */
        /* JADX WARN: Type inference failed for: r2v42 */
        /* JADX WARN: Type inference failed for: r2v43 */
        /* JADX WARN: Type inference failed for: r2v44 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean z2 = this.showEditMemberButton;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showKickButton;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.showDisableCommunicationButton;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isMultiUserDM;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.showBanButton;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z7 = this.showServerMuteButton;
            ?? r6 = z7;
            if (z7) {
                r6 = 1;
            }
            int i6 = (i5 + r6) * 31;
            boolean z8 = this.isServerMuted;
            ?? r7 = z8;
            if (z8) {
                r7 = 1;
            }
            int i7 = (i6 + r7) * 31;
            boolean z9 = this.showServerDeafenButton;
            ?? r8 = z9;
            if (z9) {
                r8 = 1;
            }
            int i8 = (i7 + r8) * 31;
            boolean z10 = this.isServerDeafened;
            ?? r9 = z10;
            if (z10) {
                r9 = 1;
            }
            int i9 = (i8 + r9) * 31;
            boolean z11 = this.showServerMoveAndDisconnectButtons;
            ?? r10 = z11;
            if (z11) {
                r10 = 1;
            }
            int i10 = (i9 + r10) * 31;
            boolean z12 = this.isAdminSectionEnabled;
            ?? r11 = z12;
            if (z12) {
                r11 = 1;
            }
            int i11 = (i10 + r11) * 31;
            boolean z13 = this.isMe;
            ?? r12 = z13;
            if (z13) {
                r12 = 1;
            }
            int i12 = (i11 + r12) * 31;
            boolean z14 = this.isCommunicationDisabled;
            return i12 + (z14 ? 1 : z14);
        }

        public final boolean isAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        public final boolean isCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public final boolean isMultiUserDM() {
            return this.isMultiUserDM;
        }

        public final boolean isServerDeafened() {
            return this.isServerDeafened;
        }

        public final boolean isServerMuted() {
            return this.isServerMuted;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(showEditMemberButton=");
            sbM833U.append(this.showEditMemberButton);
            sbM833U.append(", showKickButton=");
            sbM833U.append(this.showKickButton);
            sbM833U.append(", showDisableCommunicationButton=");
            sbM833U.append(this.showDisableCommunicationButton);
            sbM833U.append(", isMultiUserDM=");
            sbM833U.append(this.isMultiUserDM);
            sbM833U.append(", showBanButton=");
            sbM833U.append(this.showBanButton);
            sbM833U.append(", showServerMuteButton=");
            sbM833U.append(this.showServerMuteButton);
            sbM833U.append(", isServerMuted=");
            sbM833U.append(this.isServerMuted);
            sbM833U.append(", showServerDeafenButton=");
            sbM833U.append(this.showServerDeafenButton);
            sbM833U.append(", isServerDeafened=");
            sbM833U.append(this.isServerDeafened);
            sbM833U.append(", showServerMoveAndDisconnectButtons=");
            sbM833U.append(this.showServerMoveAndDisconnectButtons);
            sbM833U.append(", isAdminSectionEnabled=");
            sbM833U.append(this.isAdminSectionEnabled);
            sbM833U.append(", isMe=");
            sbM833U.append(this.isMe);
            sbM833U.append(", isCommunicationDisabled=");
            return C1643a.m827O(sbM833U, this.isCommunicationDisabled, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileAdminView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_profile_admin_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.user_profile_admin_ban;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_ban);
        if (textView != null) {
            i = C5419R.id.user_profile_admin_disable_communication;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_disable_communication);
            if (textView2 != null) {
                i = C5419R.id.user_profile_admin_edit_member;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_edit_member);
                if (textView3 != null) {
                    i = C5419R.id.user_profile_admin_kick;
                    TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_kick);
                    if (textView4 != null) {
                        i = C5419R.id.user_profile_admin_server_deafen;
                        TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_deafen);
                        if (textView5 != null) {
                            i = C5419R.id.user_profile_admin_server_disconnect;
                            TextView textView6 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_disconnect);
                            if (textView6 != null) {
                                i = C5419R.id.user_profile_admin_server_move;
                                TextView textView7 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_move);
                                if (textView7 != null) {
                                    i = C5419R.id.user_profile_admin_server_mute;
                                    TextView textView8 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_mute);
                                    if (textView8 != null) {
                                        UserProfileAdminViewBinding userProfileAdminViewBinding = new UserProfileAdminViewBinding((LinearLayout) viewInflate, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                        C12238m.checkNotNullExpressionValue(userProfileAdminViewBinding, "UserProfileAdminViewBind…rom(context), this, true)");
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

    public final void setOnBan(final Function0<Unit> onBan) {
        C12238m.checkNotNullParameter(onBan, "onBan");
        this.binding.f15327b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnBan.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onBan.invoke();
            }
        });
    }

    public final void setOnDisableCommunication(final Function0<Unit> onDisableCommunication) {
        C12238m.checkNotNullParameter(onDisableCommunication, "onDisableCommunication");
        this.binding.f15328c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnDisableCommunication.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDisableCommunication.invoke();
            }
        });
    }

    public final void setOnDisconnect(final Function0<Unit> onDisconnect) {
        C12238m.checkNotNullParameter(onDisconnect, "onDisconnect");
        this.binding.f15332g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnDisconnect.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDisconnect.invoke();
            }
        });
    }

    public final void setOnEditMember(final Function0<Unit> onEditMember) {
        C12238m.checkNotNullParameter(onEditMember, "onEditMember");
        this.binding.f15329d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnEditMember.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onEditMember.invoke();
            }
        });
    }

    public final void setOnKick(final Function0<Unit> onKick) {
        C12238m.checkNotNullParameter(onKick, "onKick");
        this.binding.f15330e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnKick.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onKick.invoke();
            }
        });
    }

    public final void setOnServerDeafen(final Function0<Unit> onServerDeafen) {
        C12238m.checkNotNullParameter(onServerDeafen, "onServerDeafen");
        this.binding.f15331f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnServerDeafen.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onServerDeafen.invoke();
            }
        });
    }

    public final void setOnServerMove(final Function0<Unit> onServerMove) {
        C12238m.checkNotNullParameter(onServerMove, "onServerMove");
        this.binding.f15333h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnServerMove.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onServerMove.invoke();
            }
        });
    }

    public final void setOnServerMute(final Function0<Unit> onServerMute) {
        C12238m.checkNotNullParameter(onServerMute, "onServerMute");
        this.binding.f15334i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileAdminView.setOnServerMute.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onServerMute.invoke();
            }
        });
    }

    public final void updateView(ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        TextView textView = this.binding.f15329d;
        C12238m.checkNotNullExpressionValue(textView, "binding.userProfileAdminEditMember");
        textView.setVisibility(viewState.getShowEditMemberButton() ? 0 : 8);
        TextView textView2 = this.binding.f15330e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.userProfileAdminKick");
        textView2.setVisibility(viewState.getShowKickButton() ? 0 : 8);
        TextView textView3 = this.binding.f15328c;
        C12238m.checkNotNullExpressionValue(textView3, "binding.userProfileAdminDisableCommunication");
        textView3.setVisibility(viewState.getShowDisableCommunicationButton() ? 0 : 8);
        this.binding.f15330e.setText(viewState.isMultiUserDM() ? C5419R.string.remove_from_group : C5419R.string.kick);
        TextView textView4 = this.binding.f15327b;
        C12238m.checkNotNullExpressionValue(textView4, "binding.userProfileAdminBan");
        textView4.setVisibility(viewState.getShowBanButton() ? 0 : 8);
        boolean zIsCommunicationDisabled = viewState.isCommunicationDisabled();
        int i = zIsCommunicationDisabled ? C5419R.string.remove_time_out : C5419R.string.time_out;
        Drawable drawable = zIsCommunicationDisabled ? ContextCompat.getDrawable(getContext(), C5419R.drawable.ic_enable_guild_communication_24dp) : ContextCompat.getDrawable(getContext(), C5419R.drawable.ic_disable_guild_communication_red_24dp);
        this.binding.f15328c.setText(i);
        TextView textView5 = this.binding.f15328c;
        C12238m.checkNotNullExpressionValue(textView5, "binding.userProfileAdminDisableCommunication");
        DrawableCompat.setCompoundDrawablesCompat$default(textView5, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView6 = this.binding.f15334i;
        C12238m.checkNotNullExpressionValue(textView6, "binding.userProfileAdminServerMute");
        textView6.setVisibility(viewState.getShowServerMuteButton() ? 0 : 8);
        boolean zIsServerMuted = viewState.isServerMuted();
        boolean zIsMe = viewState.isMe();
        int themedDrawableRes$default = zIsServerMuted ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_mic_muted_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_mic_grey, 0, 2, (Object) null);
        int i2 = zIsServerMuted ? C5419R.string.server_unmute : C5419R.string.server_mute;
        TextView textView7 = this.binding.f15334i;
        C12238m.checkNotNullExpressionValue(textView7, "binding.userProfileAdminServerMute");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView7, themedDrawableRes$default, 0, 0, 0, 14, null);
        this.binding.f15334i.setText(i2);
        TextView textView8 = this.binding.f15331f;
        C12238m.checkNotNullExpressionValue(textView8, "binding.userProfileAdminServerDeafen");
        textView8.setVisibility(viewState.getShowServerDeafenButton() ? 0 : 8);
        boolean zIsServerDeafened = viewState.isServerDeafened();
        int themedDrawableRes$default2 = zIsServerDeafened ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_headset_deafened_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_headset_deafened_grey, 0, 2, (Object) null);
        int i3 = zIsServerDeafened ? C5419R.string.server_undeafen : C5419R.string.server_deafen;
        int i4 = zIsMe ? C5419R.string.disconnect_self : C5419R.string.disconnect_other;
        TextView textView9 = this.binding.f15331f;
        C12238m.checkNotNullExpressionValue(textView9, "binding.userProfileAdminServerDeafen");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView9, themedDrawableRes$default2, 0, 0, 0, 14, null);
        this.binding.f15331f.setText(i3);
        TextView textView10 = this.binding.f15333h;
        C12238m.checkNotNullExpressionValue(textView10, "binding.userProfileAdminServerMove");
        textView10.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
        this.binding.f15332g.setText(i4);
        TextView textView11 = this.binding.f15332g;
        C12238m.checkNotNullExpressionValue(textView11, "binding.userProfileAdminServerDisconnect");
        textView11.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
    }
}
