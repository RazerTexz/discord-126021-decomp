package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.a.d.d0;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$ChannelBenefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$IntangibleBenefit;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitViewModel extends d0<GuildRoleSubscriptionTierBenefitViewModel$ViewState> {
    private final GuildRoleSubscriptionBenefitType benefitType;
    private final PublishSubject<GuildRoleSubscriptionTierBenefitViewModel$Event> eventSubject;
    private final String tierName;

    public /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRoleSubscriptionBenefitType, str, (i & 4) != 0 ? null : benefit);
    }

    public final String getTierName() {
        return this.tierName;
    }

    public final Observable<GuildRoleSubscriptionTierBenefitViewModel$Event> observeEvents() {
        PublishSubject<GuildRoleSubscriptionTierBenefitViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    public final void submitResult() {
        Benefit benefit$ChannelBenefit;
        Benefit benefit;
        GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState = requireViewState();
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                benefit = null;
            } else {
                String name = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getName();
                if (name == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                Emoji emoji = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getEmoji();
                if (emoji == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                benefit$ChannelBenefit = new Benefit$IntangibleBenefit(name, emoji, guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getDescription());
            }
            if (benefit != null) {
                PublishSubject<GuildRoleSubscriptionTierBenefitViewModel$Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult(benefit));
            }
        }
        String name2 = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getName();
        if (name2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Emoji emoji2 = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getEmoji();
        if (emoji2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String description = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getDescription();
        Integer leadingNameIconResId = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getLeadingNameIconResId();
        Long channelId = guildRoleSubscriptionTierBenefitViewModel$ViewStateRequireViewState.getChannelId();
        if (channelId == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        benefit$ChannelBenefit = new Benefit$ChannelBenefit(name2, emoji2, description, leadingNameIconResId, channelId.longValue());
        benefit = benefit$ChannelBenefit;
        if (benefit != null) {
            PublishSubject<GuildRoleSubscriptionTierBenefitViewModel$Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(new GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult(benefit));
        }
    }

    public final void updateChannel(long channelId, String channelName, Integer channelIconResId) {
        m.checkNotNullParameter(channelName, "channelName");
        updateViewState2(GuildRoleSubscriptionTierBenefitViewModel$ViewState.copy$default(requireViewState(), false, channelName, null, channelIconResId, null, null, Long.valueOf(channelId), 53, null));
    }

    public final void updateDescription(String description) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState2(GuildRoleSubscriptionTierBenefitViewModel$ViewState.copy$default(requireViewState(), false, null, null, null, null, description, null, 95, null));
    }

    public final void updateEmoji(Emoji emoji) {
        updateViewState2(GuildRoleSubscriptionTierBenefitViewModel$ViewState.copy$default(requireViewState(), false, null, null, null, emoji, null, null, 111, null));
    }

    public final void updateName(String name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        updateViewState2(GuildRoleSubscriptionTierBenefitViewModel$ViewState.copy$default(requireViewState(), false, name, null, null, null, null, null, Opcodes.LUSHR, null));
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewState) {
        updateViewState2(guildRoleSubscriptionTierBenefitViewModel$ViewState);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierBenefitViewModel(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str, Benefit benefit) {
        m.checkNotNullParameter(guildRoleSubscriptionBenefitType, "benefitType");
        boolean z2 = benefit != null;
        String name = benefit != null ? benefit.getName() : null;
        boolean z3 = benefit instanceof Benefit$ChannelBenefit;
        Benefit$ChannelBenefit benefit$ChannelBenefit = (Benefit$ChannelBenefit) (!z3 ? null : benefit);
        Long lValueOf = benefit$ChannelBenefit != null ? Long.valueOf(benefit$ChannelBenefit.getChannelId()) : null;
        Benefit$ChannelBenefit benefit$ChannelBenefit2 = (Benefit$ChannelBenefit) (!z3 ? null : benefit);
        super(new GuildRoleSubscriptionTierBenefitViewModel$ViewState(z2, name, str, benefit$ChannelBenefit2 != null ? benefit$ChannelBenefit2.getChannelIconResId() : null, benefit != null ? benefit.getEmoji() : null, benefit != null ? benefit.getDescription() : null, lValueOf));
        this.benefitType = guildRoleSubscriptionBenefitType;
        this.tierName = str;
        this.eventSubject = PublishSubject.k0();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d  */
    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(GuildRoleSubscriptionTierBenefitViewModel$ViewState viewState) {
        boolean z2;
        m.checkNotNullParameter(viewState, "viewState");
        int iOrdinal = this.benefitType.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                String name = viewState.getName();
                if (!(name == null || t.isBlank(name)) && viewState.getEmoji() != null) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            String name2 = viewState.getName();
            if ((name2 == null || t.isBlank(name2)) || viewState.getEmoji() == null || viewState.getChannelId() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        super.updateViewState(GuildRoleSubscriptionTierBenefitViewModel$ViewState.copy$default(viewState, z2, null, null, null, null, null, null, 126, null));
    }
}
