package com.discord.widgets.servers.settings.invites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.core.view.OneShotPreDrawListener;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsInstantInviteListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem extends MGRecyclerViewHolder<WidgetServerSettingsInstantInvites.Adapter, WidgetServerSettingsInstantInvites.Model.InviteItem> {
    private final WidgetServerSettingsInstantInviteListItemBinding binding;
    private CountDownTimer countdownTimer;
    private String currentInviteCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvitesListItem(WidgetServerSettingsInstantInvites.Adapter adapter) {
        super(R.layout.widget_server_settings_instant_invite_list_item, adapter);
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        View view = this.itemView;
        int i = R.id.invite_barrier_1;
        Barrier barrier = (Barrier) view.findViewById(R.id.invite_barrier_1);
        if (barrier != null) {
            i = R.id.invite_barrier_2;
            Barrier barrier2 = (Barrier) view.findViewById(R.id.invite_barrier_2);
            if (barrier2 != null) {
                i = R.id.invite_channel;
                TextView textView = (TextView) view.findViewById(R.id.invite_channel);
                if (textView != null) {
                    i = R.id.invite_code;
                    TextView textView2 = (TextView) view.findViewById(R.id.invite_code);
                    if (textView2 != null) {
                        i = R.id.invite_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.invite_container);
                        if (linearLayout != null) {
                            i = R.id.invite_divider;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.invite_divider);
                            if (frameLayout != null) {
                                i = R.id.invite_expiration_container;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.invite_expiration_container);
                                if (linearLayout2 != null) {
                                    i = R.id.invite_expiration_time;
                                    TextView textView3 = (TextView) view.findViewById(R.id.invite_expiration_time);
                                    if (textView3 != null) {
                                        i = R.id.invite_settings_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.invite_settings_icon);
                                        if (imageView != null) {
                                            i = R.id.invite_uses;
                                            TextView textView4 = (TextView) view.findViewById(R.id.invite_uses);
                                            if (textView4 != null) {
                                                i = R.id.invite_uses_container;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.invite_uses_container);
                                                if (linearLayout3 != null) {
                                                    i = R.id.settings_member;
                                                    SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member);
                                                    if (settingsMemberView != null) {
                                                        WidgetServerSettingsInstantInviteListItemBinding widgetServerSettingsInstantInviteListItemBinding = new WidgetServerSettingsInstantInviteListItemBinding((CardView) view, barrier, barrier2, textView, textView2, linearLayout, frameLayout, linearLayout2, textView3, imageView, textView4, linearLayout3, settingsMemberView);
                                                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsInstantInviteListItemBinding, "WidgetServerSettingsInst…temBinding.bind(itemView)");
                                                        this.binding = widgetServerSettingsInstantInviteListItemBinding;
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsInstantInvites.Adapter access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem widgetServerSettingsInstantInvitesListItem) {
        return (WidgetServerSettingsInstantInvites.Adapter) widgetServerSettingsInstantInvitesListItem.adapter;
    }

    private final void cancelTimer() {
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countdownTimer = null;
        this.currentInviteCode = null;
    }

    private final String getUsesText(ModelInvite invite) {
        int uses = invite.getUses();
        int maxUses = invite.getMaxUses();
        String strValueOf = String.valueOf(uses);
        if (maxUses <= 0) {
            return strValueOf;
        }
        return strValueOf + " / " + maxUses;
    }

    @SuppressLint({"SetTextI18n"})
    private final void setCountdownText(long timeToExpiration) {
        long j = 60;
        int i = (int) ((timeToExpiration / 1000) % j);
        int i2 = (int) ((timeToExpiration / 60000) % j);
        long j2 = 24;
        int i3 = (int) ((timeToExpiration / 3600000) % j2);
        int i4 = (int) ((timeToExpiration / 86400000) % j2);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteExpirationTime");
        String str = String.format("%02d:%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}, 4));
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
        textView.setText(str);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteExpirationTime");
        textView2.setTextColor(ColorCompat.getColor(textView2, R.color.status_green_500_dark));
    }

    private final void setupExpirationTime(final ModelInvite invite) {
        if (invite.getMaxAge() == 0) {
            this.binding.d.setText(R.string.max_age_never);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteExpirationTime");
            textView.setTextColor(ColorCompat.getColor(textView, R.color.grey_1));
            cancelTimer();
            return;
        }
        if (invite.getTimeToExpirationMillis() <= 0) {
            setCountdownText(0L);
            cancelTimer();
            return;
        }
        if ((!Intrinsics3.areEqual(invite.code, this.currentInviteCode)) || this.currentInviteCode == null) {
            setCountdownText(invite.getTimeToExpirationMillis());
            cancelTimer();
            this.currentInviteCode = invite.code;
            CountDownTimer countDownTimer = new CountDownTimer(invite.getTimeToExpirationMillis(), 1000L) { // from class: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem.setupExpirationTime.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    WidgetServerSettingsInstantInvitesListItem.this.setCountdownText(0L);
                    WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem.this).onInviteExpired(invite);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    WidgetServerSettingsInstantInvitesListItem.this.setCountdownText(millisUntilFinished);
                }
            };
            this.countdownTimer = countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.start();
            }
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final WidgetServerSettingsInstantInvites.Model.InviteItem data) {
        String strD;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        User inviter = data.getInvite().getInviter();
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem.this).onInviteSelected(data.getInvite());
            }
        });
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteCode");
        textView.setText(data.getInvite().code);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteUses");
        textView2.setText(getUsesText(data.getInvite()));
        TextView textView3 = this.binding.f2574b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.inviteChannel");
        Channel channel = data.getInvite().getChannel();
        if (channel != null) {
            TextView textView4 = this.binding.f2574b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.inviteChannel");
            Context context = textView4.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.inviteChannel.context");
            strD = ChannelUtils.d(channel, context, true);
        } else {
            strD = null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, strD);
        SettingsMemberView settingsMemberView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.settingsMember");
        settingsMemberView.setVisibility(inviter != null ? 0 : 8);
        if (inviter != null) {
            this.binding.f.a(new CoreUser(inviter), data.getGuildMember());
            SettingsMemberView settingsMemberView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView2, "binding.settingsMember");
            settingsMemberView2.setVisibility(0);
        } else {
            SettingsMemberView settingsMemberView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView3, "binding.settingsMember");
            settingsMemberView3.setVisibility(8);
        }
        setupExpirationTime(data.getInvite());
        final TextView textView5 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.inviteExpirationTime");
        Intrinsics3.checkNotNullExpressionValue(OneShotPreDrawListener.add(textView5, new Runnable() { // from class: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View view = textView5;
                view.setMinimumWidth(DimenUtils.dpToPixels(4) + view.getWidth());
            }
        }), "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
    }
}
